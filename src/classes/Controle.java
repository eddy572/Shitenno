package classes;

import java.util.Objects;

/**
 * Cette classe place les kamons de score dans une province
 * On utilise cette classe dans un tableau dans la Classe Province
 * Chaque cellule du tableau correspond à un score (ex : i=0 -> score=4, i=1 -> score=5, etc...)
 * Le fait d'avoir le joueur nous permet aussi de connaitre la couleur du kamon placé.
 * @author Damien
 * @param joueur joueur qui aura son kamon sur un score d'une province
 * @param isGolden indique si le kamon est retourné sur sa fasse doré.
 */
public class Controle {
    private Joueur joueur;
    private boolean isGolden;
    
/* Constructors */
    public Controle() {
    }

    public Controle(Joueur joueur) {
        this.joueur = joueur;
        this.isGolden = false;
    }
    
    public Controle(Joueur joueur, boolean isGolden) {
        this.joueur = joueur;
        this.isGolden = isGolden;
    }
    
/* Getters & Setters */
    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public boolean isIsGolden() {
        return isGolden;
    }

    public void setIsGolden(boolean isGolden) {
        this.isGolden = isGolden;
    }
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.joueur);
        hash = 61 * hash + (this.isGolden ? 1 : 0);
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
        final Controle other = (Controle) obj;
        if (!Objects.equals(this.joueur, other.joueur)) {
            return false;
        }
        if (this.isGolden != other.isGolden) {
            return false;
        }
        return true;
    }
    
/* Methodes */
    @Override
    public String toString() {
        return "Controle{" + "joueur=" + joueur + ", isGolden=" + isGolden + '}';
    }
    
        
}
