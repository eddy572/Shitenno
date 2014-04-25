/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testunitaire;

import classes.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PaulineJngr
 */
public class TestTitre {

    //Set
    Set<Province> setp;
    //Instance
    Joueur joueur = new Joueur();
    General general = new General();
    Initialisation init = new Initialisation();
    Titre titre = new Titre();

    public TestTitre() {
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
        setp = init.getHashProvince();
    }

    @After
    public void tearDown() {
    }

    /**
     * ******************
     */
    /* TESTS SUR METHODE
     /**
     * ******************
     */
    /**
     *
     * On teste le nb retourné
     *
     * @assertEquals à 2
     */
    @Test
    public void testtuileDaimyo() {
        //Retourne bien 2
        assertEquals(2, titre.tuileDaimyo());
    }

    /**
     *
     * On teste le nb retourné
     *
     * @assertEquals à 1
     */
    @Test
    public void testtuileShomyo() {
        //Retourne bien 1
        assertEquals(1, titre.tuileShomyo());
    }

}
