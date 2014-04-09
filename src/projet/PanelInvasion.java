/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import classes.Province;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public class PanelInvasion extends JPanel implements ActionListener {
    private Image img;
    private JButton fermer = new JButton("Retour");
    private JFrame jfglobal;
    public PanelInvasion(final JFrame jf, PanelProvince p)
    {
         jfglobal=jf;
        // insertion du bouton de retour
        fermer.setBounds(1000, 20, 80, 30);
        fermer.addActionListener(this);
        this.add(fermer);
        jf.add(this);
        this.setBounds(0, 0, 1200, 588);
        String nom=p.p.getNom()+".png";
        try {
            System.out.println("image/zoom/"+nom);
            img = ImageIO.read (new File("image/zoom/"+nom));
            this.paintComponent(this.getGraphics());
        } catch (IOException ex) {
            Logger.getLogger(PanelInvasion.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf.add(this);
        
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0,1200,588, null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
                Object source =ae.getSource();
        if(source == fermer)
        {
            jfglobal.remove(this);
            jfglobal.repaint();

        }
    }
    
    
}
