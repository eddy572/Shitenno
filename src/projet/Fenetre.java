package projet;



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
    
    
  public Fenetre(){        
    this.setTitle("Shitenno");
    this.setSize(1200, 700);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    // personnalisation de l'affichage du plateau
    
    Panneau p = new Panneau();
    
    // personnalisation de l'affichage de la main du joueur
    Mainjoueur m = new Mainjoueur();
    m.setLayout(null);
    quitter.addActionListener(this);
    m.add(quitter);
    quitter.setBounds(1080,20,80,30);
    
    passer_tour.addActionListener(this);
    m.add(passer_tour);
    passer_tour.setBounds(1080,70,80,30);
   
    //parametrage du jpanel
    
    JSplitPane contenu = new JSplitPane(JSplitPane.VERTICAL_SPLIT,p,m);
    contenu.setResizeWeight(0.8);

    // ajouter bouton retour

    this.add(contenu);
    //this.setContentPane(new Panneau());
    //this.setContentPane(new Mainjoueur());
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
