package classes;

import java.util.*;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Province {
    private String nom;
    private int[] pointsFaveur;
    private int nbtroupes;
    private Troupes troupe;
    private LinkedList<TuileBonus> lltuilebonus;
    private Controle[] controle;
    private final int POINTSFINAUX = 6;

    /* Constructor */
    public Province(String nom, int[] pointsFaveur, int nbtroupes) {
        this.nom = nom;
        this.pointsFaveur = pointsFaveur;
        this.nbtroupes = nbtroupes;
        this.lltuilebonus = new LinkedList<TuileBonus>();
        this.controle = new Controle[4];
    }
    
    public Province(String nom, int[] pointsFaveur, int nbtroupes, Troupes troupe) {
        this.nom = nom;
        this.pointsFaveur = pointsFaveur;
        this.nbtroupes = nbtroupes;
        this.troupe = troupe;
        this.lltuilebonus = new LinkedList<TuileBonus>();
        this.controle = new Controle[4];
    }

    public Province(String nom, int[] pointsFaveur, int nbtroupes, Troupes troupe, LinkedList<TuileBonus> ltb, Controle[] controle) {
        this.nom = nom;
        this.pointsFaveur = pointsFaveur;
        this.nbtroupes = nbtroupes;
        this.troupe = troupe;
        this.lltuilebonus = ltb;
        this.controle = controle;
    }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int[] getPointsFaveur() {
        return pointsFaveur;
    }

    public void setPointsFaveur(int[] pointsFaveur) {
        this.pointsFaveur = pointsFaveur;
    }

    public int getNbtroupes() {
        return nbtroupes;
    }

    public void setNbtroupes(int nbtroupes) {
        this.nbtroupes = nbtroupes;
    }

    public Troupes getTroupe() {
        return troupe;
    }

    public void setTroupe(Troupes troupe) {
        this.troupe = troupe;
    }

    public LinkedList<TuileBonus> getLltuilebonus() {
        return lltuilebonus;
    }

    public void setLltuilebonus(LinkedList<TuileBonus> lltuilebonus) {
        this.lltuilebonus = lltuilebonus;
    }

    public Controle[] getControle() {
        return controle;
    }

    public void setControle(Controle[] controle) {
        this.controle = controle;
    }
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.nom);
        hash = 13 * hash + Arrays.hashCode(this.pointsFaveur);
        hash = 13 * hash + this.nbtroupes;
        hash = 13 * hash + Objects.hashCode(this.troupe);
        hash = 13 * hash + Objects.hashCode(this.lltuilebonus);
        hash = 13 * hash + Arrays.deepHashCode(this.controle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Province other = (Province) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Arrays.equals(this.pointsFaveur, other.pointsFaveur)) {
            return false;
        }
        if (this.nbtroupes != other.nbtroupes) {
            return false;
        }
        if (!Objects.equals(this.troupe, other.troupe)) {
            return false;
        }
        if (!Objects.equals(this.lltuilebonus, other.lltuilebonus)) {
            return false;
        }
        if (!Arrays.deepEquals(this.controle, other.controle)) {
            return false;
        }
        return true;
    }
    

