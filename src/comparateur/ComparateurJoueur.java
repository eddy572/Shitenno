package comparateur;

import classes.Joueur;
import java.util.*;
/**
 *
 * @author Damien
 */
public class ComparateurJoueur implements Comparator<Joueur>{

    @Override
    public int compare(Joueur t, Joueur t1) {
        if(t.getTitre().getNbsceaux() > t1.getTitre().getNbsceaux())
            return 1;
        if(t.getTitre().getNbsceaux() < t1.getTitre().getNbsceaux())
            return -1;
        return 0;
    }
    
}
