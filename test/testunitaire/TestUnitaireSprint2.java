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
import java.security.Provider.Service;

/**
 *
 * @author Damien
 */
public class TestUnitaireSprint2 {
    private Iterable<Joueur> hjoueur;
    private int i;
    
   
    
    public TestUnitaireSprint2() {
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
    
    //SPRINT 2
    
      /**
    *
    * On teste si la saisie est bien à oui ou à non
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
   public void testOuiOuNon(){
             
        //Vérifier la valeur du résultat attendu 
        Lot lot = new Lot();
        String s1 = null;
        boolean ok = false;
      
        //Condition égalité
        if (("OUI".equals(s1) || "Oui".equals(s1) || "OUi".equals(s1) || "oui".equals(s1))&&("NON".equals(s1) 
                || "Non".equals(s1) || "NOn".equals(s1) || "non".equals(s1))){
            ok = true;
            assertTrue(ok);
        }
        assertFalse(ok);
   


        
   }
   
    /**
    *
    * On teste quel joueur va recevoir le lot
    * @assertEquals 
    */
  // @Test
    public void TestjoueurQuiRecoitLot(){  

    } 
    
    /**
    *
    * On teste l'existence d'une carte selon son type donnée
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
    public void TestverifieExistenceCarte(){
           String typeCarteK = "koku";
           String CarteK = "3";
           String CarteK1 = "6";
           String typeCarteT = "troupe";
           String CarteT = "Bushi";
           String CarteT1 = "Sohei & Sohei";
           String CarteT2 = "Pauline";
           
           
           
         LinkedList<Kokus> alk = new LinkedList<Kokus>();
         Initialisation init = new Initialisation();
         alk = init.initialisationPaquetKokus();
         
         LinkedList<CarteTroupe> alct = new LinkedList<CarteTroupe>();
         alct = init.initialisationPaquetTroupe();
         
         Lot lot = new Lot();
         lot.setAlk(new ArrayList(alk));
         lot.setAlct(new ArrayList(alct));
         //Vérifier les cartes Kokus
         assertTrue(lot.verifieExistenceCarte(CarteK, typeCarteK));
         assertFalse(lot.verifieExistenceCarte(CarteK1, typeCarteK));
         //Vérifier les cartes troupes double et simple
         assertTrue(lot.verifieExistenceCarte(CarteT, typeCarteT));
         assertTrue(lot.verifieExistenceCarte(CarteT1, typeCarteT));
         assertFalse(lot.verifieExistenceCarte(CarteT2, typeCarteT));

    }
    
    /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
    public void TestconvertirStringEnCarteKokus(){      
        LinkedList<Kokus> alk = new LinkedList<Kokus>();
        Initialisation init = new Initialisation();
        alk = init.initialisationPaquetKokus();
        String s1 = "Pauline";
        String s2 = "1";
        Lot lot = new Lot();
        lot.setAlk(new ArrayList(alk));
        
        //Vérifier que la liste est pas vide
        assertNotNull(alk);
        //Vérifier la mauvaise saisie
        assertNull(lot.convertirStringEnCarteKokus(s1));
        //Vérifier la bonne saisie
        assertNotNull(lot.convertirStringEnCarteKokus(s2));  
        
   }
    
     /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
    public void TestconvertirStringEnCarteTroupe(){
        LinkedList<CarteTroupe> alct = new LinkedList<CarteTroupe>();
        Initialisation init = new Initialisation();
        alct = init.initialisationPaquetTroupe();
        
        String s1 = "Pauline";
        String s2 = "Shinobi";
        Lot lot = new Lot();
        lot.setAlct(new ArrayList(alct));
        
        //Vérifier que la liste est pas null
        assertNotNull(alct);
        //Vérifier la mauvaise saisie
        assertNull(lot.convertirStringEnCarteTroupe(s1));
        //Vérifier la bonne saisie
        assertNotNull(lot.convertirStringEnCarteTroupe(s2));
   }
    
    /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
    public void TestchoixTuileHierarchie(){
        Set<Titre> list;
        Initialisation init = new Initialisation();
        list = init.getHashTitre();
        ArrayList<Titre> altitre=new ArrayList<Titre>(list); 
        Lot lot = new Lot();
        
       
        String s1 = "Hatamoto";
        String s2 = "Daimyo";
        String s3 = "Shomyo";
        String s4 = "Sensei";
        
        //Vérifier que l'arraylist est complétée
        assertEquals(4, altitre.size());
       
        
        //Vérifier que les 4 titres sont possibles et sont dans la liste
        assertEquals(s1, altitre.get(2).getNom());
        assertEquals(s2, altitre.get(1).getNom());  
        assertEquals(s3, altitre.get(3).getNom());
        assertEquals(s4, altitre.get(0).getNom());
       
    }
    
    /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
  // @Test
    public void TestchoixDesCartesTroupes(){
        
    }
    
     /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
  // @Test   
    public void TestchoixDesCartesKokus(){

    }
    
    
    /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   @Test
    public void TestcompositionDuLot(){
        Lot lot = new Lot();
        Set<Titre> stitre;  
        Initialisation init = new Initialisation();
        stitre = init.getHashTitre();
        ArrayList<Titre> setList=new ArrayList<Titre>(stitre); 
        System.out.println(lot.toString());
        //Vérifier que la liste n'est pas vide
        assertNotNull(setList);
        //Vérifier qu'elle a bien 4 titres
        assertEquals(4, setList.size());
        
        //Ajout dans le lot
        lot.setAlct(new ArrayList(setList));
        //Vérifier qu'il est pas null
        assertNotNull(lot);
       // System.out.println(lot.toString());
     
    }
    
    /**
    *
    * On teste le nombre de cartes troupes à piocher par joueurs
    * @assertEquals sur le nombre de tuiles bonus sur la province
    */
   //@Test
    public void TestsoumettreLeLot(){
        Lot lot = new Lot();
        
        
        Set<Titre> stitre;  
        Initialisation init = new Initialisation();
        stitre = init.getHashTitre();
        ArrayList<Titre> altitre=new ArrayList<Titre>(stitre); 
        
        lot.setAlct(new ArrayList(altitre));
        
        String reponse = "oui";
        lot.soumettreLeLot(altitre, lot);
        
       // lot.toString();
       // assertNotNull(lot); 
                    
    }
    
    
    //@Test
    public void TestremettreCarteDansPiocheTairo(){
        
        
    }
    
   
     /**
    *
    * On teste le nombre de kamons par joueurs
    * @assertEquals sur le nombre de kamons en fonction du nb de joueurs
    */  
    @Test
    public void TestnombreKamonInitial(){
        Joueur joueur = new Joueur();        
        
        assertEquals(12, joueur.nombreKamonInitial(2));
        assertEquals(10, joueur.nombreKamonInitial(3));
        assertEquals(8, joueur.nombreKamonInitial(4));
    }
    
    
    
    
}