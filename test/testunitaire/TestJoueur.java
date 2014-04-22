package testunitaire;

import classes.*;
import java.util.ArrayList;
import java.util.HashSet;
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
    private Set<Province> sp;
    private Set<Joueur> hJoueur;
    private Joueur j1;
    private Joueur j2;
    private Joueur j3;
    private Joueur j4;
    
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
        
        hJoueur = new HashSet<>();
        j1 = new Joueur("J1", 10);
        j2 = new Joueur("J2", 10);
        j3 = new Joueur("J3", 10);
        j4 = new Joueur("J4", 10); 
        hJoueur.add(j1);
        hJoueur.add(j2);
        hJoueur.add(j3);
        hJoueur.add(j4);
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
        //assertFalse(joueur.aLesTroupesNecessaires(p));
    }
    
    
    public void testScoreFinal(){
        for(Province p : sp){
            Controle[] c = p.getControle();
            switch(p.getNom()){
                case "Kanto" : c[0] = new Controle(j1);
                    break;
                case "Hokkaido" : c[0] = new Controle(j1);
                                  c[1] = new Controle(j2);
                    break;
                case "Shikoku" : c[0] = new Controle(j1);
                                 c[1] = new Controle(j2, true);
                    break;
                case "Chubu" : c[0] = new Controle(j1);
                               c[1] = new Controle(j2, true);
                               c[2] = new Controle(j1);
                    break;
                case "Kyushu" : c[0] = new Controle(j1);
                                c[1] = new Controle(j3);
                                c[2] = new Controle(j2, true);
                                c[3] = new Controle(j2);
                    break;
                case "Kansai" : c[0] = new Controle(j1);
                                c[1] = new Controle(j2);
                                c[2] = new Controle(j3, true);
                                c[3] = new Controle(j4);
                    break;
            }
            p.setControle(c);
        }
        
        for(Joueur j : hJoueur){
            j.scoreFinal(sp);
        }
        
        // Phase de tests
        assertEquals(18, j1.getScore());
        assertEquals(12, j2.getScore());
        assertEquals(6, j3.getScore());
        assertEquals(0, j4.getScore());
    }
}
