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
public class TestTairo {

    LinkedList<Kokus> llk = new LinkedList<Kokus>();
    LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
    Initialisation init = new Initialisation();
    Lot lot = new Lot();
    Joueur joueur = new Joueur();
    Tairo tairo = new Tairo();
    Set<Joueur> jouer = new HashSet<>();
    Set<Titre> listt;
    Titre titre = new Titre();

    public TestTairo() {
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
     * @assertNull au départ il n'y a pas de tairo
     * @assertNotNull il y a un tairo
     */
    @Test
    public void TestdevientLeTairo() {
        
        //Vérifier qu'au départ le tairo est à null
        assertNull(tairo.getTairo().getPseudo());

        Titre titre1 = new Titre("Daimyo", 4, "+2");
        Titre titre2 = new Titre("Hatamoto", 1, "Troupe supplémentaire");
        ArrayList<Joueur> alj = new ArrayList<>(jouer);
        Joueur j1 = new Joueur("Pauline", titre1);
        Joueur j2 = new Joueur("Damien");
        Joueur j3 = new Joueur("Eddy");
        Joueur j4 = new Joueur("Thomas", titre2);
        alj.add(j1);
        alj.add(j2);
        alj.add(j3);
        alj.add(j4);

        for (Joueur j : alj) {
            tairo.devientLeTairo(alj);
            break;
        }
        //Vérifier qu'après l'appel de devientLeTairo(alj) le tairo n'est pu à null
        assertNotNull(tairo.getTairo());
    }

    /**
     *
     * On teste le nombre de cartes restant dans la pioche
     * @assertEquals sur le nombre de cartes avant et après la pioche
     */
    @Test
    public void piocheCartes() {

        llk = init.initialisationPaquetKokus();
        llct = init.initialisationPaquetTroupe();
        //Vérfier que les listes sont bien initialisées
        assertEquals(34, llct.size());
        assertEquals(24, llk.size());
        int nbcartes = 4;

        tairo.piocheCartes(llct, llk, nbcartes);
        //Vérifier qu'après la pioche, il y a bien 4 cartes troupes de moins
        assertEquals(34 - nbcartes, llct.size());
        //Vérifier qu'il y a bien 4/2 cartes kokus de moins
        assertEquals(24 - (nbcartes / 2), llk.size());

    }

}
