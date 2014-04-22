package classes;

import java.util.*;
/**
 *
 * @author Damien
 * @version 1.0
 */
public class Joueur implements Comparable<Joueur>{
    private String pseudo;
    private int score;
    private General general;
    private int nbkamons;
    private ArrayList<CarteTroupe> alctroupe;
    private ArrayList<Kokus> alkokus;
    private ArrayList<Bonus> albonus;
    private Titre titre;
    private Titre hierarchie;

/* Constructors */
    public Joueur(){
        
    }

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
    }
    
    /**
     * Constructeur utile pour l'initialisation du joueur :
     * choix du pseudo, du général et nombre de kamons défini selon le nombre de joueurs
     * @param pseudo
     * @param general
     * @param nbkamons nombre de kamons défini selon le nombre de joueurs
     * @param score=0 au début du jeu le joueur n'a pas de points
     */
    public Joueur(String pseudo, General general, int nbkamons) {
        this.pseudo = pseudo;
        this.general = general;
        this.nbkamons = nbkamons;
        this.score = 0;
        this.alctroupe = new ArrayList<CarteTroupe>();
        this.alkokus = new ArrayList<Kokus>();
        this.albonus = new ArrayList<Bonus>();
        this.titre = null;
    }

    public Joueur(String pseudo, int nbkamons) {
        this.pseudo = pseudo;
        this.nbkamons = nbkamons;
        this.general = null;
        this.score = 0;
        this.alctroupe = new ArrayList<CarteTroupe>();
        this.alkokus = new ArrayList<Kokus>();
        this.albonus = new ArrayList<Bonus>();
        this.titre = null;
    }

    /* Getters & Setters */
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public int getNbkamons() {
        return nbkamons;
    }

    public void setNbkamons(int nbkamons) {
        this.nbkamons = nbkamons;
    }

    public ArrayList<CarteTroupe> getAlctroupe() {
        return alctroupe;
    }

    public void setAlctroupe(ArrayList<CarteTroupe> alctroupe) {
        this.alctroupe = alctroupe;
    }

    public ArrayList<Kokus> getAlkokus() {
        return alkokus;
    }

    public void setAlkokus(ArrayList<Kokus> alkokus) {
        this.alkokus = alkokus;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }

    public Titre getHierarchie() {
        return hierarchie;
    }

    public void setHierarchie(Titre hierarchie) {
        this.hierarchie = hierarchie;
    }

    public ArrayList<Bonus> getAlbonus() {
        return albonus;
    }

    public void setAlbonus(ArrayList<Bonus> albonus) {
        this.albonus = albonus;
    }
    
    
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pseudo);
        hash = 97 * hash + this.score;
        hash = 97 * hash + Objects.hashCode(this.general);
        hash = 97 * hash + this.nbkamons;
        hash = 97 * hash + Objects.hashCode(this.alctroupe);
        hash = 97 * hash + Objects.hashCode(this.alkokus);
        hash = 97 * hash + Objects.hashCode(this.albonus);
        hash = 97 * hash + Objects.hashCode(this.titre);
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
        final Joueur other = (Joueur) obj;
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.general, other.general)) {
            return false;
        }
        if (this.nbkamons != other.nbkamons) {
            return false;
        }
        if (!Objects.equals(this.alctroupe, other.alctroupe)) {
            return false;
        }
        if (!Objects.equals(this.alkokus, other.alkokus)) {
            return false;
        }
        if (!Objects.equals(this.albonus, other.albonus)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.hierarchie, other.hierarchie)) {
            return false;
        }
        return true;
    }

