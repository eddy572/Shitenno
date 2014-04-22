package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Titre {
    private String nom;
    private int nbsceaux;
    private String bonus;

    /* Constructors */
    public Titre(String nom, int nbsceaux, String bonus) {
        this.nom = nom;
        this.nbsceaux = nbsceaux;
        this.bonus = bonus;
    }

    public Titre() {
           }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbsceaux() {
        return nbsceaux;
    }

    public void setNbsceaux(int nbsceaux) {
        this.nbsceaux = nbsceaux;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    /* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + this.nbsceaux;
        hash = 29 * hash + Objects.hashCode(this.bonus);
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
        final Titre other = (Titre) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (this.nbsceaux != other.nbsceaux) {
            return false;
        }
        if (this.bonus != other.bonus) {
            return false;
        }
        return true;
    }

/* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append(nom).append(" (").append(nbsceaux).append(" sceaux").append(", ").append(bonus).append(")"));
    }
    
    /**
     * Méthodes qui affiche les provinces où on peut retourner un kamon,
     * càd qu'il y a au moins un kamon dans la province et qu'il n'est pas encore face dorée
     * @param hProvince liste des provinces
     * @param j joueur qui nus intéresse
     */
    public void listerProvincesControlees(Set<Province> hProvince, Joueur j){    
        ArrayList<Province> lProvince = new ArrayList<>();
        for(Province p : hProvince){
            // Il faut qu'il y ait au moins un kamon de poser pour vérifier
            if(p.getControle()[0] != null){
                for(Controle c : p.getControle()){
                    if(c == null) break;
                    if(c.getJoueur().getPseudo().equals(j.getPseudo())){
                        lProvince.add(p);
                        break;
                    }
                }
            }
        }
        afficherLesControlesDeLaProvince(lProvince);
    }
    
    /**
     * Afficher tous les joueurs ayant posés des kamons dans les provinces que le joueur faisant appel à la méthode
     * peut retourné l'un des siens
     * @param alp liste des province ayant des kamons non dorée du joueur
     */
    public void afficherLesControlesDeLaProvince(ArrayList<Province> alp){
        int i = 0;
        for(Province p : alp){
            i = 0;
            System.out.print("* " + p.getNom() + " : ");
            for(Controle c : p.getControle()){
                if(c == null) break;
                System.out.print(p.getPointsFaveur()[i] + "(" + c.getJoueur().getPseudo() + ") - ");
                i++;
            }
            System.out.println("");
        }
    }
           
    /**
     * Méthode qui retourne un kamon sur sa face dorée
     * @param hProvince liste des provinces pour choisir la province 
     * @param j joueur qui veut retourner l'un de ses kamons
     */
    public void tuileSensei(Set<Province> hProvince, Joueur j){
        String rep = new String();
        
        while(!rep.equals("non")){
            listerProvincesControlees(hProvince, j);
            System.out.print("Sur quelle province voulez-vous retourner l'un de vos kamons ? ");
            Province p = j.demandeProvinceAControler(hProvince);
            Controle[] controle = p.getControle();

            // On retourne le kamon le plus à gauche n'ayant pas encore été retourné face dorée
            // Pas besoin de demander l'avis du joueur, car il n'y a aucun intérêt à en retourner un autre (même stratégique...)
            if(p.aUnKamonDansLaProvince(j)){
                for(int i=0; i<controle.length; i++){
                    if(controle[i].getJoueur().getPseudo().equals(j.getPseudo()) && !controle[i].isIsGolden()){
                        controle[i].setIsGolden(true);
                        System.out.println("Félicitation, vous venez de retourner un Kamon sur la province " + p.getNom());
                        rep = "non";
                        break;
                    }
                }
            }
            else{
                Lot l = new Lot();
                System.err.println("Vous n'avez pas encore de kamons dans cette province !");
                System.out.print("Souhaitez-vous choisir une autre province ?");
                rep = l.ouiOuNon();
            }
        }
    }
    
    /**
     * Méthode qui ajoute deux points à chaque fois que le joueur pose un nouveau kamon de contrôle
     * @return  
     */
    public int tuileDaimyo(){
        return 2;
    }
    
    /**
     * Méthode qui ajoute 1 point à chaque fois que le joueur pose un nouveau kamon de contrôle
     * @return  
     */
    public int tuileShomyo(){
        return 1;
    }
    
    
    public void tuileHatamoto(){
        
    }
    
}
