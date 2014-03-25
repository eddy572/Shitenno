package classes;

import java.util.*;

/**
 *
 * @author Damien
 */
public class General {
    private String nom;
    private String prenom;
    private String couleur;

    /* Constructeur */
    public General(String nom, String prenom, String couleur) {
        this.nom = nom;
        this.prenom = prenom;
        this.couleur = couleur;
    }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
        hash = 19 * hash + Objects.hashCode(this.nom);
        hash = 19 * hash + Objects.hashCode(this.prenom);
        hash = 19 * hash + Objects.hashCode(this.couleur);
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
        final General other = (General) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
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
        
        return new String(new StringBuilder().append("Nom : ").append(nom).append("\nPrenom : ").append(prenom)
                .append("\nCouleur=").append(couleur));
    }
    
    
}
