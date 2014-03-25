package classes;

import java.util.*;
/**
 *
 * @author Damien
 * @version 1.0
 */
public class Joueur {
    private String pseudo;
    private int score;
    private General general;
    private int nbkamons;
    private ArrayList<CarteTroupe> alctroupe;
    private ArrayList<Kokus> alkokus;
    private Titre titre;

/* Constructors */
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
        this.alctroupe = null;
        this.alkokus = null;
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
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.pseudo);
        hash = 83 * hash + this.score;
        hash = 83 * hash + Objects.hashCode(this.general);
        hash = 83 * hash + this.nbkamons;
        hash = 83 * hash + Objects.hashCode(this.alctroupe);
        hash = 83 * hash + Objects.hashCode(this.alkokus);
        hash = 83 * hash + Objects.hashCode(this.titre);
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
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }
    
/* Methods */
    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", score=" + score + ", general=" + general + ", nbkamons=" + nbkamons + ", alctroupe=" + alctroupe + ", alkokus=" + alkokus + ", titre=" + titre + '}';
    }
   
}