/* Methodes */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nom).append(" - ");
        for(int i=0; i<pointsFaveur.length; i++){
            if(this.controle[i] == null){
                sb.append(pointsFaveur[i]).append(" ");
            }
        }
        sb.append("- ");
        // Affichage du nombre de troupes selon l'état de la liste de tuile bonus
        if(this.lltuilebonus.isEmpty()){sb.append(this.nbtroupes).append(" troupes ").append(troupe);}
        else{ sb.append(this.nbtroupes-1).append(" troupes ").append(troupe).append(" + ").append(lltuilebonus.getLast()); }

        return new String(sb);
    }
    
    /**
     * On estime que la tuile bonus visible est une troupe
     * @return TuileBonus si la liste comprend encore des tuiles, null sinon
     */
    public TuileBonus bonusCommeTroupe(){
        if(this.lltuilebonus.size() > 0){
            return this.lltuilebonus.getLast();
        }
        return null;
    }
    /**
     * Méthodes qui indique si on peut encore essayer de controler la province
     * @return true si le province est déjà controlée (4 kamon sont déjà placés), false sinon
     */
    public boolean provinceSousControle(){
        if(this.controle[3] != null)
            return true;
        return false;
    }
    
    /**
     * Méthodes qui calcul le nombre de kokus nécessaires pour prendre la province
     * @return 
     */
    public int nbKokusNecessaires(){
        if(!provinceSousControle()){
            for(int i=0; i<controle.length; i++){
                if(controle[i] == null && i > 0){
                    return pointsFaveur[i-1];
                }
                if(controle[i] == null && i == 0){
                    return pointsFaveur[i];
                }
            }
        }
        return 0;
    }
    
    /**
     * Méthode qui vérifie que le joueur j a bien posé un kamon dans cette province
     * @param j
     * @return 
     */
    public boolean aUnKamonDansLaProvince(Joueur j){
        if(this.controle[0] != null){
            for(Controle c : this.controle){
                if(c.getJoueur().getPseudo().equals(j.getPseudo())){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Nombre de kamons posés dans la province (entre 0 et 4)
     * @return le nombre de kamons posés
     */
    public int tauxDeRemplissageControle(){
        int i = 0;
        for(Controle c : this.controle){
            if(c != null){i++;}
            else{break;}
        }
        return i;
    }
    
    /**
     * Méthode qui retourne une liste de tous les joueurs ayant envahie la province 
     * @return liste des joueurs ayant envahies la province
     */
    public ArrayList<Joueur> tousLesJoueursAyantUnKamon(){
        ArrayList<Joueur> alj = new ArrayList<>();
        int nbKamons = tauxDeRemplissageControle();
        boolean stop = false;

        for (int i = 0; i < nbKamons; i++) {
            Joueur j = this.controle[i].getJoueur();
            // On ajoute dans la liste le premier joueur ayant pris le controle de la province
            if (!alj.isEmpty()) {
                if(alj.size() > 1){
                    stop = false;
                    for (Joueur jo : alj) {
                        if (jo.getPseudo().equals(j.getPseudo())) {
                            stop = true;
                            break;
                        }
                    }
                    if(!stop){
                        alj.add(j);
                    }
                }
                else{
                    if(!alj.get(0).getPseudo().equals(j.getPseudo())){
                        alj.add(j);
                    }
                }
            } 
            else {
                alj.add(j);
            }
        }
        return alj;
    }
    
    /**
     * Méthode qui renvoie un tableau de score. Chaque cellule de ce tableau correspond au score d'un joueur
     * @param tauxRemplissage nombre de kamons posés dans la province
     * @return un tableau de score (supposé lié à la liste de joueurs ayant envahie la province)
     */
    public int[] compteLesPointsParJoueur(ArrayList<Joueur> alj, int tauxRemplissage){
        int[] tabNbKamon = new int[alj.size()];
        int inc = 0, cpt = 0;
           
        // Pour chaque joueur répertorié dans la province, on compte les points qu'il a (1 = kamon simple, 2 = kamon doré)
        // Le résultat est mis dans un tableau (on respecte l'ordre de l'arraylist pour garder le trie
        for(Joueur j : alj){
            cpt = 0;
            for(int i=0; i<tauxRemplissage; i++){
                String pseudo = this.controle[i].getJoueur().getPseudo();
                if(j.getPseudo().equals(pseudo)){
                    if(this.controle[i].isIsGolden()){
                        cpt++;
                    }
                    cpt++;
                }
            }
            tabNbKamon[inc++] = cpt;
        }
        return tabNbKamon;
    }
    
    
    public int indiceDuMeilleurScoreur(int[] tabNbKamon){
        // On retourne le joueur qui a le plus grand score ou celui qui est le plus à gauche (si égalité)
        int meilleur = 0, indice = 0;    
        for(int i=0; i<tabNbKamon.length; i++){
            if(tabNbKamon[i] > meilleur){
                meilleur = tabNbKamon[i];
                indice = i;
            }
        }
        return indice;
    }
    
    
    public Joueur joueurMajoritaire(){
        int tauxRemplissage = tauxDeRemplissageControle();
        
        // Un seul kamon de placé dans la province ou alors deux et qu'aucun n'est retourné face doré, on retourne le joueur du premier kamon
        if(tauxRemplissage == 1 || (tauxRemplissage == 2 && !this.controle[1].isIsGolden())){
            return this.controle[0].getJoueur();
        }
        // On a deux kamons de posé et celui le plus a droite est face dorée (pour le plus à gauche, c'est le cas au-dessus)
        if(tauxRemplissage == 2 && this.controle[1].isIsGolden()){
            return this.controle[1].getJoueur();
        }
        
        if(tauxRemplissage > 2){
            ArrayList<Joueur> alj = tousLesJoueursAyantUnKamon();
            
            int[] tabNbKamon = compteLesPointsParJoueur(alj, tauxRemplissage);
            int indice = indiceDuMeilleurScoreur(tabNbKamon);
            
            return alj.get(indice);
            
        }
        return null;
    }
}
