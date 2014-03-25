/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.Objects;

/**
 *
 * @author Damien
 */
public class CarteTroupe {
    private Troupes troupe1;
    private Troupes troupe2;
    
/* Constructor */
    // Un seul troupe pour la carte
    public CarteTroupe(Troupes troupe1) {
        this.troupe1 = troupe1;
        this.troupe2 = null;
    }

    // Deux troupes pour cette carte
    public CarteTroupe(Troupes troupe1, Troupes troupe2) {
        this.troupe1 = troupe1;
        this.troupe2 = troupe2;
    }

/* Getters & Setters */
    public Troupes getTroupe1() {
        return troupe1;
    }

    public void setTroupe1(Troupes troupe1) {
        this.troupe1 = troupe1;
    }

    public Troupes getTroupe2() {
        return troupe2;
    }
    
    public void setTroupe2(Troupes troupe2) {
        this.troupe2 = troupe2;
    }
/* HashCode & Equals */
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.troupe1);
        hash = 17 * hash + Objects.hashCode(this.troupe2);
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
        final CarteTroupe other = (CarteTroupe) obj;
        if (!Objects.equals(this.troupe1, other.troupe1)) {
            return false;
        }
        if (!Objects.equals(this.troupe2, other.troupe2)) {
            return false;
        }
        return true;
    }

/* Methodes */
    @Override
    public String toString() {
        if(troupe2 == null){
            return new String(new StringBuilder().append("Cette carte n'a qu'une troupe : ").append(troupe1.getNom()));
        }
        else{
            return new String(new StringBuilder().append("Cette carte a 2 troupes : ").append(troupe1.getNom()).append(" & ").append(troupe2.getNom()));
        }
    }
    
    
}
