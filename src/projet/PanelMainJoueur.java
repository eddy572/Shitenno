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
    
    // image titre

    private BufferedImage bgeneral;
    private BufferedImage btitre;
    private JLabel label_image_titre = new JLabel();
    private JLabel label_image_general = new JLabel();
    
    private BufferedImage btroupes;
    private JLabel label_image_troupes = new JLabel();
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
        J.setAlctroupe(llct);
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
            
        // carte troupes !
        
        int xit = 240;

        for(int i=0;i<J.getAlctroupe().size();i++)
        {
                try {
                    System.out.println(J.getTitre());
                btroupes = ImageIO.read(new File("image/troupes/bushi.png"));
                label_image_troupes = new JLabel(new ImageIcon(btroupes));
                label_image_troupes.setBounds(xit, 5, 90, 110);
                } catch (IOException ex) {
                    Logger.getLogger(PanelInvasion.class.getName()).log(Level.SEVERE, null, ex);
                }
           xit=xit+40;
            this.add(label_image_troupes);    
        }
         

        this.setBounds(0,592,1200,210);
        this.setOpaque(false);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
