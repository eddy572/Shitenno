package classes;

import java.util.*;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Province {
    private String nom;
    private int faveur1;
    private int faveur2;
    private int faveur3;
    private int faveur4;
    private int nbtroupes;
    private Troupes troupe;
    private LinkedList<TuileBonus> lltuilebonus;

    /* Constructor */
    public Province(String nom, int faveur1, int faveur2, int faveur3, int faveur4, int nbtroupes) {
        this.nom = nom;
        this.faveur1 = faveur1;
        this.faveur2 = faveur2;
        this.faveur3 = faveur3;
        this.faveur4 = faveur4;
        this.nbtroupes = nbtroupes;
        this.lltuilebonus = new LinkedList<TuileBonus>();
    }

    public Province() {
    }
    
    public Province(String nom, int faveur1, int faveur2, int faveur3, int faveur4, int nbtroupes, Troupes troupe) {
        this.nom = nom;
        this.faveur1 = faveur1;
        this.faveur2 = faveur2;
        this.faveur3 = faveur3;
        this.faveur4 = faveur4;
        this.nbtroupes = nbtroupes;
        this.troupe = troupe;
        this.lltuilebonus = new LinkedList<TuileBonus>();
    }

    public Province(String nom, int faveur1, int faveur2, int faveur3, int faveur4, int nbtroupes, Troupes troupe, LinkedList<TuileBonus> ltb) {
        this.nom = nom;
        this.faveur1 = faveur1;
        this.faveur2 = faveur2;
        this.faveur3 = faveur3;
        this.faveur4 = faveur4;
        this.nbtroupes = nbtroupes;
        this.troupe = troupe;
        this.lltuilebonus = ltb;
    }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFaveur1() {
        return faveur1;
    }

    public void setFaveur1(int faveur1) {
        this.faveur1 = faveur1;
    }

    public int getFaveur2() {
        return faveur2;
    }

    public void setFaveur2(int faveur2) {
        this.faveur2 = faveur2;
    }

    public int getFaveur3() {
        return faveur3;
    }

    public void setFaveur3(int faveur3) {
        this.faveur3 = faveur3;
    }

    public int getFaveur4() {
        return faveur4;
    }

    public void setFaveur4(int faveur4) {
        this.faveur4 = faveur4;
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
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + this.faveur1;
        hash = 97 * hash + this.faveur2;
        hash = 97 * hash + this.faveur3;
        hash = 97 * hash + this.faveur4;
        hash = 97 * hash + this.nbtroupes;
        hash = 97 * hash + Objects.hashCode(this.troupe);
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
        if (this.faveur1 != other.faveur1) {
            return false;
        }
        if (this.faveur2 != other.faveur2) {
            return false;
        }
        if (this.faveur3 != other.faveur3) {
            return false;
        }
        if (this.faveur4 != other.faveur4) {
            return false;
        }
        if (this.nbtroupes != other.nbtroupes) {
            return false;
        }
        if (!Objects.equals(this.troupe, other.troupe)) {
            return false;
        }
        return true;
    }

/* Methodes */
    @Override
    public String toString() {
        return nom + " - " + faveur1 + ", " + faveur2 + ", " + faveur3 + ", " + faveur4 + " - " + nbtroupes + " troupes - " + troupe;
    }
   
}