/* Methods */   
    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", score=" + score + ", general=" + general + ", nbkamons=" + nbkamons + ", alctroupe=" + alctroupe + ", alkokus=" + alkokus + ", albonus=" + albonus + ", titre=" + titre + ", hierarchie=" + hierarchie + '}';
    }

    @Override
    public int compareTo(Joueur j) {
        if(this.getTitre().getNbsceaux() < j.getTitre().getNbsceaux())
            return 1;
        if(this.getTitre().getNbsceaux() > j.getTitre().getNbsceaux())
            return -1;
        return 0;
    }
   
    /**
     * Retourn le nombre de Kamon que chaque joueur doit avoir en début de partie
     * Le nombre se calcul selon le nombre de joueur
     * @param nbjoueur nombre de joueur dans la partie
     * @return nbkamons nombre de kamons par joueur
     */
    public int nombreKamonInitial(int nbjoueur){
        int nbkamons = 0;
        
        if(nbjoueur == 2){
            nbkamons = 12;
        }
        if(nbjoueur == 3){
            nbkamons = 10;
        }
        if(nbjoueur == 4){
            nbkamons = 8;
        }
        
        return nbkamons;
    }
    
    /**
     * Demande de saisie des pseudo + vérification d'unicité de celui-ci
     * @param nbjoueur
     * @return 
     */
    public Set pseudoAlreadyUse(int nbjoueur){
        Set<Joueur> hjoueur = new HashSet<Joueur>();
        Scanner sc = new Scanner(System.in);
        boolean isAlreadyUsed = false;
        String pseudo = new String();
        
        for(int i=1; i<nbjoueur+1; i++){
            // On demande le pseudo du joueur i jusqu'à ce que celui-ci soit unique
            do{
                isAlreadyUsed = false;
                System.out.print("Pseudo pour le Joueur " + i +" : ");
                pseudo = sc.nextLine();
                
                for(Joueur j : hjoueur){
                    if(j.getPseudo().equals(pseudo)){
                        isAlreadyUsed = true;
                        System.err.println("Ce pseudo a déjà été choisi !");
                        break;
                    }
                }
            }while(isAlreadyUsed);
            
            isAlreadyUsed = false;
            Joueur j = new Joueur(pseudo, nombreKamonInitial(nbjoueur));
            hjoueur.add(j);
        }
        
        return hjoueur;
    }
    
    /**
     * Choix du général pour chaque joueur avec vérification de la saisie
     * Et impossibilité de prendre un général déjà sélectionné
     * @param hjoueur liste des joueurs
     * @param hgeneral liste des généraux
     */
    public void choixDuGeneral(Set<Joueur> hjoueur, Set<General> hgeneral){
        Scanner sc = new Scanner(System.in);
        String nomgeneral = new String();
        
        for(Joueur j : hjoueur){
            boolean isCorrect = false;
            // On vérifie que le choix du général est bien possible (pas déjà pris, existant)
            // Et on affecte ce général au joueur
            do{
                System.out.println("\n" + j.getPseudo() + ", quel général désirez-vous être ? ");
                // Affichage des généraux
                for(General g : hgeneral){
                    System.out.println(g.toString());
                }
                nomgeneral = sc.nextLine();
            
                // On ajoute le général au joueur s'il existe
                for(General g : hgeneral){
                    if(nomgeneral.equalsIgnoreCase(g.getNom())){
                        j.setGeneral(g);
                        hgeneral.remove(g);
                        isCorrect = true;
                        break;
                    }
                }
                if(!isCorrect){System.err.println("Le général que vous avez choisi n'existe pas !");}
            }while(!isCorrect);
        }
    }
    
    /**
     * Compte le nombre de cartes qu'un joueur a en main
     * @return 
     */
    public int nombreDeCartesEnMain(){
        return this.alctroupe.size() + this.alkokus.size();
    }
    
    /**
     * Fonction qui vérifie la saisie et la redemande si le mot inscrit est différent de 'accepter' ou 'refuser'
     * @return le mot saisie correctement
     */
    public String accepterOuRefuser(){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(!rep.equalsIgnoreCase("accepter") && !rep.equalsIgnoreCase("refuser")){
            System.out.println("");
            System.out.print("Désirez-vous l'accepter ou le refuser ? ");
            rep = sc.next();
            if(!rep.equalsIgnoreCase("accepter") && !rep.equalsIgnoreCase("refuser")){System.err.println("Seul les mot 'accepter' et 'refuser' sont autorisés ! ");}
        }
        return rep;
    } 
    
    /**
     * Fonction qui ajoute les cartes du lot soumis à la main du joueur, ainsi que la tuile de hiérarchie 
     * et enlève la tuile titre
     * @param lot 
     */
    public void cartesAcceptees(Lot lot){
        // On ajoute les nouvelles cartes à la main et on les tries
        if (lot.getAlct() != null) {
            this.alctroupe.addAll(lot.getAlct());
        }
        if (lot.getAlk() != null) {
            this.alkokus.addAll(lot.getAlk());
            Collections.sort(this.alkokus);
        }
        // On affecte la tuile hiérachie du lot
        this.hierarchie = lot.getTitre();
        // On retire la tuile titre pour ne pas reproser le lot
        this.titre = null;
    }
    
    /**
     * Fonction qui ajoute les cartes du lot soumis par le tairo, aux cartes que le joueur a déjà en main
     * Ou affiche un message si le joueur a refusé le lot.
     * @param tairo
     * @param lot
     * @return 
     */
    public String accepterRefuserLot(Joueur tairo, Lot lot){
        System.out.println(this.pseudo + ", votre Tairo " + tairo.getPseudo() + " vous propose le lot suivant : ");
        System.out.println(lot.toString());
        String rep = this.accepterOuRefuser();
        
        if(rep.equalsIgnoreCase("accepter")){
            System.out.println("");
            System.out.println("Vous venez d'accepter le lot !");
            System.out.println("Voici votre nouvelle main : ");
            // On met à jours les cartes dans la main du joueur
            this.cartesAcceptees(lot);
            // On affiche la nouvelle main et le nouveau titre
            System.out.println(this.alctroupe.toString());
            System.out.println(this.alkokus);
            System.out.println("Et vous passerez " + this.hierarchie + " à la fin de l'année.");
        }
        else{
            System.out.println("");
            System.out.println("Vous venez de refuser le lot ! Impossible de revenir sur votre décision !");
        }
        
        return rep;
    }
    
    /**
     * Echange les tuiles titres en fonction des tuiles hiérarchie
     * A ne lancer qu'une fois tout les lots formés
     * Hierarchie devient à null
     */
    public void changerHierachieEnTitre(){
        this.titre = this.hierarchie;
        this.hierarchie = null;
    }
    
    /**
     * On compte le nombre de province pouvant être contrôlées avec la main du joueur (en cartes troupes uniquement)
     * @param hProvince
     * @return 
     */
    public int controleProvincePossibleAvecTroupes(Set<Province> hProvince){
       int i = 0;
        
        System.out.println("Avec les cartes troupes que vous avez, vous pouvez prendre le contrôle de :");
        for (Province p : hProvince) {
            // if (aLesTroupesNecessairesAvecBonus(p) && !p.provinceSousControle()) {
            if (aLesTroupesNecessairesSeules(p) && !p.provinceSousControle()) {
                System.out.println("* " + p.toString());
                i++;
            }
        }
        return i;
    }
    
    /**
     * Méthode qui compte le nombre de kokus qu'à en main le joueur
     * @return le nombre de kokus en main
     */
    public int compteNbKokusEnMain(){
        int cpt = 0;
        if(!this.getAlkokus().isEmpty()){
            for(Kokus k : this.getAlkokus()){
                cpt += k.getNbkoku();
            }
        }
        return cpt;
    }
    
    /**
     * Méthode qui compte le nombre de troupe que le joueur a en main
     * @return le nombre de troupes (/!\ 1 carte troupe double = 2 troupes /!\)
     */
    public int compteTroupesEnMain(){
        int cpt = 0;
        for(CarteTroupe ct : this.getAlctroupe()){
            if(ct.getTroupe2() == null){cpt++;}
            else{cpt += 2;}
        }
        
        return cpt;
    }
    
    /**
     * Méthodes qui compte le nombre de troupes susceptibles d'être jouées qu'a le joueur
     * @param p province dans laquelle on vérifie les troupes
     * @return nombre de troupes susceptibles d'être jouées
     */
    public int compteTroupesNecessaire(Province p){
        int cpt = 0;
        Troupes troupe1 = null, troupe2 = null;
        Troupes tProvince = p.getTroupe(), tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        
        // On compte le nombre de troupe correspondant à celle
        if(tProvince.equals(tBonus)){
            for(CarteTroupe ct : this.getAlctroupe()){
                troupe1 = ct.getTroupe1();
                troupe2 = ct.getTroupe2();
                if(troupe1.equals(tProvince) || troupe2.equals(tProvince)){
                    if(troupe2 == null){cpt++;}
                    else{
                        cpt++;
                        if(troupe1.equals(troupe2)){
                            cpt++;
                        }
                    }
                }
            }
        }
        
        return cpt;
    }
            
    /**
     * Méthodes qui indique qu'elles sont les provinces susceptibles d'être contrôlées
     * @param hProvince 
     */
    public void controleProvincePossible(Set<Province> hProvince){
        int i = 0;
        // Affichage des provinces susceptibles d'être contrôlées par des troupes uniquement
        i = controleProvincePossibleAvecTroupes(hProvince);       
        if(i == 0){System.out.println("... Aucune province ...");}
        System.out.println("");
        // Affichage des provinces susceptibles d'être contrôlées par des kokus uniquement
        i = controleProvincePossibleAvecKokus(hProvince);
        if(i == 0){System.out.println("... Aucune province ...");}
        System.out.println("");
    }

    /**
     * On vérifie la saisie quand au fait de vouloir envahir une province ou de vouloir passer son tour
     * @return rep qui est la réponse donnée (passer ou envahir)
     */
    public String envahirOuPasser(){
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        boolean envahir = rep.equalsIgnoreCase("envahir");
        boolean passer = rep.equalsIgnoreCase("passer");
        
        while(!envahir && !passer){
            System.err.print("Merci de faire votre choix parmi les deux possibles (Envahir ou Passer votre tour) : ");
            rep = sc.nextLine();
            envahir = rep.equalsIgnoreCase("envahir");
            passer = passer = rep.equalsIgnoreCase("passer");
        }
        
        return rep.toLowerCase();
    }
    
    /**
     * On demande le nom de la province à contrôler
     * Et on vérifie que celle-ci existe, sinon on redemande la saisie.
     * @return s le nom de la province
     */
    public Province demandeProvinceAControler(Set<Province> hProvinces){
        Scanner sc = new Scanner(System.in);
        String s = new String();
        
        while(true){
            s = sc.nextLine();
            for(Province p : hProvinces){
                if(p.getNom().equalsIgnoreCase(s)){
                    return p;
                }
            }
            System.err.println("Cette province n'est pas connue de nos services !");
            System.err.print("Veuillez en saisir une de connue : ");
        }
    }
    
    /**
     * En fonction des cartes troupes qu'on a en main, on compte le nombre de troupes correspondant à celle de la province
     * (ou de la tuile bonus puisque les deux sont identiques)
     * @param lct liste de carte troupe dans la main du joueur
     * @param tProvince troupe nécessaire pour contrôler la province
     * @return le nombre de troupe X dans la main du joueur
     */
    public int troupeProvinceAndTroupeBonus(List<CarteTroupe> lct, Troupes tProvince){
        Troupes troupe1 = null, troupe2 = null;
        int cpt = 0;
        
        for (CarteTroupe ct : lct) {
            troupe1 = ct.getTroupe1();
            troupe2 = ct.getTroupe2();
            if (troupe2 == null) {
                if (troupe1.equals(tProvince)) {
                    cpt++;
                }
            } 
            else {
                if (troupe1.equals(tProvince) || troupe2.equals(tProvince)) {
                    // On incrémente de 1 s'il s'agit d'une carte avec 2x la même troupe
                    if (troupe1.equals(troupe2)) {
                        cpt++;
                    }
                    cpt++;
                }
            }
        }
        return cpt;
    }
    
    /**
     * Dans la cas où les troupes sont différentes (entre province et bonus) on compte le nombre de troupe trouvées pour la province
     * et on supprime les cartes correspondantes pour ne plus les avoir lors de la vérif d'existence pour la tuile bonus
     * @param lct liste des cartes troupes du joueur
     * @param tProvince troupe de la province
     * @return le nombre de troupe nécessaire pour prendre le contrôle de la province (bonus exclue)
     */
    public int troupeProvinceOrTroupeBonus(List<CarteTroupe> lct, Troupes tProvince){
        Troupes troupe1 = null, troupe2 = null;
        List<CarteTroupe> temp = new ArrayList<>();
        int cpt = 0;
        
        for(CarteTroupe ct : lct){
            troupe1 = ct.getTroupe1();
            troupe2 = ct.getTroupe2();
            // Carte a troupe unique. On ne vérifie que la première troupe
            if (troupe2 == null) {
                if (troupe1.equals(tProvince)) {
                    temp.add(ct);
                    cpt++;
                }
            } // Carte à troupe double. Il faut tester les deux troupes et voir si elles sont identiques l'une à l'autre
            else {
                if (troupe1.equals(tProvince) || troupe2.equals(tProvince)) {
                    // On incrémente de 1 s'il s'agit d'une carte avec 2x la même troupe
                    if (troupe1.equals(tProvince) && troupe2.equals(tProvince)) {
                                // On ajoute à la liste de suppression seulement si les deux troupes sont différentes
                        // Car autrement l'autre troupe peut être nécessaire pour la tuile Bonus
                        temp.add(ct);
                        cpt++;
                    }
                    cpt++;
                }
            }
        }
        // On supprime toutes les cartes pour ne pas les revérifier pour la tuile bonus
        if(!temp.isEmpty()){lct.removeAll(temp);}
        
        return cpt;
    }
    
    /**
     * On vérifie que le joueur voulant prendre une province a bien les troupes nécessaires 
     * On vérifie donc en fonction de la tuile bonus, des troupes et du nombre de celles-ci
     * @param p
     * @return 
     */
    public boolean aLesTroupesNecessairesAvecBonus(Province p){
        Troupes tProvince = p.getTroupe();
        Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        List<CarteTroupe> lct = new ArrayList<>(this.alctroupe);
        Troupes troupe1 = null, troupe2 = null;
        int nbTroupes = p.getLltuilebonus().isEmpty() ? p.getNbtroupes() : p.getNbtroupes()-1;
        int cpt = 0;
        
        // On ne fait du traitement que si la liste de carte n'est pas vide
        if(!this.alctroupe.isEmpty()){
            // Les troupes bonus et de province sont équivalentes
            if(tProvince.equals(tBonus)){
                cpt = troupeProvinceAndTroupeBonus(lct, tProvince);
                if(cpt > nbTroupes+1 || cpt == nbTroupes+1){
                    return true;
                }
                if(cpt == nbTroupes && verifBonusDansMain("+1")){
                    return true;
                }
            }
            // Les troupes bonus et province sont différentes, on regarde donc si on a les cartes pour satisfaire les deux conditions
            else{        
                cpt = troupeProvinceOrTroupeBonus(lct, tProvince);
                // On retourne true s'il n'y a pas de tuiles bonus et qu'on a assez de cartes troupes utiles
                if(tBonus == null && ((cpt == nbTroupes || cpt > nbTroupes) || (cpt == nbTroupes-1 && verifBonusDansMain("+1")))){
                    return true;
                }
                if(tBonus != null && ((cpt == nbTroupes || cpt > nbTroupes) || (cpt == nbTroupes-1 && verifBonusDansMain("+1")))){
                    for(CarteTroupe ct : lct){
                        troupe1 = ct.getTroupe1();
                        troupe2 = ct.getTroupe2();
                        if(troupe2 == null){
                            if(troupe1.equals(tBonus)){
                                return true;
                            }
                        }
                        else{
                            if(troupe1.equals(tBonus) || troupe2.equals(tBonus)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean aLesTroupesNecessairesSeules(Province p){
        Troupes tProvince = p.getTroupe();
        Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        List<CarteTroupe> lct = new ArrayList<>(this.alctroupe);
        Troupes troupe1 = null, troupe2 = null;
        int nbTroupes = p.getLltuilebonus().isEmpty() ? p.getNbtroupes() : p.getNbtroupes()-1;
        int cpt = 0;
        
        // On ne fait du traitement que si la liste de carte n'est pas vide
        if(!this.alctroupe.isEmpty()){
            // Les troupes bonus et de province sont équivalentes
            if(tProvince.equals(tBonus)){
                cpt = troupeProvinceAndTroupeBonus(lct, tProvince);
                if(cpt > nbTroupes+1 || cpt == nbTroupes+1){
                    return true;
                }
            }
            // Les troupes bonus et province sont différentes, on regarde donc si on a les cartes pour satisfaire les deux conditions
            else{        
                cpt = troupeProvinceOrTroupeBonus(lct, tProvince);
                // On retourne true s'il n'y a pas de tuiles bonus et qu'on a assez de cartes troupes utiles
                if(tBonus == null && (cpt == nbTroupes || cpt > nbTroupes)){
                    return true;
                }
                if(tBonus != null && (cpt == nbTroupes || cpt > nbTroupes)){
                    for(CarteTroupe ct : lct){
                        troupe1 = ct.getTroupe1();
                        troupe2 = ct.getTroupe2();
                        if(troupe2 == null){
                            if(troupe1.equals(tBonus)){
                                return true;
                            }
                        }
                        else{
                            if(troupe1.equals(tBonus) || troupe2.equals(tBonus)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Vérifie l'existence d'une carte troupe dans la main du joueur
     * @param carte nom de la carte troupe à vérifieé
     * @return true si la carte existe dans sa main, false sinon
     */
    public boolean verifExistenceCarte(String carte){
        boolean existe = false;            
        // Traitement de vérification s'il s'agit d'une carte avec deux troupes
        if (carte.contains("&")) {
            String[] split = carte.split("&"); // Retourne un tableau du type ||Troupe1|Troupe2||
            for (CarteTroupe ct : this.alctroupe) {
                if ((split[0].trim().equalsIgnoreCase(ct.getTroupe1().getNom())) && (!existe)) {
                    existe = true;
                }
                if ((ct.getTroupe2() != null) && (split[1].trim().equalsIgnoreCase(ct.getTroupe2().getNom())) && existe) {
                    return true;
                }
            }
        } 
        else { // Il s'agit d'une carte troupe simple
            for (CarteTroupe ct : this.alctroupe) {
                if (carte.equalsIgnoreCase(ct.getTroupe1().getNom()) && ct.getTroupe2() == null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Fonction qui convertit une chaine de caractères en CarteTroupe
     * @param carte
     * @return 
     */
    public CarteTroupe convertirStringEnCarteTroupe(String carte){
        boolean presque = false;
        if(carte.contains("&")){
            String[] split = carte.split("&");
            for(CarteTroupe ct : this.alctroupe){
                if(split[0].trim().equalsIgnoreCase(ct.getTroupe1().getNom()) && (!presque)){
                    presque = true;
                }
                
                if((ct.getTroupe2() != null) && (split[1].trim().equalsIgnoreCase(ct.getTroupe2().getNom())) && presque){
                    return ct;
                }
                presque = false;
            }
        }
        else{
            for(CarteTroupe ct : this.alctroupe){
                if(carte.equalsIgnoreCase(ct.getTroupe1().getNom()) && ct.getTroupe2() == null){
                    return ct;
                }
            }
        }
        return null;
   }
    
    /**
     * On demande au joueur la(les) cartes dont il souhaite se défausser pour prendre
     * le contrôle d'une province.
     * @return s, le nom de la carte troupe
     */
    public CarteTroupe demandeCarteTroupeADefausser(){
        Scanner sc = new Scanner(System.in);
        String s = new String();
        Lot l = new Lot();
        boolean existe = false;
        
        while(!existe){
            System.out.print("De quelle carte Troupe voulez-vous vous défausser ? ");
            s = sc.nextLine();
            existe = verifExistenceCarte(s);
            if(!existe){
                System.err.println("Vous ne possédez pas cette carte !");
            }
        }
        return convertirStringEnCarteTroupe(s);
    }
    
    /**
     * On vérifie que la carte troupe choisit a bien une troupe en adéquation avec celle de la province
     * @param ct carte troupe à vérifier
     * @param p province dans laquelle on vérifie si la carte troupe peut-être jouée
     * @return true si la carte peut-être jouée, false sinon
     */
    public boolean rapportCarteTroupeProvince(CarteTroupe ct, Province p){
        // Retourne true s'il s'agit d'une carte unitroupe et qu'elle correspond à la troupe de la province        
        if(ct != null){
            if(ct.getTroupe2() == null && ct.getTroupe1().equals(p.getTroupe())){
                return true;
            }
            // Retourne si la carte comprend deux troupes et que l'une d'elles correspond à la troupe de la province
            if(ct.getTroupe2() != null && (ct.getTroupe1().equals(p.getTroupe()) || ct.getTroupe2().equals(p.getTroupe()))){
                return true;
            }
        }
        return false;
    }
    
    public boolean rapportCarteTroupeBonus(CarteTroupe ct, Troupes tBonus){
        // Retourne true s'il s'agit d'une carte unitroupe et qu'elle correspond à la troupe de la province
        if(ct != null){
            if(ct.getTroupe2() == null && ct.getTroupe1().equals(tBonus)){
                return true;
            }
            // Retourne si la carte comprend deux troupes et que l'une d'elles correspond à la troupe de la province
            if(ct.getTroupe2() != null && (ct.getTroupe1().equals(tBonus) || ct.getTroupe2().equals(tBonus))){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Indique le nombre de carte troupe équivalente à celle passée en paramètre on veut supprimer de la main du joueur. 
     * Le nombre doit être compris entre 0 et le maximum de carte troupes (si ce max est inférieur au nombre de troupe
     * dans la province).
     * Sinon égale au nombre de troupes dans la province
     * @param ct carte troupe dont on a besoin pour prendre le contrôle
     * @return nb le nombre de cartes 'xxx' à défausser.
     */
    public int nombreCarteTroupeADefausser(CarteTroupe ct, int nbMax){
        Scanner sc = new Scanner(System.in);
        int nb = 0;
        int cpt = 0;
        boolean isNumber = false;
        // On compte le nombre d'occurence de la carte dans la main du joueur
        for(CarteTroupe ctr : this.alctroupe){
            if(ctr.equals(ct)){cpt++;}
        }
        // On fixe le nombre max de carte à retirer au nombre de troupes max dans la province (si trop de cartes en mains)
        // Ou au nombre de carte en main sinon (on ne peut en choisir plus qu'on en a).
        if(nbMax > cpt){ nbMax = cpt;}
        // On redemande le choix si la saisie n'est pas un entier
        while(!isNumber){
            try{
                System.out.print("De combien de cartes troupes '" + ct.toString() + "' voulez-vous vous défausser ? " );
                isNumber = true;
                nb = sc.nextInt();

                if (nb < 1 || nb > nbMax) {
                    System.err.println("Vous ne pouvez vous défausser de plus de cartes que vous en n'avez !");
                    isNumber = false;
                }

            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisie un nombre entier !");
                sc.next();
                isNumber = false;
            }
        }
        return nb;
    }
    
    /**
     * Méthode qui vérifie si le troupe de la tuile bonus d'une province visible et la même que celles de la province
     * @param tProvince troupes présentes dans la province
     * @param tBonus troupe présentes sur la tuile bonus
     * @return true si les troupes sont égales, false sinon
     */
    public boolean troupeEgaleBonus(Troupes tProvince, Troupes tBonus){
        if(tProvince.equals(tBonus)){
            return true;
        }
        return false;
    }
    
    /**
     * Méthode qui vérifie si la carte troupe peut prendre gérer une troupe province ET la troupe bonus
     * @param p
     * @param ct
     * @return 
     */
    public boolean satisfaitTroupeEtBonus(Province p, CarteTroupe ct){
        Troupes tProvince = p.getTroupe();
        Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        Troupes troupe1 = ct.getTroupe1();
        Troupes troupe2 = ct.getTroupe2();
        
        if(troupe2 != null && tBonus != null){
            if((troupe1.equals(tProvince) && troupe2.equals(tBonus)) || (troupe1.equals(tBonus) && troupe2.equals(tProvince))){
                return true;
            }
        }
        return false;
    } 
    
    /**
     * Méthodes qui vérifie si la carte troupe saisie ne satisfait qu'une troupe de la province et non la troupe bonus
     * @param p
     * @param ct
     * @return 
     */
    public boolean satisfaitTroupes(Province p, CarteTroupe ct){
        Troupes tProvince = p.getTroupe();
        Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        Troupes troupe1 = ct.getTroupe1();
        Troupes troupe2 = ct.getTroupe2();
        
        if(troupe2 == null && troupe1.equals(tProvince)){
            return true;
        }
        if(troupe2 != null){
            if(!troupeEgaleBonus(tProvince, tBonus)){
                if(troupe1.equals(tProvince) || troupe2.equals(tProvince)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * La carte troupe choisie ne satisfait que le troupe bonus et rien d'autre...
     * @param p
     * @param ct
     * @return 
     */
    public boolean satisfaitBonus(Province p, CarteTroupe ct){
        Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        Troupes troupe1 = ct.getTroupe1();
        Troupes troupe2 = ct.getTroupe2();
        
        if(troupe2 == null && troupe1.equals(tBonus)){
            return true;
        }
        if(troupe2 != null){
            if(troupe1.equals(tBonus) || troupe2.equals(tBonus)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * On récupère la tuile bonus de la province et on l'ajoute dans la liste du joueur
     * On supprime ensuite la tuile pour faire place à la suivante et pour ne pas que la tuile puisse être prise par un autre joueur
     * @param p province dans laquelle on doit retirer la tuile
     */
    public Bonus recupererTuileBonus(Province p){
        Bonus bonus = null;
        if(!p.getLltuilebonus().isEmpty()){
            bonus = p.getLltuilebonus().getLast().getBonus();
            this.albonus.add(bonus);
            p.getLltuilebonus().removeLast();
        }
        return bonus;
    }
    
    /**
     * On se défausse des cartes troupes choisit et selon leur nombre.
     * Ces cartes se retrouvent alors dans une pioche de défausse. 
     * Cette pioche est nécessaire dans le cas où il n'y a plus de cartes troupes sur le plateau
     * @param p
     * @return 
     */   
    public LinkedList<CarteTroupe> defausserLesTroupes(Province p){
        LinkedList<CarteTroupe> llct = new LinkedList<>();
        CarteTroupe ct = null;
        Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
        int nbTotal = p.getNbtroupes();
        int cpt = 0;
        boolean isTEB = false, isTroupe = false, isBonus = false;

        // On répète les actions suivantes jusqu'à ce qu'on ai engagé toutes les troupes nécessaires pour contrôler la province
        while(nbTotal > 0){    
            ct = null;
            cpt = 0;
            System.out.println("Vos troupes : " + this.alctroupe.toString());
            System.out.println("");
            // On demande au joueur la carte qu'il veut jouer jusqu'à ce que la carte ait une troupe en adéquation avec celle de la province ou de la tuile bonus
            while(!rapportCarteTroupeProvince(ct, p) && !rapportCarteTroupeBonus(ct, tBonus)){
                ct = demandeCarteTroupeADefausser();
                if(!rapportCarteTroupeProvince(ct, p) && !rapportCarteTroupeBonus(ct, tBonus)){
                    System.err.println("C'est pas avec cette carte que tu vas prendre le contrôle man ! ");
                }
            }
            // La carte déduit la troupe bonus et une troupe de province.
            // On rajoute une carte à supprimer et on enlève deux troupes à utiliser
            if(isTEB = satisfaitTroupeEtBonus(p, ct)){
                nbTotal -= 2;
                cpt++;
            }
            // La carte ne concerne QUE les troupes de la province
            if(!isTEB && (isTroupe = satisfaitTroupes(p, ct))){
                cpt++;
                // On enleve encore une troupe à défausser si la carte contient deux fois la même troupe
                if(ct.getTroupe2() != null && ct.getTroupe1().equals(ct.getTroupe2())){
                    nbTotal--;
                }
                if(ct.getTroupe2() == null){
                    cpt = nombreCarteTroupeADefausser(ct, nbTotal);
                    nbTotal -= cpt-1;
                }
                nbTotal--;
            }
            if(!isTEB && !isTroupe && (isBonus = satisfaitBonus(p, ct))){
                nbTotal--;
                cpt++;
            }
            // TODO
            if(cpt == 1){
                llct.add(ct);
                this.alctroupe.remove(ct);
            }
            else{
                for(int i=0; i<cpt; i++){
                    llct.add(ct);
                    this.alctroupe.remove(ct);
                }
            }
        }
        return llct;
    }

    
/* Prise de contrôle avec les kokus uniquement */
    public int nbKokusNecessairePourControle(Province p){
        Controle[] controle = p.getControle();
        int[] tab = p.getPointsFaveur();
        
        for(int i=0; i<tab.length; i++){
            if(controle[i] == null){
                return tab[i];
            }
        }
        return 0;
    }
    
    /**
     * Méthodes qui vérifie que le joueur a assez de kokus en main pour pouvoir prendre le contrôle
     * de la province p de cette manière
     * @param p Province que dont on veut prendre le contrôle
     * @return true si c'est possible, false sinon
     */
    public boolean verifPossibiliteControleProvinceAvecKokusEtBonus(Province p){
        int pointsFaveurs = nbKokusNecessairePourControle(p);
        int nbKokus = 0;
        
        // On ne compte le nombre de kokus seulement si le joueur a des kokus en main
        // Et on retourne true si le joueur a assez de kokus en main
        if(!this.alkokus.isEmpty()){
            for(Kokus k : this.alkokus){
                nbKokus += k.getNbkoku();
            }
            if((nbKokus == pointsFaveurs) || (nbKokus > pointsFaveurs) || (nbKokus == pointsFaveurs-1 && referenceDuBonus("+1") != null)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean verifPossibiliteControleProvinceAvecKokusSeuls(Province p){
        int pointsFaveurs = nbKokusNecessairePourControle(p);
        int nbKokus = 0;
        
        // On ne compte le nombre de kokus seulement si le joueur a des kokus en main
        // Et on retourne true si le joueur a assez de kokus en main
        if(!this.alkokus.isEmpty()){
            for(Kokus k : this.alkokus){
                nbKokus += k.getNbkoku();
            }
            if((nbKokus == pointsFaveurs) || (nbKokus > pointsFaveurs)){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * On compte le nombre de province pouvant être contrôlées avec la main du joueur (en cartes kokus uniquement)
     * @param hProvince liste des province
     * @return le nombre de province pouvant être contrôlées avec des kokus
     */
    public int controleProvincePossibleAvecKokus(Set<Province> hProvince){
        int i = 0;
        
        System.out.println("Avec les cartes kokus que vous avez, vous pouvez prendre le contrôle de :");
        for (Province p : hProvince) {
            // if (verifPossibiliteControleProvinceAvecKokusEtBonus(p) && !p.provinceSousControle()) {
            if (verifPossibiliteControleProvinceAvecKokusSeuls(p) && !p.provinceSousControle()) {
                System.out.println("* " + p.toString());
                i++;
            }
        }
        return i;
    }
    
    /**
     * Méthode qui vérifie que la carte kokus choisie existe bien dans la main du joueur
     * @param nb nombre de sceaux qu'a la carte koku
     * @return une carte koku si la carte existe, null sinon
     */
    public Kokus verifExistenceCarteKokus(int nb){
        if(!this.alkokus.isEmpty()){
            for(Kokus k : this.alkokus){
                if(k.getNbkoku() == nb){
                    return k;
                }
            }
        }
        return null;
    }
    
    /**
     * Méthode qui attend la saisie du joueur quant à la carte kokus à se défausser
     * @return 
     */
    public Kokus demandeCarteKokusADefausser(){
        Scanner sc = new Scanner(System.in);
        int nb = 0;
        boolean stop = false;
        Kokus k = null;
        
        while(!stop){
            try{
                System.out.print("Quelle carte kokus voulez-vous utiliser (indiquer le nombre de kokus) ? ");
                nb = sc.nextInt();
                if((k = verifExistenceCarteKokus(nb)) == null){
                    System.err.println("Vous n'avez pas cette carte dans votre main !");
                }
                else{
                    stop = true;
                }
            }
            catch(InputMismatchException e){
                System.err.println("Vous n'avez pas saisie un nombre !");
                sc.next();
            }
        }
        return k;
    }
    
    /**
     * Méthode qui compte le nombre de cartes kokus ayant X sceaux bakufus dans la main du joueur
     * @param k carte kokus dont on veut connaitre la quantité
     * @return la quantité de carte kokus k
     */
    public int compteNbCarteKokus(Kokus k){
        int cpt = 0;
        
        if(!this.alkokus.isEmpty()){
            for(Kokus ko : this.alkokus){
                if(ko.getNbkoku() == k.getNbkoku()){
                    cpt++;
                }
            }
        }
        return cpt;
    }
    
    /**
     * Méthode qui demande le nombre de cartes kokus, dont le nombre de sceaux est égal à X,
     * qu'on doit défausser
     * @param k carte que l'on veut défausser
     * @return le nombre de cartes k à défausser
     */
    public int nbCarteKokusADefausser(Kokus k){
        Scanner sc = new Scanner(System.in);
        int nb = 0;
        boolean stop = false;
        int nbEnMain = compteNbCarteKokus(k);
        
        while(!stop){
            try{
                System.out.print("Combien de cartes " + k.getNbkoku() + " kokus voulez-vous utiliser ? ");
                nb = sc.nextInt();
                if(nb == 0 || (nb > 0 && (nb < nbEnMain || nb == nbEnMain))){
                    stop = true;
                }
                else{
                    if(nbEnMain == 0){
                        System.err.println("Vous n'avez pas cette carte dans votre main !");
                    }
                    if(nb > nbEnMain){
                        System.err.println("Vous n'avez pas assez de cartes " + k.getNbkoku() + " kokus !");
                    }
                }
            }
            catch(InputMismatchException e){
                System.err.println("Vous n'avez pas saisie un nombre !");
                sc.next();
            }
        }
        return nb;
    }
    
    /**
     * Méthode qui supprime des mains les cartes kokus choisient
     * @param p Province dans laquelle on vérifie que les cartes choisient sont correctes
     */
    public void defausserCarteKokus(Province p){
        Kokus k = null;
        int nbTotal = nbKokusNecessairePourControle(p);
        int nbADefausser = 0;
        
        while(nbTotal > 0 ){
            k = demandeCarteKokusADefausser();
            nbADefausser = nbCarteKokusADefausser(k)*k.getNbkoku();
            if(nbADefausser > 1){
                for(int i=0; i<nbADefausser; i++){
                    this.alkokus.remove(k);
                }
            }
            else{
                if(nbADefausser == 1){
                    this.alkokus.remove(k);
                }
                else{
                    System.out.println("Vous avez décidez de ne pas jouer cette carte kokus !");
                }
            }
            nbTotal -= nbADefausser;
        }
    }
    

/* Jouer des tuiles bonus */
    /**
     * Suppression de la tuile bonus jouée pour ne plus la jouer dans le futur
     * @param b 
     */
    public void supprimerBonusDeLaMain(Bonus b){
        this.albonus.remove(b);
    }
    
    /**
     * Méthode qui demande si le joueur veut jouer des tuiles bonus
     * @return oui s'il est d'accord, non sinon
     */
    public String demandeActivationTuileBonus(){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(true){
            System.out.println("Voici les bonus dont vous disposez : " + this.albonus.toString());
            System.out.print("Voulez-vous jouer une tuile bonus ? ");
            rep = sc.nextLine().toLowerCase();
            if(rep.equals("oui") || rep.equals("non")){
                return rep;
            }
            System.err.println("C'est une question où l'on répond par 'oui' ou 'non' !");
        }
    }
    
    /**
     * Méthode qui vérifie si un bonus choisi est bien dans la main du joueur et donc possible à jouer
     * @param bonus
     * @return 
     */
    public Bonus verifBonusExisteDansLaMain(String bonus){
        for(Bonus b : this.albonus){
            if(b.getNom().equalsIgnoreCase(bonus)){
                return b;
            }
        }
        return null;
    }
    
    /**
     * Méthode qui permet de choisir le bonus qu'on veut jouer
     * @return le bonus à jouer
     */
    public Bonus demandeBonusAJouer(){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        Bonus b = null;
        
        while(true){
            System.out.print("Quel bonus voulez-vous activer ? ");
            rep = sc.nextLine().toLowerCase();
            if((b = verifBonusExisteDansLaMain(rep)) != null){
                return b;
            }
            System.err.println("Idiot, tu n'as pas ce bonus dans ta main ! Réfléchis un peu !");
        }
    }
    
    /**
     * On voit si le joueur à au moins un bonus "Pioche" dans sa main
     * @return 
     */
    public boolean verifBonusDansMain(String type){
        if(!this.albonus.isEmpty()){
            for(Bonus b : this.albonus){
                if(b.getNom().equals(type)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public String demandeActivationBonus(String type){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(true){
            System.out.print("Voulez-vous jouer l'un de vos bonus '"+type+"' ? ");
            rep = sc.nextLine().toLowerCase();
            if(rep.equals("oui") || rep.equals("non")){
                return rep;
            }
            System.err.println("Merci de répondre par 'oui' ou 'non' !");
        }
    }
    
    public Bonus referenceDuBonus(String type){
        for(Bonus b : this.albonus){
            if(b.getNom().equalsIgnoreCase(type)){
                return b;
            }
        }
        return null;
    }
    
    public void jouerBonus(LinkedList<CarteTroupe> llct, String type){
        String rep = new String();
        Bonus b = new Bonus(type);
        
        while(verifBonusDansMain(type) && (!rep.equals("non"))){
            rep = demandeActivationBonus(type);
            if(rep.equals("oui")){
                // On ajoute la carte piochée s'il s'agit d'un bonus 'pioche'
                if(type.equals("Pioche")){this.alctroupe.add(b.bonusPioche(llct));}
                // On ajoute une troupe équivalente à celle de la province s'il s'agit d'un bonus '+1'
                
                this.albonus.remove(referenceDuBonus(type));
                System.out.print("Vous venez de jouer votre bonus '"+type+"'. Voici votre nouvelle main : ");
                System.out.println(this.toString());
                System.out.println("");
            }
        }
    }
   
    
    
/* Pose du Kamons et comptage des points */    
    /**
     * On pose un kamon de contrôle sur le score le plus à gauche encore non pris
     * @param p province dans laquelle on pose le kamon du joueur
     */
    public void poserKamonDeScore(Province p){
        Controle controle = new Controle(this);
        Controle[] tab = p.getControle();
        
        for(int i=0; i<tab.length; i++){
            if(tab[i] == null){
                tab[i] = controle;
                break;
            } 
        }
        decrementerNbKamon();
    }
    
    /**
     * Calcul du nombre de points marqués en fonction de la position du kamon de contrôle
     * @param p
     * @return 
     */
    public int pointsMarques(Province p){
        Controle[] tab = p.getControle();
        int[] tabFaveur = p.getPointsFaveur();
        int points = 0;
        
        for(int i=0; i<tab.length; i++){
            if(tab[i] != null){
                points = tabFaveur[i];                
                return points;
            }
        }
        
        return points;
    }
    
    /**
     * On augmente le score du joueur une fois qu'il a posé un kamon de score.
     * Le score est augmenté d'autant de points qu'il y a de points de faveurs
     * @param p 
     */
    public void incrementerScore(Province p){
        this.score += pointsMarques(p);
    }
    
    public void decrementerNbKamon(){
        this.nbkamons--;
    }
  
    /**
     * Méthode qui compte le nombre de tuile bonus qu'à le joueur dans sa main
     * @return le nombre de tuile bonus dans la main du joueur
     */
    public int nbPiocheEnMain(){
        int i = 0;
        
        for(Bonus b : this.albonus){
            if(b.getNom().equals("Pioche")){
                i++;
            }
        }
        
        return i;
    }
    
    /**
     * Méthode qui calcul le score final du joueur selon les kokus restants, les tuiles bonus (autre que pioche) et les provinces contrôlées
     * @param hProvince liste des provinces à vérifier si le joueur à la contrôle
     */
    public void scoreFinal(Set<Province> hProvince){
        /*this.score += compteNbKokusEnMain();
        // On compte le nombre de tuile bonus Pioche en main
        int nbPioche = nbPiocheEnMain();
        // On transforme toutes les tuiles bonus en koku (en point donc) sauf les tuiles Pioches
        this.score += this.albonus.size() - nbPioche;*/
        
        for(Province p : hProvince){
            Joueur jMajoritaire = p.joueurMajoritaire();
            if(jMajoritaire != null){
                if(this.pseudo.equals(jMajoritaire.getPseudo())){
                    this.score += 6;
                }
            }
        }
    }
    
    
    
    
/* Lancement de la prise de contrôle */        
    public String activationTuileTitre(){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        String nomTitre = this.getTitre().getNom();
        String roleTitre = new String();
        
        if(nomTitre.equals("Sensei")){roleTitre = " retourne un kamon sur sa face dorée.";}
        if(nomTitre.equals("Hatamoto")){roleTitre = " remplace n'importe quelle troupe lors de la prise de contrôle d'une province.";}
        
        while(true){
            System.out.println("Souhaitez-vous activer votre tuile titre '"+nomTitre+"' qui " + roleTitre);
            rep = sc.nextLine().toLowerCase();
            if(rep.equals("oui") || rep.equals("non")){
                return rep;
            }
            System.err.println("Répondre par 'oui' ou 'non', c'est pas bien compliqué quand même...");
        }
    }
    
    
    public String maniereDeControlerProvince(){
        Scanner sc = new Scanner(System.in);
        String s = new String();
        
        System.out.print("Avec quel type de carte voulez-vous prendre la contrôle de la province (troupes / kokus / bonus) ? ");
        while(true){
            s = sc.nextLine();
            if(s.equalsIgnoreCase("troupes") || s.equalsIgnoreCase("kokus") || s.equalsIgnoreCase("bonus")){
                return s.toLowerCase();
            }
            else{
                System.err.println("Vous devez répondre par 'troupes', 'kokus' ou 'bonus' ! ");
            }
        }
    }
    
    
    /**
     * Lance les fonctions pour passer son tour ou prendre le contrôle d'une province
     * Ceci est itéré 3 fois au maximum.
     */
    public void jouer(LinkedList<CarteTroupe> llPioche, LinkedList<CarteTroupe> llct, Set<Province> hProvince){
        Bonus bonus = null;
        String rep = new String();
        String maniere = new String();
        int i = 0, points = 0, pointsTitre = 0;
        boolean win = false;
        
        // Le joueur choisi (ou non) de piocher une carte troupe grâce à sa tuile bonus
        // jouerBonus(llPioche, "Pioche");
        
        // Il peut jouer tant qu'il n'a pas encore posé trois kamons et qu'il ne choisit pas de passer
        while(i < 3 && !rep.equals("passer")){
            for(Province p : hProvince){
                System.out.println(p.toString());
            }
            System.out.println("");
            win = false;
            
            // Affiche les province qu'on peut contrôler avec la main du joueur
            controleProvincePossible(hProvince);
            System.out.print(this.pseudo + ", désirez-vous passer votre tour ou envahir une province ? ");
            // Soit on décide contrôler une province, soit on passe son tour
            rep = envahirOuPasser();
            // On applique les fonctions nécessaires si on désire contrôler une province
            if(rep.equals("envahir")){
                System.out.print("Quelle province voulez-vous contrôler ? ");
                Province p = demandeProvinceAControler(hProvince);
                if(p.provinceSousControle()){
                    System.err.println("Impossible d'essayer de contrôler cette province, elle est déjà pleine !"); 
                }
                else{
                    // Maniere de contrôler la province (tropes, kokus ou bonus)
                    maniere = maniereDeControlerProvince();

                    // Traitement relatif à la prise de contrôle qu'avec des cartes troupes
                    if(maniere.equals("troupes")){
                        // On ne peut défausser que si le joueur a les troupes requises
                        if(aLesTroupesNecessairesSeules(p)){
                            llct.addAll(defausserLesTroupes(p));
                            win = true;
                            /*if(aLesTroupesNecessairesSeules(p)){
                                llct.addAll(defausserLesTroupes(p));
                                win = true;
                            }
                            else{
                                System.out.println("Vous devez obligatoirement jouer un bonus de type '+1' si vous voulez prendre le contrôle de cette province.");
                                jouerBonus(llPioche, "+1");
                            }*/
                        }
                        else{
                            System.out.println("Vous n'avez pas les cartes nécessaires pour attaquer cette province ! ");
                        }
                    }
                    // Traitement relatif à la prise de contrôle qu'avec des kokus
                    if(maniere.equals("kokus")){
                        if(verifPossibiliteControleProvinceAvecKokusSeuls(p)){
                            defausserCarteKokus(p);
                            /*if(verifPossibiliteControleProvinceAvecKokusSeuls(p)){
                                defausserCarteKokus(p);
                            }
                            else{
                                // TODO obligation de jouer le bonus +1
                            }*/
                            win=true;
                        }
                        else{
                            System.err.println("Vous ne disposez pas d'assez de Kokus pour contrôler cette province !");
                        }                    
                    }
                    if(maniere.equals("bonus")){
                        //TODO
                    }
                    
                    // Le joueur a réussi à prendre le contrôle d'un province
                    // On pose un kamon de score, on incrémente les points, on récupère la tuile bonus, etc...
                    if(win){
                        pointsTitre = 0;
                        bonus = recupererTuileBonus(p);
                        poserKamonDeScore(p);
                        points = pointsMarques(p);
                        // Activation de la tuile Titre Daimyo
                        if(this.getTitre().getNom().equals("Daimyo")){System.out.println("DAIMYO !!!");pointsTitre = this.getTitre().tuileDaimyo();}
                        // Activation de la tuile Titre Shomyo
                        if(this.getTitre().getNom().equals("Shomyo")){pointsTitre = this.getTitre().tuileShomyo();}
                        incrementerScore(p);
                        // On affiche un message indiquant la prise de contrôle
                        System.out.println("");
                        System.out.print("Félicitation, vous venez de prendre le contrôle de " + p.getNom());
                        // On affiche un message en fonction de la récupération d'une tuile bonus ou non
                        if(bonus != null){System.out.println(" et vous récupérez le bonus " + bonus);}
                        else{System.out.println(", mais vous ne récupérez aucun bonus (il n'y en a plus pour cette province) !");}
                        // On affiche le nombre de points gagnés
                        System.out.print("Vous avez gagné " + points + " points en prenant le contrôle de la province");
                        if(pointsTitre > 0){
                            String avecS = pointsTitre > 1 ? "points" : "point";
                            System.out.println(" et " + pointsTitre + " " + avecS + " grâce à votre tuile titre " + this.getTitre().getNom() +".");
                            this.score += pointsTitre;
                        }
                        else{
                            System.out.println(".");
                        }
                        // On affiche la nouveau score du joueur
                        System.out.println("Votre score s'élève maintenant à " + this.score + " points !");
                        System.out.println("");
                        i++;
                    }
                }
            } 
                        
            // Avant que le tour du joueur ne se finisse vraiment, on lui demande s'il veut activer sa tuile titre Sensei
            if(i==3 || rep.equals("passer")){
                if(this.getTitre().getNom().equals("Sensei") && this.getScore() > 0){
                    if(activationTuileTitre().equals("oui")){
                        this.getTitre().tuileSensei(hProvince, this);
                    }
                }
            }
            System.out.println(this.toString());
            System.out.println(llct.toString());
        }
        
        // Affichage des messages de fin de tour
        if(rep.equals("passer")){
            System.out.println(this.pseudo + ", vous avez décidé de passer votre tour !");
            // TODO
        }
        if(i == 3){
            System.out.println("Vous venez d'atteindre le nombre maximal de Kamons posés. Votre tour est fini ! ");
            // TODO
        }
    }
}
