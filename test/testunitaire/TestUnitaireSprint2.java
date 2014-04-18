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
    //************ CLASSE LOT ***************
      /**
    * TEST EFFECTUE SUR LA REPONSE OUI OU NON EN BRUT ET NON PAS PAR SCANNER
    * Activer la fonction uniquement pour la reponse en brut
    * On teste si la saisie est bien à oui ou à non
    * @assertEquals sur la valeur de la saisie
    */
   //@Test
   public void testOuiOuNon(){
             
        //Vérifier la valeur du résultat attendu 
        Lot lot = new Lot();
        String s1 = "OUI";
        String s2 = "Non";
        String s3 = "Bonjour";
        
        //Vérifier que ouiOuNon() accepte "OUI" 
        assertTrue(lot.ouiOuNon().equalsIgnoreCase(s1));
        //Vérifier que ouiOuNon() accepte "Non" 
        assertTrue(lot.ouiOuNon().equalsIgnoreCase(s2));        
        //Vérifier que ouiOuNon() n'accepte pas "Bonjour" 
        assertFalse(lot.ouiOuNon().equalsIgnoreCase(s3));
        
        //  boolean ok = false;
      
        //Condition égalité
        /*if (("OUI".equals(s1) || "Oui".equals(s1) || "OUi".equals(s1) || "oui".equals(s1))&&("NON".equals(s1) 
                || "Non".equals(s1) || "NOn".equals(s1) || "non".equals(s1))){
            ok = true;
            assertTrue(ok);
        }
        assertFalse(ok);
         */

        
   }
   
    /**
    *
    * On teste quel joueur va recevoir le lot
    * @assertEquals 
    */
    // @Test
    public void TestjoueurQuiRecoitLot(){  
        //---------------------NULL POINTER EXCEPTION----------------------
       Set<Joueur> joueur = new HashSet<>();
 
       Lot lot = new Lot();
       
       Joueur j1 = new Joueur("J1");
       Joueur j2 = new Joueur("J2");
       Joueur j3 = new Joueur("J3");
       Joueur j4 = new Joueur("J4");
       Tairo tairo = new Tairo(j1);
       joueur.add(j1);
       joueur.add(j2);
       joueur.add(j3);
       joueur.add(j4);
       Titre titre = new Titre();
       lot.joueurQuiRecoitLot(joueur, tairo);
       
       for(Joueur j : joueur){
           lot.setTitre(lot.getTitre());
       }
        titre = lot.getTitre();
       
      // assertTrue(lot.joueurQuiRecoitLot(joueur, tairo).equals(j2));
       assertEquals("Tairo", titre);
       
       
    }
    
    /**
    *
    * On teste l'existence d'une carte selon son type donnée
    * @assertEquals sur l'existence de la carte en fonction du type
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
    * On teste la conversion d'un string en carte kokus
    * @assertEquals sur le retour de la fonction
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
    * On teste la conversion d'un string en carte troupe
    * @assertEquals sur le retour de la fonction
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
    * On teste le choix d'une truile de hierarchie
    * @assertEquals sur l'existence de la carte voulue
    */
   @Test
    public void TestchoixTuileHierarchie(){
        Set<Titre> list;
        Initialisation init = new Initialisation();
        list = init.getHashTitre();
        ArrayList<Titre> altitre=new ArrayList<Titre>(list); 
        //Lot lot = new Lot();
        
       
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
    * TEST EFFECTUE SUR L'AJOUT DE CARTES TROUPES EN BRUT ET PAS PAR DES SCANNER
    * Activer la fonction uniquement pour l'ajout en brut
    * On teste le retour de la fonction
    * @assertEquals sur le retour des cartes troupes
    */
    //@Test
    public void TestchoixDesCartesTroupes(){
        //Vérifier cette fonction sans les scanner, données entrées en brut.
        LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
        Initialisation init = new Initialisation();
        llct = init.initialisationPaquetTroupe();
        ArrayList<CarteTroupe> alct=new ArrayList<CarteTroupe>(llct);
        Lot lot = new Lot();
        
        lot.setAlct(alct);
        //Vérifier que l'arraylist n'est pas vide
        assertNotNull(alct);
        //Vérifier que le lot n'est pas nul
        assertNotNull(lot);
        //Vérifier que le retour de la fonction contient des éléments de alct
        assertTrue(lot.choixDesCartesTroupes().containsAll(alct));
        
    }
    
     /**
    * TEST EFFECTUE SUR L'AJOUT DE CARTES KOKUS EN BRUT ET PAS PAR DES SCANNER
    * Activer la fonction uniquement pour l'ajout en brut
    * On teste le retour de la fonction
    * @assertEquals sur le retour des cartes kokus
    */
    //@Test   
    public void TestchoixDesCartesKokus(){
        //Vérifier cette fonction sans les scanner, données entrées en brut.
        LinkedList<Kokus> llk = new LinkedList<Kokus>();
        Initialisation init = new Initialisation();
        llk = init.initialisationPaquetKokus();
        ArrayList<Kokus> alk=new ArrayList<Kokus>(llk);
        Lot lot = new Lot();
        
        lot.setAlk(alk);
        //Vérifier que l'arraylist n'est pas vide
        assertNotNull(alk);
        //Vérifier que le lot n'est pas nul
        assertNotNull(lot);
        //Vérifier que le retour de la fonction contient des éléments de alct
        assertTrue(lot.choixDesCartesKokus().containsAll(alk));
       
    }
    
    
    /**
    *
    * On teste la composition du lot
    * @assertEquals sur le fait que le lot composé ne soit pas nul
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
    
    
    
    //************** CLASSE JOUEUR *************
    /**
    * TEST EFFECTUE SUR LA REPONSE ACCEPTER OU REFUSER EN BRUT ET NON PAS PAR SCANNER
    * Activer la fonction uniquement pour la reponse en brut
    * On teste si la saisie est bien à oui ou à non
    * @assertEquals sur la valeur de la saisie
    */
    //@Test
    public void TestaccepterRefuserLot(){
        //Vérifier la valeur du résultat attendu 
        Lot lot = new Lot();
        Joueur joueur = new Joueur();
        String s1 = "accepter";
        String s2 = "refuser";
        String s3 = "Bonjour";
        
        //Vérifier que ouiOuNon() accepte "OUI" 
        assertTrue(joueur.accepterOuRefuser().equalsIgnoreCase(s1));
        //Vérifier que ouiOuNon() accepte "Non" 
        assertTrue(joueur.accepterOuRefuser().equalsIgnoreCase(s2));        
        //Vérifier que ouiOuNon() n'accepte pas "Bonjour" 
        assertFalse(joueur.accepterOuRefuser().equalsIgnoreCase(s3));
    }
    
    
    /**
    * 
    * On teste le nombre de cartes en main
    * @assertEquals sur le nb de carte en main
    */
    @Test
    public void testnombreDeCartesEnMain(){
        Joueur j1 = new Joueur("Pauline");
        Kokus k1 = new Kokus(1);
        Kokus k2 = new Kokus(2);
        Kokus k3 = new Kokus(3);
        Troupes shinobi = new Troupes("Shinobi", null);
        Troupes soheishi = new Troupes("Sohei", "Shinobi");
        CarteTroupe ct1 = new CarteTroupe(shinobi);
        CarteTroupe ct2 = new CarteTroupe(soheishi);
        //Ajout à la liste des kokus
        LinkedList<Kokus> llk = new LinkedList<Kokus>();
        ArrayList<Kokus> alk=new ArrayList<Kokus>(llk);
        alk.add(k1);
        alk.add(k2);
        alk.add(k1); 
        alk.add(k3);
        //Ajout à la liste des cartes troupes
        LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
        ArrayList<CarteTroupe> alct=new ArrayList<CarteTroupe>(llct);
        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct2);
        //Ajout des listes au joueur
        j1.setAlctroupe(alct);
        j1.setAlkokus(alk);
        
        //Vérifier que la liste des troupes du joueur n'est pas vide
        assertNotNull(j1.getAlctroupe());
        //Vérifier que la liste des kokus du joueur n'est pas vide
        assertNotNull(j1.getAlkokus());
        //nb de cartes
        int nbcartes = j1.nombreDeCartesEnMain();
        //Vérifie que le joueurs à des cartes
        assertEquals(7, nbcartes);
    }
}