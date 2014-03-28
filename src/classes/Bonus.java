package classes;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Bonus {
    private String nom;

    /* Constructor */
    public Bonus(String nom) {
        this.nom = nom;
    }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append("Effet : ").append(nom));
    }
    
    
}
