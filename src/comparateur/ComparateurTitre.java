package comparateur;

import classes.*;
import java.util.*;
/**
 *
 * @author Damien
 */
public class ComparateurTitre implements Comparator<Titre>{

    @Override
    public int compare(Titre t, Titre t1) {
        if(t.getNbsceaux() > t1.getNbsceaux())
            return 1;
        if(t.getNbsceaux() < t1.getNbsceaux())
            return -1;
        return 0;
    }
    
}
