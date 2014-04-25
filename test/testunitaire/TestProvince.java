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

    //Set
    Set<Province> setp;
    //Instance
    Joueur joueur = new Joueur();
    General general = new General();
    Lot lot = new Lot();
    Initialisation init = new Initialisation();
    Province prov = new Province();
    //LinkedList
    LinkedList<Kokus> llk = new LinkedList<Kokus>();
    LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
    LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();
    //Kokus
    Kokus k1 = new Kokus(1);
    Kokus k2 = new Kokus(2);
    Kokus k3 = new Kokus(3);
    //Troupes et Cartes Troupes
    Troupes sohei = new Troupes("Sohei", "Orange");
    CarteTroupe ct1 = new CarteTroupe(sohei, sohei);
    Troupes samourai = new Troupes("Samourai", "Vert");
    CarteTroupe ct2 = new CarteTroupe(samourai);
    Troupes bushi = new Troupes("Bushi", "Bleu");
    CarteTroupe ct3 = new CarteTroupe(bushi, bushi);
    //ArrayList
    ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
    ArrayList<Kokus> alk = new ArrayList<Kokus>(llk);

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
     * @assertNotNull il y a un tairo
     */
    @Test
    public void TestbonusCommeTroupe() {

        lltb = init.initialisationTuileBonus();
        prov.setLltuilebonus(lltb);
        //Il reste toutes les tuiles bonus donc bonusCommeTroupe() ne doit pas renvoyer null
        assertNotNull(prov.bonusCommeTroupe());

    }

    /**
     *
     * On teste si la province est sous contrôle
     *
     * @assertNotNull il y a un tairo
     */
    @Test
    public void testprovinceSousControle() {
        Province p = new Province();

        for (Province pr : init.getHashProvince()) {
            p = pr;
            break;

        }
        //Vérifier que la province n'est pas sous contrôle
        assertFalse(p.provinceSousControle());

    }

    /**
     *
     * On teste le nombre de kokus necessaire
     *
     * @assertEquals sur le nombre de kokus
     */
    @Test
    public void testnbKokusNecessaires() {

        Province p = new Province();
        for (Province pr : init.getHashProvince()) {
            p = pr;
            break;

        }
        //Il faut 3 kokus pour la province
        assertEquals(3, p.nbKokusNecessaires());
    }

    /**
     *
     * On teste s'il y a un kamon dans la province
     *
     * @assertNotNull il y a un tairo
     */
    @Test
    public void testaUnKamonDansLaProvince() {

        Province p = new Province();
        for (Province pr : init.getHashProvince()) {
            p = pr;
            break;

        }
        //Pas de kamon du joueur dans la province
        assertFalse(p.aUnKamonDansLaProvince(joueur));
    }

}
