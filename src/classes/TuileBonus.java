package classes;

import java.util.Objects;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class TuileBonus {
    private Troupes troupe;
    private Bonus bonus;
    
/* Constructor */
    public TuileBonus(Troupes troupe, Bonus bonus) {
        this.troupe = troupe;
        this.bonus = bonus;
    }
    
/* Getters & Setters */
    public Troupes getTroupe() {
        return troupe;
    }

    public void setTroupe(Troupes troupe) {
        this.troupe = troupe;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.troupe);
        hash = 59 * hash + Objects.hashCode(this.bonus);
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
        final TuileBonus other = (TuileBonus) obj;
        if (!Objects.equals(this.troupe, other.troupe)) {
            return false;
        }
        if (!Objects.equals(this.bonus, other.bonus)) {
            return false;
        }
        return true;
    }

/* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append(this.troupe.toString()).append("\n").append(this.bonus.toString()));
    }
    
    
    
    
}
