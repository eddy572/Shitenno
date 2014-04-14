package testunitaire;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import classes.*;
import classes.Kokus;

/**
 *
 * @author Damien
 */
public class TestUnitaire {
<<<<<<< HEAD
    private Iterable<Joueur> hjoueur;
    private int i;
=======

>>>>>>> Partage
    
   
    
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

<<<<<<< HEAD
    //@Test
   /* public void testInitialisationJeu() {
         Set sbonus = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
         assertEquals(3, sbonus.size());
        
         
    }
    */
    
<<<<<<< HEAD
=======
    
=======
   
    //SPRINT 1
>>>>>>> Partage
    /**
    *
    * On teste l'initialisation du paquet Troupe
    * @assertEquals sur la taille du paquet
    */
>>>>>>> Classes
     @Test
    public void testInitialisationPaquetTroupe() {
         LinkedList<CarteTroupe> alct = new LinkedList<CarteTroupe>();
         Initialisation init = new Initialisation();
         alct = init.initialisationPaquetTroupe();
  
         //Vérifier que la liste n'est pas null
         assertNotNull(alct);
         //Vérifier qu'il y a bien 34 cartes
         assertEquals(34,  alct.size());
<<<<<<< HEAD
         
        /* StringBuilder s = new StringBuilder();
         for(int i=0; i<24; i++){
             if(i==0 || (i>0 && i<6)){s.append("Cette carte n'a qu'une troupe : ").append("Sohei");}
             if(i>5 && i<12){s.append("Cette carte n'a qu'une troupe : ").append("Bushi");}
             if(i>11 && i<18){s.append("Cette carte n'a qu'une troupe : ").append("Shinobi");}
             if(i>17){s.append("Cette carte n'a qu'une troupe : ").append("Samouraï");}
         }
         assertEquals(s, alct.toString());*/
=======
>>>>>>> Classes
    }
    
        /**
    *
    * On teste l'initialisation du paquet Kokus
    * @assertEquals sur la taille du paquet
    */
    @Test
    public void testInitialisationPaquetKokus() {
<<<<<<< HEAD
     //    Set skokus = new JDom("src/fichierxml/Kokus.xml").initialisationJeu("Kokus");
       //  assertEquals("3", skokus.size());
         
         ArrayList<Kokus> alk = new ArrayList<Kokus>();
         Initialisation init = new Initialisation();
         alk = init.initialisationPaquetKokus();

        
         assertEquals(24,  alk.size());
       // assertEquals(4, alk.);
         
        
    }

}
=======
         LinkedList<Kokus> alk = new LinkedList<Kokus>();
         Initialisation init = new Initialisation();
         alk = init.initialisationPaquetKokus();
        
<<<<<<< HEAD
         assertEquals(24,  alk.size());  
         assertNotSame("[3,3,3,3,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1]", alk.toString());
         System.out.println(alk.toString());
=======
         //Vérifier que la liste n'est pas null
         assertNotNull(alk);
         //Vérifier qu'il y a bien 24 cartes
         assertEquals(24,  alk.size());  
         //Vérifier que c'est bien mélangé
         assertNotSame("[3,3,3,3,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1]", alk.toString());
        
>>>>>>> Partage
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
          
         //Vérifier que la liste n'est pas null
         assertNotNull(lltb);
         //Vérifier qu'il y a bien 24 tuiles        
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
         
        //Vérifier que la liste n'est pas null
         assertNotNull(lct);
         //Vérifier qu'il y a bien 34 cartes
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
        
         //Vérifier que la liste n'est pas null
         assertNotNull(list);
         //Vérifier qu'il y a bien 4 titres
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

   
    /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
   public void testNombreDeCartesTroupesAPiocher(){
   
       Set<Joueur> joueur = new HashSet<>();
       Joueur jouer = new Joueur();
       Initialisation init = new Initialisation();  
       
       
       Joueur j1 = new Joueur("J1");
       Joueur j2 = new Joueur("J2");
       Joueur j3 = new Joueur("J3");
       Joueur j4 = new Joueur("J4");
       
       //Vérifier pour 2 joueurs
       joueur.add(j2);
       joueur.add(j1);
       assertEquals(4, init.nombreDeCartesTroupesAPiocher(joueur));
       
       //Vérifier pour 3 joueurs
       joueur.add(j3);
       assertEquals(6, init.nombreDeCartesTroupesAPiocher(joueur));
       
       //Vérifier pour 4 joueurs
       joueur.add(j4);
       assertEquals(8, init.nombreDeCartesTroupesAPiocher(joueur));
     
   }
   
<<<<<<< HEAD
   
=======
  
>>>>>>> Partage
}
>>>>>>> Classes
