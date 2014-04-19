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
}
