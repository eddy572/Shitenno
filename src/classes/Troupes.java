package classes;

import java.util.Objects;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Troupes {
    private String nom;
    private String couleur;

    /* COnstructor */
    public Troupes(String nom, String couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.couleur);
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
        final Troupes other = (Troupes) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.couleur, other.couleur)) {
            return false;
        }
        return true;
    }

    /* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append(nom).append(" ").append(couleur));
    }
    
    
    
}
