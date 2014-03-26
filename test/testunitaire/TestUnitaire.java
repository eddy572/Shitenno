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
    public void testInitialisationJeu() {
         Set sbonus = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
         assertEquals("Effet : Echange\nEffet : +1\nEffet : Pioche", sbonus);
    }
    
    // @Test
    public void testInitialisationPaquetTroupe() {
         LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
         Initialisation init = new Initialisation();
         llct = init.initialisationPaquetTroupe();
         
         StringBuilder s = new StringBuilder();
         for(int i=0; i<24; i++){
             if(i==0 || (i>0 && i<6)){s.append("Cette carte n'a qu'une troupe : ").append("Sohei");}
             if(i>5 && i<12){s.append("Cette carte n'a qu'une troupe : ").append("Bushi");}
             if(i>11 && i<18){s.append("Cette carte n'a qu'une troupe : ").append("Shinobi");}
             if(i>17){s.append("Cette carte n'a qu'une troupe : ").append("Samouraï");}
         }
         assertEquals(s, llct.toString());
    }
    
    // @Test
    public void testInitialisationPaquetKokus() {
         LinkedList<Kokus> llk = new LinkedList<Kokus>();
         Initialisation init = new Initialisation();
         llk = init.initialisationPaquetKokus();
         assertEquals("[3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2]", llk.toString());
    }
    
    // @Test
    public void testInitialisationTuileBonus() {
         LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();
         Initialisation init = new Initialisation();
         lltb = init.initialisationTuileBonus();
         assertEquals("[3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2]", lltb.toString());
    }
}
