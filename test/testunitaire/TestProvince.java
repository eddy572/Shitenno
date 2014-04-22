/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testunitaire;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import classes.*;

/**
 *
 * @author PaulineJngr
 */
public class TestProvince {

    LinkedList<Kokus> llk = new LinkedList<Kokus>();
    LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();
    LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
    Initialisation init = new Initialisation();
    Lot lot = new Lot();
    Joueur joueur = new Joueur();
    Province prov = new Province();
    Tairo tairo = new Tairo();
    Set<Joueur> jouer = new HashSet<>();
    Set<Titre> listt;
    Titre titre = new Titre();

    public TestProvince() {
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

    /**
     *
     * On teste que le joueur ayant le plus haut titre devient le tairo
     *
     * @assertNull au départ il n'y a pas de tairo
     * @assertNotNull il y a un tairo
     */
    @Test
    public void TestbonusCommeTroupe() {

        lltb = init.initialisationTuileBonus();
        prov.setLltuilebonus(lltb);
        //Il reste toutes les tuiles bonus donc bonusCommeTroupe() ne doit pas renvoyer null
        assertNotNull(prov.bonusCommeTroupe());

    }

}
