package classes;

import java.util.Objects;

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
        return new String(new StringBuilder().append(nom).append(" ").append(nbsceaux).append(" ").append(bonus));
    }
    
    
    
}
