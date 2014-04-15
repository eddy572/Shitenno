/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import classes.*;
import classes.Titre;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public class PanelMainJoueur extends JPanel implements ActionListener {
    private Image img;
    
    
MouseListener ml = new MouseListener(){

       @Override
       public void mousePressed(MouseEvent me) {}

       @Override
       public void mouseReleased(MouseEvent me) {}

       @Override
       public void mouseEntered(MouseEvent me) {
           System.out.println(me.getSource());}

       @Override
       public void mouseExited(MouseEvent me) { }

       @Override
       public void mouseClicked(MouseEvent me) {}
   };
    
    
    
    
    
    // image titre

    private BufferedImage bgeneral;
    private BufferedImage btitre;
    private JLabel label_image_titre = new JLabel();
    private JLabel label_image_general = new JLabel();
    
    private BufferedImage btroupes;
    private Labeltroupes label_image_troupes = new Labeltroupes();
    private BufferedImage bkokus;
    private Labelkokus label_image_kokus = new Labelkokus();
    public PanelMainJoueur(Joueur J)
    {
        // fausse initialisation de joueurs
        J.setTitre(new Titre("lolilol",4,"+ 2 troupes"));

        ArrayList<CarteTroupe> llct = new ArrayList<CarteTroupe>();
        Troupes T1 = new Troupes("ninja","bleu");
        Troupes T2 = new Troupes("moine","rose");
        CarteTroupe ct1 = new CarteTroupe(T1,T2);
        llct.add(ct1);
        llct.add(ct1);
        llct.add(ct1);
        llct.add(ct1);
        llct.add(ct1);
        llct.add(ct1);
        J.setAlctroupe(llct);
        ArrayList<Kokus> llck = new ArrayList<Kokus>();
        Kokus k = new Kokus(2);
        llck.add(k);
        llck.add(k);
        llck.add(k);
        llck.add(k);
        llck.add(k);
        J.setAlkokus(llck);
        System.out.println(J);
        
        
        // carte général
        this.setLayout(null);
                try {
                bgeneral = ImageIO.read(new File("image/bleu.jpg"));
                label_image_general = new JLabel(new ImageIcon(bgeneral));
                label_image_general.setBounds(20, 5, 90, 110);
        } catch (IOException ex) {
            Logger.getLogger(PanelInvasion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            this.add(label_image_general); 
            
            
        // carte titre

                try {
                    System.out.println(J.getTitre());
                btitre = ImageIO.read(new File("image/titre/"+J.getTitre().getNbsceaux()+".png"));
                label_image_titre = new JLabel(new ImageIcon(btitre));
                label_image_titre.setBounds(130, 5, 90, 110);
        } catch (IOException ex) {
            Logger.getLogger(PanelInvasion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            this.add(label_image_titre);   

            
            
                    int xitsave = 700;
        int xit = 500/(J.getAlctroupe().size()+J.getAlkokus().size());
        if(xit > 90)
            xit=90;
        // carte kokus !
        for(int i=0;i<J.getAlkokus().size();i++)
        {
                try {
                    System.out.println(J.getTitre());
                bkokus = ImageIO.read(new File("image/kokus/2.png"));
                label_image_kokus = new Labelkokus(new ImageIcon(bkokus));
                label_image_kokus.setBounds(xitsave, 5, 90, 110);
                label_image_kokus.addMouseListener(ml);
                } catch (IOException ex) {
                    Logger.getLogger(PanelInvasion.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            this.add(label_image_kokus);   
            xitsave=xitsave-xit;
        }
         
            
        // carte troupes !
        
        for(int i=0;i<J.getAlctroupe().size();i++)
        {
                try {
                    System.out.println(J.getTitre());
                bkokus = ImageIO.read(new File("image/troupes/bushi.png"));
                label_image_troupes = new Labeltroupes(new ImageIcon(bkokus));
                label_image_troupes.setBounds(xitsave, 5, 90, 110);
                label_image_troupes.setOpaque(false);
                } catch (IOException ex) {
                    Logger.getLogger(PanelInvasion.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            this.add(label_image_troupes);   
            xitsave=xitsave-xit;
        }   
        

        this.setBounds(0,592,1200,210);
        this.setOpaque(false);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
