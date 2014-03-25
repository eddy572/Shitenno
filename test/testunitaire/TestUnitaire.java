/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void testInitialisationJeu() {
         Set sbonus = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
         assertEquals("Effet : Echange\nEffet : +1\nEffet : Pioche", sbonus);
    }
    
    // @Test
    public void testInitialisationPaquetTroupe() {
         ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>();
         Initialisation init = new Initialisation();
         alct = init.initialisationPaquetTroupe();
         
         StringBuilder s = new StringBuilder();
         for(int i=0; i<24; i++){
             if(i==0 || (i>0 && i<6)){s.append("Cette carte n'a qu'une troupe : ").append("Sohei");}
             if(i>5 && i<12){s.append("Cette carte n'a qu'une troupe : ").append("Bushi");}
             if(i>11 && i<18){s.append("Cette carte n'a qu'une troupe : ").append("Shinobi");}
             if(i>17){s.append("Cette carte n'a qu'une troupe : ").append("Samouraï");}
         }
         assertEquals(s, alct.toString());
    }
    
    @Test
    public void testInitialisationPaquetKokus() {
         ArrayList<Kokus> alk = new ArrayList<Kokus>();
         Initialisation init = new Initialisation();
         alk = init.initialisationPaquetKokus();
         assertEquals("[3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2]", alk.toString());
    }
}
