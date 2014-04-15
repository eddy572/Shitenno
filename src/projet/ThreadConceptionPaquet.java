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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public class ThreadConceptionPaquet extends Thread implements ActionListener {
    private LinkedList<CarteTroupe> llctroupe; // Paquet "Troupes"
    private LinkedList<Kokus> llkokus; // Paquet "Kokus"
    private Tairo tairo = new Tairo();
    private PanelConceptionPaquet p;
    private Fenetre jf;
    private Image img;

    public ThreadConceptionPaquet(Fenetre j,Initialisation init, Set<Joueur> hjoueur) {
        jf=j;
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
    
    public void run() {
    
    while(true)
    {
        jf.teest=jf.teest+1;
        System.out.println("partage :"+jf.teest);
     System.out.println("************************DEBUT Partage***************************");

    this.p= new PanelConceptionPaquet();
    this.p.setOpaque(true);
    this.p.setBounds(0, 0, 1200, 750);   
    jf.add(this.p);
    jf.repaint();
        try {
           sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadConceptionPaquet.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf.remove(this.p);
        jf.repaint();
        System.out.println("************************FIN Partage***************************");
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadConceptionPaquet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
