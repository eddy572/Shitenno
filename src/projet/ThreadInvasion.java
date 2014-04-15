/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import classes.Initialisation;
import classes.Joueur;
import classes.Province;
import classes.TuileBonus;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Thread.sleep;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public class ThreadInvasion extends Thread
{
    private Fenetre jf;
    private PanelInvasion pi;
    private PanelMainJoueur pmj;
    JPanel panelplateau = new JPanel();
    private Set<Province> Provinces;
    private Initialisation init;
    private Joueur tabJ[];
    
        MouseListener ml = new MouseListener(){

       @Override
       public void mousePressed(MouseEvent me) {
    
           PanelProvince p = (PanelProvince)me.getSource();
           System.out.println(p);
           panelplateau.setVisible(false);
           //f.panelplateau.setEnabled(false);
           jf.repaint();
           PanelInvasion pi = new PanelInvasion(jf,p);
           
           
         
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
    
    
    
    
    
    
    public ThreadInvasion(Fenetre j,Initialisation init, Set<Joueur> hjoueur, Joueur tabJ[]) {
        this.init=init;
        this.tabJ=tabJ;
        jf=j;
    }

    
    
    public void run() { 
    
    
    
    // initialisation des provinces et mise en place des panels sur chaque province !
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
    
    
    
    
    
    
    
    
    while(true)
    {
        
        jf.teest=jf.teest+1;
        System.out.println("invasion :"+jf.teest);
    System.out.println("************************DEBUT Invasion***************************");
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadConceptionPaquet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    this.pmj = new PanelMainJoueur(tabJ[0]);
        System.out.println(tabJ[0]);
    jf.add(panelplateau);
    jf.add(pmj);
    jf.repaint();
    
    
        try {
           sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadConceptionPaquet.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf.remove(this.pmj);
        jf.remove(panelplateau);
        jf.repaint();
        System.out.println("************************FIN Invasion***************************");        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadConceptionPaquet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
    
}
