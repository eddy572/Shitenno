/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testunitaire;

import classes.*;
import java.util.ArrayList;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damien
 */
public class TestJoueur extends TestCase{
    private General general;
    private Joueur joueur;
    private Initialisation init;
    Set<Province> sp;
    
    public TestJoueur() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        general = new General("Naomasa", "Li", "Noir");
        joueur = new Joueur("Joueur1", general, 10);
        init = new Initialisation();
        sp = init.getHashProvince();
    }
    
    @After
    public void tearDown() {
    }

    /*********************/
    /* Méthodes de tests */
    /*********************/
    @Test
    public void testALesTroupesNecessaires(){
        Province p = null;
        for(Province pr : sp){
            p = pr;
            break;
        }
        // Aucune troupe dans la main du joueur
        assertFalse(joueur.aLesTroupesNecessaires(p));
    }
}
