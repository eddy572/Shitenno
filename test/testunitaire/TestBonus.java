/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testunitaire;

import classes.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
 * @author PaulineJngr
 */
public class TestBonus {

    //Set
    Set<Province> setp;
    //Instance
    Joueur joueur = new Joueur();
    General general = new General();
    Lot lot = new Lot();
    Initialisation init = new Initialisation();
    Bonus bonus = new Bonus();
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

    public TestBonus() {
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
    /* TESTS DES METHODES*/
    /**
     * ******************
     */
    
    /**
     *
     * On teste le retour de la fonction
     * @assertEquals sur la carte troupe retournée
     */
    @Test
    public void testbonusPlusUn() {
        //Vérifier que c'est la même carte troupe
        assertEquals(ct2, bonus.bonusPlusUn(samourai));

    }

    /**
     *
     * On teste le retour de la fonction
     * @assertEquals sur la carte koku retournée
     */
    @Test
    public void testbonusPlusun2() {
        //Vérifier que c'est la même carte koku
        assertEquals(k1, bonus.bonusPlusUn());

    }

    /**
     *
     * On teste la pioche des bonus
     * @assertEquals sur la dernière carte de la liste
     */
    @Test
    public void testbonusPioche() {
        llct = init.initialisationPaquetTroupe();
        //Vérifier que c'est bien la dernière carte de la liste
        assertEquals(llct.getLast(), bonus.bonusPioche(llct));
    }

}
