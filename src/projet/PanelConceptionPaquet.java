/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import classes.CarteTroupe;
import classes.Initialisation;
import classes.Joueur;
import classes.Kokus;
import classes.Tairo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public class PanelConceptionPaquet extends JPanel implements ActionListener {
    private LinkedList<CarteTroupe> llctroupe; // Paquet "Troupes"
    private LinkedList<Kokus> llkokus; // Paquet "Kokus"
    private Tairo tairo = new Tairo();

    public PanelConceptionPaquet(Initialisation init, Set<Joueur> hjoueur) {
        this.llctroupe = init.getLlctroupe();
        this.llkokus = init.getLlkokus();
        tairo.devientLeTairo(new ArrayList(hjoueur));
        tairo.piocheCartes(llctroupe, llkokus, 2*hjoueur.size());
        System.out.println("Paquet de cartes Troupes piochées : " + tairo.getAlct());
        System.out.println("Paquet de cartes Kokus piochées : " + tairo.getAlk());
        
        for(int i=0; i<hjoueur.size();i++)
        {
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
