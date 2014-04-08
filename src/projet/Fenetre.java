package projet;



import classes.Initialisation;
import classes.Joueur;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
 
public class Fenetre extends JFrame implements ActionListener {
    
    JPanel panelplateau = new JPanel();
    JPanel mainjoueur = new JPanel();
    private JButton quitter = new JButton("Menu");
    private JButton passer_tour = new JButton("Passer");
    private JFrame frame_precedente;
    private Joueur j1;
    private Initialisation init;
 
    
  public Fenetre(JFrame f){     
    
    frame_precedente = f;
    
    this.setTitle("Shitenno");
    this.setSize(1200, 750);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Panneau());
    this.setLayout(null);

    // personnalisation du panel recouvrant toute la frame
    panelplateau.setOpaque(false);
    panelplateau.setBounds(0, 0, 1200, 800);
    this.add(panelplateau);
    
    // ajout des boutons passer sont tour et menu
    quitter.addActionListener(this);
    this.add(quitter);
    quitter.setBounds(1080,620,80,30);
    
    passer_tour.addActionListener(this);
    this.add(passer_tour);
    passer_tour.setBounds(1080,670,80,30);
    
    
    //this.setContentPane(new Panneau());
    //this.setContentPane(new Mainjoueur());
    
    // affichage de la frame 
    
    this.setVisible(true);
    
    
    
    
    
  }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object source =ae.getSource();
        if(source == quitter)
        {
            this.dispose();
            Menu menu = new Menu();
        }
        if(source == passer_tour)
        {
            // passer son tour
        }
    }

}
