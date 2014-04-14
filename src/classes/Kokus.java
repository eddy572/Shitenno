package classes;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Kokus implements Comparable<Kokus>{
    private int nbkoku;

    public Kokus(int nbkoku) {
        this.nbkoku = nbkoku;
    }

    /* Getters & Setters */
    public int getNbkoku() {
        return nbkoku;
    }

    public void setNbkoku(int nbkoku) {
        this.nbkoku = nbkoku;
    }

    /* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.nbkoku;
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
        final Kokus other = (Kokus) obj;
        if (this.nbkoku != other.nbkoku) {
            return false;
        }
        return true;
    }

/* Methodes */
    
    @Override
    public int compareTo(Kokus t) {
        if(this.nbkoku > t.nbkoku)
            return 1;
        if(this.nbkoku < t.nbkoku)
            return 1;
        return 0;
    }

    
    @Override
    public String toString() {
        return new String(new StringBuilder().append("Carte ").append(Integer.toString(nbkoku)).append(" kokus"));
    }
    
  
}

