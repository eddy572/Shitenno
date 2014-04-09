package projet;



import classes.Initialisation;
import classes.Joueur;
import classes.Province;
import classes.TuileBonus;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
 
public class Fenetre extends JFrame implements ActionListener {
    
    JPanel panelplateau = new JPanel();
    JPanel mainjoueur = new JPanel();
    private JButton quitter = new JButton("Menu");
    private JButton passer_tour = new JButton("Passer");
    private PanelInvasion pi;
    private Fenetre f = this;
        MouseListener ml = new MouseListener(){

       @Override
       public void mousePressed(MouseEvent me) {
    
           PanelProvince p = (PanelProvince)me.getSource();
           System.out.println(p);
           f.panelplateau.setVisible(false);
           //f.panelplateau.setEnabled(false);
           f.repaint();
           PanelInvasion pi = new PanelInvasion(f,p);
           
         
       }

       @Override
       public void mouseReleased(MouseEvent me) {}

       @Override
       public void mouseEntered(MouseEvent me) {}

       @Override
       public void mouseExited(MouseEvent me) { }

       @Override
       public void mouseClicked(MouseEvent me) {}
   };
    private Joueur j1;
    private Initialisation init;
    private Set<Province> Provinces;
    
  public Fenetre(Menu m){     
      
    this.setTitle("Shitenno");
    this.setSize(1200, 750);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Panneau());
    this.setLayout(null);
    this.add(new PanelMainJoueur(m.j1));
    
    // personnalisation du panel recouvrant toute la frame
    panelplateau.setOpaque(false);
    panelplateau.setBounds(0, 0, 1200, 588);
    panelplateau.setLayout(null);
    this.add(panelplateau);
    
    
// initialisation des provinces et mise en place des panels sur chaque province !
      
      init = new Initialisation();
      Provinces = init.getHashProvince();
              for(Province pro : Provinces){
            //System.out.println("\n" + p.toString());
                  PanelProvince pp = new PanelProvince();
                  pp.p=pro;
                  pp.addMouseListener(ml);
                  pp.setOpaque(false);
                  panelplateau.add(pp);
                  if(pro.getNom().equals("Chugoku"))
                  pp.setBounds(67, 43, 297, 158);
                  
                  if(pro.getNom().equals("Chubu"))
                  pp.setBounds(399, 56, 297, 158);

                  if(pro.getNom().equals("Hokkaido"))
                  pp.setBounds(732, 45, 297, 158);
                  
                  if(pro.getNom().equals("Kyushu"))
                  pp.setBounds(51, 224, 297, 158);
               
                  if(pro.getNom().equals("Tohoku"))
                  pp.setBounds(857, 218, 297, 158);
                  
                  if(pro.getNom().equals("Shikoku"))
                  pp.setBounds(178, 400, 297, 158);
                  
                  if(pro.getNom().equals("Kansai"))
                  pp.setBounds(509, 378, 297, 158);
                  
                  if(pro.getNom().equals("Kanto"))
                  pp.setBounds(838, 394, 297, 158);
                  
            for(TuileBonus tb : pro.getLltuilebonus()){
                System.out.println(tb.toString());
            }
            
        }


    
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
