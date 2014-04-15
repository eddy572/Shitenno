/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public final class PanelConceptionPaquet extends JPanel {
private BufferedImage img;
    public PanelConceptionPaquet() {
    try {
        img = ImageIO.read (new File("image/main.jpg"));
    } catch (IOException ex) {
        Logger.getLogger(PanelConceptionPaquet.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    }
    
@Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background    
            g.drawImage(img,0,0, 1200, 750, this);
        } 
    
    
}
