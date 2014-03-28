package projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
            




// pour afficher une image

public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){
      
    try {
      Image img = ImageIO.read(new File("image/plateau.jpg"));
      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

      g.drawImage(img, 0, 0, this.getWidth(), 515, this);
    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    
  }               

}
