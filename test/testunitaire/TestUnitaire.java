package testunitaire;

import java.io.*;
import java.util.*;
import jdom.JDom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import classes.*;

/**
 *
 * @author Damien
 */
public class TestUnitaire {
    private Iterable<Joueur> hjoueur;
    private int i;
    
   
    
    public TestUnitaire() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //@Test
   /* public void testInitialisationJeu() {
         Set sbonus = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
         assertEquals("Effet : Echange\nEffet : +1\nEffet : Pioche", sbonus);
    }
    */
    
    
    /**
    *
    * On teste l'initialisation du paquet Troupe
    * @assertEquals sur la taille du paquet
    */
     @Test
    public void testInitialisationPaquetTroupe() {
         LinkedList<CarteTroupe> alct = new LinkedList<CarteTroupe>();
         Initialisation init = new Initialisation();
         alct = init.initialisationPaquetTroupe();
         
         assertEquals(34,  alct.size());
    }
    
        /**
    *
    * On teste l'initialisation du paquet Kokus
    * @assertEquals sur la taille du paquet
    */
    @Test
    public void testInitialisationPaquetKokus() {
         LinkedList<Kokus> alk = new LinkedList<Kokus>();
         Initialisation init = new Initialisation();
         alk = init.initialisationPaquetKokus();
        
         assertEquals(24,  alk.size());  
         assertNotSame("[3,3,3,3,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1]", alk.toString());
         System.out.println(alk.toString());
    }
    
    
        /**
    *
    * On teste l'initialisation du paquet Tuile Bonus
    * @assertEquals sur la taille du paquet
    */
     @Test
    public void testInitialisationTuileBonus() {
         LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();
         Initialisation init = new Initialisation();
         lltb = init.initialisationTuileBonus();
         
         assertEquals(24, lltb.size());
    }
    
    /**
    *
    * On teste l'initialisation des différentes provinces
    * 
    */
    @Test
    public void testinitialisationFinaleProvince() {
           Set<Province> listp;
          
           Initialisation init = new Initialisation();
      
           listp = init.getHashProvince();
           //Nb final de province
           int resattendu1 = 8;
           assertEquals(resattendu1, listp.size());
           
           
    }
    
    /**
    *
    * On teste la distributions de cartes troupes
    * @assertEquals nombre de cartes troupes
    * @assertEquals nombre de cartes troupes par main
    */
    @Test
    public void testdistributionCartesDepart(){
        LinkedList<CarteTroupe> lct;
        Initialisation init = new Initialisation();
        lct = init.getLlctroupe();
        
          assertEquals(34, lct.size());
        
    }
    
    /**
    *
    * On teste la distribution du titre de départ
    * @assertEquals sur le nombre de titre à distribuer
    */
    @Test
    public void testdistributionTitreDepart(){
        Set<Titre> list;
        Initialisation init = new Initialisation();
        list = init.getHashTitre();
  
        assertEquals(4, list.size());
        
    }
    
    /**
    *
    * On teste l'ajout de trois tuiles bonus sur chaque province
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
    @Test
   public void testAjoutTroisTuileBonus(){ 
       
       Set<Province> listp;
       Initialisation init = new Initialisation();
       listp = init.getHashProvince();
       LinkedList<TuileBonus> set;
       set = init.initialisationTuileBonus();
       
       //Nb de tuile bonus par province
       Province instance = new Province();
       init.ajoutTroisTuileBonus(listp, set);
       for(Province p : listp){
           instance.setLltuilebonus(p.getLltuilebonus());
       }
        set = instance.getLltuilebonus();
        assertEquals(3, set.size());
   }
   
   
   
}
