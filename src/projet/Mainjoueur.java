package projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
            




// pour afficher une image

public class Mainjoueur extends JPanel { 
  public void paintComponent(Graphics g){
      
    try {
      Image img = ImageIO.read(new File("main.jpg"));
      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

      g.drawImage(img, 0, 0, this.getWidth(), 500, this);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }               
}
