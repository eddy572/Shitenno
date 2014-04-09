package classes;

import java.util.*;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Tairo {
    private Joueur tairo;
    private ArrayList<CarteTroupe> alct;
    private ArrayList<Kokus> alk;
    
/* Constructor */

    public Tairo() {
        this.tairo = new Joueur();
        this.alct = new ArrayList<CarteTroupe>();
        this.alk = new ArrayList<Kokus>();
    }

    public Tairo(Joueur tairo, ArrayList<CarteTroupe> alct, ArrayList<Kokus> alk) {
        this.tairo = tairo;
        this.alct = alct;
        this.alk = alk;
    }
    
/* Getters & Setters */
    public Joueur getTairo() {
        return tairo;
    }

    public void setTairo(Joueur tairo) {
        this.tairo = tairo;
    }

    public ArrayList<CarteTroupe> getAlct() {
        return alct;
    }

    public void setAlct(ArrayList<CarteTroupe> alct) {
        this.alct = alct;
    }

    public ArrayList<Kokus> getAlk() {
        return alk;
    }

    public void setAlk(ArrayList<Kokus> alk) {
        this.alk = alk;
    }
    
/* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append(tairo).append(" ").append(alct).append(" ").append(alk));
    }
    
    /**
     * Le joueur nommé Tairo est celui avec la titre ayant le plus de sceaux bakufus
     * @param hjoueur 
     */
    public void devientLeTairo(ArrayList<Joueur> aljoueur){
        int i = 0;
        
        while(aljoueur.get(i).getTitre() == null){
            i++;
        }
        this.tairo = aljoueur.get(i);
    }
    
    /**
     * On pioche les x cartes troupes et y cartes kokus dans les paquets respectifs.
     * On supprime les cartes piochées des listes.
     * @param llct paquet de cartes troupes
     * @param llk paquet de cartes kokus
     * @param nbcartes nombre de cartes à piocher
     */
    public void piocheCartes(LinkedList<CarteTroupe> llct, LinkedList<Kokus> llk, int nbcartes){
        // On pioche x cartes troupes où x dépend selon le nombre de joueurs
        for(int i=0; i<nbcartes; i++){
            alct.add(llct.getLast());
            llct.removeLast();
        }
        
        // Le nombre de kokus à piocher est équivalent au nombre de joueurs soit nbcartestroupes / 2
        for(int i=0; i<(nbcartes/2); i++){
            alk.add(llk.getLast());
            llk.removeLast();
        }
    }
    
    
    
}
