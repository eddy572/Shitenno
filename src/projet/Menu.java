package projet;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Menu extends JFrame implements ActionListener {
    
   private JButton bouton = new JButton("Créer partie");
   private JButton credits = new JButton("Crédits");
   private JButton regles = new JButton("Règles");
   private JButton fermer = new JButton("Quitter");
   private JButton retour = new JButton("Retour");
   private JButton charger = new JButton("Charger");
   private JLabel label_credits = new JLabel("",JLabel.CENTER);
   private JTextArea label_credit;
   
   // déclaration pour le choix du nmbre de joueurs
   private JPanel p1 = new JPanel();
   private JLabel label_nbjoueurs = new JLabel("Nombre de joueurs :",JLabel.CENTER);
   private JCheckBox check1 = new JCheckBox("2");
   private JCheckBox check2 = new JCheckBox("3");
   private JCheckBox check3 = new JCheckBox("4");
   
   // déclaration des avatars des joueurs
   private JPanel p2 = new JPanel();
   private JLabel l1 = new JLabel("Joueur 1 : ");
   private JTextField jtf1 = new JTextField("Joueur 1");
   private JLabel l2 = new JLabel("Joueur 2 : ");
   private JTextField jtf2 = new JTextField("Joueur 2");
   private JLabel l3 = new JLabel("Joueur 3 : ");
   private JTextField jtf3 = new JTextField("Joueur 3");
   private JLabel l4 = new JLabel("Joueur 4 : ");
   private JTextField jtf4 = new JTextField("Joueur 4");
   private JPanel minipanel1 = new JPanel();
   private ImageIcon i1 = new ImageIcon("");
   private JLabel b1;
   private BufferedImage bufmini1;
   private JPanel minipanel2 = new JPanel();
   private ImageIcon i2 = new ImageIcon("");
   private JLabel b2;
   private BufferedImage bufmini2;
   private JPanel minipanel3 = new JPanel();
   private ImageIcon i3 = new ImageIcon("");
   private JLabel b3;
   private BufferedImage bufmini3;
   private JPanel minipanel4 = new JPanel();
   private ImageIcon i4 = new ImageIcon("");
   private JLabel b4;
   private BufferedImage bufmini4;
   
   //déclaraton pour le panel des images des généraux
   private JPanel p3 = new JPanel();
   private JPanel pimage1 = new JPanel();
            ImageIcon icone1 = new ImageIcon("");
            JLabel image1;
            private BufferedImage buf1;
   private JPanel pimage2 = new JPanel();
            ImageIcon icone2 = new ImageIcon("");
            JLabel image2;
            private BufferedImage buf2;
   private JPanel pimage3 = new JPanel();
            ImageIcon icone3 = new ImageIcon("");
            JLabel image3;
            private BufferedImage buf3;
   private JPanel pimage4 = new JPanel();
            ImageIcon icone4 = new ImageIcon("");
            JLabel image4;
            private BufferedImage buf4;
   private JLabel choix = new JLabel("Veuillez chosir votre général :");
   
            MouseListener listener = new MouseAdapter(){
            public void mousePressed(MouseEvent e)
        {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
        };
            
            
        TransferHandler handler = new TransferHandler("icon") {

        @Override
        public boolean canImport(TransferSupport support) {
            return false;
        }

    };
    
        
        // Variable initialisation du jeu
        
 
        
  public Menu(){        

    this.setTitle("Shitenno");
    this.setSize(1200, 700);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setContentPane(new Menuimage());
    
    // bouton lancer partie
    
    this.setLayout(null);
    bouton.addActionListener(this);
    this.add(bouton);
    bouton.setBounds(500, 210, 200, 40);
    
    // bouton charger partie
    
    this.setLayout(null);
    charger.addActionListener(this);
    this.add(charger);
    charger.setBounds(500, 280, 200, 40);
    
    // bouton règles
   
    regles.addActionListener(this);
    this.add(regles);
    regles.setBounds(500, 350, 200, 40);
    
    
    // bouton crédits
   
    credits.addActionListener(this);
    this.add(credits);
    credits.setBounds(500, 420, 200, 40);
    
    // bouton quitter
   
    fermer.addActionListener(this);
    this.add(fermer);
    fermer.setBounds(500, 490, 200, 40);
    
    //this.getContentPane().add(bouton);

    this.setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent ae) {


                
        Object source =ae.getSource();
        if(source == bouton)
        {
            // suppression de l'ancien affichage
            this.remove(bouton);
            this.remove(fermer);
            this.remove(regles);
            this.remove(credits);
            this.remove(charger);
            this.p2.remove(l3);
            this.p2.remove(l4);
            this.p2.remove(jtf3);
            this.p2.remove(jtf4);
            this.p2.remove(minipanel3);
            this.p2.remove(minipanel4);
            label_nbjoueurs.setBounds(25, 25, 120, 30);
            label_nbjoueurs.setForeground(Color.WHITE);
  
            // création du panel pour choix du nombre de joueurs
            
            
            p1.setBackground(new Color(150, 150, 150,200));
            p1.setBorder(BorderFactory.createLineBorder(Color.black));
            p1.setBounds(25, 275, 170, 250);
            p1.add(label_nbjoueurs);
            check1.addActionListener(this);
            check2.addActionListener(this);
            check3.addActionListener(this);
            check1.setBounds(70,75,40,20);
            check1.setForeground(Color.white);
            check2.setForeground(Color.white);
            check3.setForeground(Color.white);
            check1.setSelected(true);
            check3.setSelected(false);
            check2.setSelected(false);
            check1.setOpaque(false);
            check2.setBounds(70,125,40,20);
            check2.setOpaque(false);
            check3.setBounds(70,175,40,20);
            check3.setOpaque(false);
            // ajouter les checkbox
            p1.add(check1);
            p1.add(check2);
            p1.add(check3);
            this.add(p1);
            
            
            // ajout des zones de saisie et des labels
            
            p2.setBackground(new Color(150, 150, 150,200));
            p2.setBorder(BorderFactory.createLineBorder(Color.black));
            p2.setBounds(240, 275, 350, 250);
            
            l1.setBounds(25, 70, 60, 30);
            l1.setOpaque(false);
            p2.add(l1);
            jtf1.setBounds(110, 70, 80, 30);
            p2.add(jtf1);
            minipanel1.setBackground(new Color(255, 255, 255,200));
            minipanel1.setBorder(BorderFactory.createLineBorder(Color.black));
            minipanel1.setBounds(230, 10, 90, 110);
            b1 = new JLabel();
            try
            { 
                bufmini1 = ImageIO.read(new File("image/blanc.png"));
                b1 = new JLabel(new ImageIcon(bufmini1));
                b1.setBounds(0, 0, 90, 110);
                minipanel1.add(b1);
                b1.setTransferHandler(new TransferHandler("icon"));
            } 
            catch (Exception ex) 
            {}
            
            //b1.setBounds(0, 0, 90, 110);

            p2.add(minipanel1);
            l2.setBounds(25, 150, 60, 30);
            l2.setOpaque(false);
            p2.add(l2);
            jtf2.setBounds(110, 150, 80, 30);
            p2.add(jtf2);
            minipanel2.setBackground(new Color(255, 255, 255,200));
            minipanel2.setBorder(BorderFactory.createLineBorder(Color.black));
            minipanel2.setBounds(230, 125, 90, 110);
            try
            { 
                bufmini2 = ImageIO.read(new File("image/blanc.png"));
                b2 = new JLabel(new ImageIcon(bufmini2));
                b2.setBounds(0, 0, 90, 110);
                minipanel2.add(b2);
                b2.setTransferHandler(new TransferHandler("icon"));
            } 
            catch (Exception ex) 
            {}
            p2.add(minipanel2);
            this.add(p2);    
            
            // ajout du panel contenant les cartes
            
            p3.setBackground(new Color(150, 150, 150,200));
            p3.setBorder(BorderFactory.createLineBorder(Color.black));
            p3.setBounds( 635, 210,270, 370);
            choix.setBounds(30, 30, 200, 30);
            choix.setOpaque(false);
            p3.add(choix);
            pimage1.setBackground(new Color(255, 255, 255,200));
            pimage1.setBorder(BorderFactory.createLineBorder(Color.black));
            pimage1.setBounds(30, 90, 90, 110);
            
            //image1.setBounds(0, 0, 90, 110);
            
            try
            { 
                buf1 = ImageIO.read(new File("image/bleu.jpg"));
                image1 = new JLabel(new ImageIcon(buf1));
                image1.setBounds(0, 0, 90, 110);
                pimage1.add(image1);
                image1.addMouseListener(listener);
                image1.setTransferHandler(handler);    
            }
            catch(Exception e)
            {}

            pimage1.add(image1);
            p3.add(pimage1);
            
            
            
            
            
           
            pimage2.setBackground(new Color(255, 255, 255,200));
            pimage2.setBorder(BorderFactory.createLineBorder(Color.black));
            pimage2.setBounds(150, 90, 90, 110);
            
            try
            { 
                buf2 = ImageIO.read(new File("image/noir.jpg"));
                image2 = new JLabel(new ImageIcon(buf2));
                image2.setBounds(0, 0, 90, 110);
                pimage2.add(image2);
                image2.addMouseListener(listener);
                image2.setTransferHandler(handler);    
            }
            catch(Exception e)
            {}

            pimage2.add(image2);
            p3.add(pimage2);

            
            
            pimage3.setBackground(new Color(255, 255, 255,200));
            pimage3.setBorder(BorderFactory.createLineBorder(Color.black));
            pimage3.setBounds(30, 230, 90, 110);
            
            try
            { 
                buf3 = ImageIO.read(new File("image/vert.jpg"));
                image3 = new JLabel(new ImageIcon(buf3));
                image3.setBounds(0, 0, 90, 110);
                pimage3.add(image3);
                image3.addMouseListener(listener);
                image3.setTransferHandler(handler);    
            }
            catch(Exception e)
            {}

            pimage3.add(image3);
            p3.add(pimage3);


            pimage4.setBackground(new Color(255, 255, 255,200));
            pimage4.setBorder(BorderFactory.createLineBorder(Color.black));
            pimage4.setBounds(150, 230, 90, 110);
            
            try
            { 
                buf4 = ImageIO.read(new File("image/rouge.jpg"));
                image4 = new JLabel(new ImageIcon(buf4));
                image4.setBounds(0, 0, 90, 110);
                pimage4.add(image4);
                image4.addMouseListener(listener);
                image4.setTransferHandler(handler);    
            }
            catch(Exception e)
            {}

            pimage4.add(image4);
            p3.add(pimage4);            

            
            
            this.add(p3);
            // bouton retour
            retour.addActionListener(this);
            this.add(retour);
            retour.setBounds(825, 620, 150, 30);
            
            this.repaint();
        }
        if(source == fermer)
        {
            this.dispose();
        }
        if(source == credits)
        {
            this.remove(bouton);
            this.remove(fermer);
            this.remove(regles);
            this.remove(credits);
            this.remove(charger);

//label_credits.setSize(350,100);
            label_credits.setText("<html>Bienvenue dans les crédits du jeu Shitenno. "
                    + "Ce jeu a été créé par Arab Sabrina, Junger Pauline, Kedziora Thomas, lienhardt Damien, Pillot Eddy.</html>");
            label_credits.setOpaque(true);
            label_credits.setBackground(new Color(150, 150, 150,200));
            label_credits.setForeground(Color.BLACK);
            label_credits.setBounds(350, 100, 500, 500);
            this.add(label_credits);
            
            // bouton retour
            retour.addActionListener(this);
            this.add(retour);
            retour.setBounds(525, 620, 150, 30);
            
            this.repaint();
        }
        if(source == regles)
        {  
            Desktop d = Desktop.getDesktop();
            try {
                d.open(new File("regles.pdf"));
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source == retour)
        {
            this.remove(label_credits);
            this.remove(retour);
            this.remove(p2);
            this.remove(p1);
            this.remove(p3);
            //retour a l'affichage de base

    // bouton lancer partie
    
    this.setLayout(null);
    bouton.addActionListener(this);
    this.add(bouton);
    bouton.setBounds(500, 210, 200, 40);
    
    // bouton charger partie
    
    this.setLayout(null);
    charger.addActionListener(this);
    this.add(charger);
    charger.setBounds(500, 280, 200, 40);
            // bouton règles

            regles.addActionListener(this);
            this.add(regles);
            regles.setBounds(500, 350, 200, 40);


            // bouton crédits

            credits.addActionListener(this);
            this.add(credits);
            credits.setBounds(500, 420, 200, 40);

            // bouton quitter

            fermer.addActionListener(this);
            this.add(fermer);
            fermer.setBounds(500, 490, 200, 40);
            
            this.repaint();
        }
        if(source == check1)
        {
            check2.setSelected(false);
            check3.setSelected(false);
            this.p2.remove(l3);
            this.p2.remove(l4);
            this.p2.remove(jtf3);
            this.p2.remove(jtf4);
            this.p2.remove(minipanel3);
            this.p2.remove(minipanel4);
            
            // on remet en place les composants pour 2 joueurs
            
            p2.setBounds(220, 275, 350, 250);
            l1.setBounds(25, 70, 60, 30);
            jtf1.setBounds(110, 70, 80, 30);
            minipanel1.setBounds(230, 10, 90, 110);
            l2.setBounds(25, 150, 60, 30);
            jtf2.setBounds(110, 150, 80, 30);
            minipanel2.setBounds(230, 125, 90, 110);
            this.repaint();
        }
        if(source == check2)
        {
            check1.setSelected(false);
            check3.setSelected(false);
            this.p2.remove(l4);
            this.p2.remove(jtf4);
            this.p2.remove(minipanel4);
            //modification de la taille du panel et du positionnement des joueurs 1 et 2
            
            p2.setBounds(220, 220, 350, 365);
            l1.setBounds(25, 55, 60, 30);
            jtf1.setBounds(110, 55, 80, 30);
            l2.setBounds(25, 165, 60, 30);
            jtf2.setBounds(110, 165, 80, 30);
            
            // ajout des zones de saisie et des labels pour le troisième joueur
            l3.setBounds(25, 280, 60, 30);
            l3.setOpaque(false);
            p2.add(l3);
            jtf3.setBounds(110, 280, 80, 30);
            p2.add(jtf3);
            minipanel3.setBackground(new Color(255, 255, 255,200));
            minipanel3.setBorder(BorderFactory.createLineBorder(Color.black));
            minipanel3.setBounds(230, 240, 90, 110);
            
            try
            { 
                bufmini3 = ImageIO.read(new File("image/blanc.png"));
                b3 = new JLabel(new ImageIcon(bufmini3));
                b3.setBounds(0, 0, 90, 110);
                minipanel3.add(b3);
                b3.setTransferHandler(new TransferHandler("icon"));
            } 
            catch (Exception ex) 
            {}
            
            
            p2.add(minipanel3);
            this.repaint();
        }
        if(source == check3)
        {
            check1.setSelected(false);
            check2.setSelected(false);

            //modification de la taille du panel et du positionnement des joueurs 1 et 2
            
            p2.setBounds(220, 180, 350, 475);
            l1.setBounds(25, 55, 60, 30);
            jtf1.setBounds(110, 55, 80, 30);
            l2.setBounds(25, 165, 60, 30);
            jtf2.setBounds(110, 165, 80, 30);
            
            // ajout des zones de saisie et des labels pour le troisième joueur
            l3.setBounds(25, 280, 60, 30);
            l3.setOpaque(false);
            p2.add(l3);
            jtf3.setBounds(110, 280, 80, 30);
            p2.add(jtf3);
            minipanel3.setBackground(new Color(255, 255, 255,200));
            minipanel3.setBorder(BorderFactory.createLineBorder(Color.black));
            minipanel3.setBounds(230, 240, 90, 110);
            
            try
            { 
                bufmini3 = ImageIO.read(new File("image/blanc.png"));
                b3 = new JLabel(new ImageIcon(bufmini3));
                b3.setBounds(0, 0, 90, 110);
                minipanel3.add(b3);
                b3.setTransferHandler(new TransferHandler("icon"));
            } 
            catch (Exception ex) 
            {}
            
            p2.add(minipanel3);
            l4.setBounds(25, 395, 60, 30);
            l4.setOpaque(false);
            p2.add(l4);
            jtf4.setBounds(110, 395, 80, 30);
            p2.add(jtf4);
            minipanel4.setBackground(new Color(255, 255, 255,200));
            minipanel4.setBorder(BorderFactory.createLineBorder(Color.black));
            minipanel4.setBounds(230, 355, 90, 110);
            
            try
            { 
                bufmini4 = ImageIO.read(new File("image/blanc.png"));
                b4 = new JLabel(new ImageIcon(bufmini4));
                b4.setBounds(0, 0, 90, 110);
                minipanel4.add(b4);
                b4.setTransferHandler(new TransferHandler("icon"));
            } 
            catch (Exception ex) 
            {}
            p2.add(minipanel4);
            this.repaint();
        }
        
        
    }
    
    /*
    class StateListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      //System.out.println("source : " + ((JCheckBox)e.getSource()).getText() + " - état : " + ((JCheckBox)e.getSource()).isSelected());
        Object source = e.getSource();
        if(source == check1)
        {
            check2.setSelected(false);
            check3.setSelected(false);
        }
    
        if(source == check2)
        {
            check1.setSelected(false);
            check3.setSelected(false);
        }
        if(source == check3)
        {
            check1.setSelected(false);
            check2.setSelected(false);
        }
    }
  }
*/
    
}
