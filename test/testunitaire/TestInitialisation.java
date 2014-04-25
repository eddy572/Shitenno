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
public class TestInitialisation {

    LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
    LinkedList<Kokus> llk = new LinkedList<Kokus>();
    LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();
    Set<Province> listp;
    Set<Titre> listt;
    Set<Joueur> joueur = new HashSet<>();
    Initialisation init = new Initialisation();
    Province prov = new Province();
    Joueur jouer = new Joueur();

    public TestInitialisation() {
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
     * On teste l'initialisation du paquet Troupe
     * @assertEquals sur la taille du paquet
     */
    @Test
    public void testInitialisationPaquetTroupe() {

        llct = init.initialisationPaquetTroupe();

        //Vérifier que la liste n'est pas null
        assertNotNull(llct);
        //Vérifier qu'il y a bien 34 cartes
        assertEquals(34, llct.size());
    }

    /**
     *
     * On teste l'initialisation du paquet Kokus
     * @assertEquals sur la taille du paquet
     */
    @Test
    public void testInitialisationPaquetKokus() {

        llk = init.initialisationPaquetKokus();

        //Vérifier que la liste n'est pas null
        assertNotNull(llk);
        //Vérifier qu'il y a bien 24 cartes
        assertEquals(24, llk.size());
        //Vérifier que c'est bien mélangé
        assertNotSame("[3,3,3,3,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1]", llk.toString());

    }

    /**
     *
     * On teste l'initialisation du paquet Tuile Bonus
     * @assertEquals sur la taille du paquet
     */
    @Test
    public void testInitialisationTuileBonus() {

        lltb = init.initialisationTuileBonus();

        //Vérifier que la liste n'est pas null
        assertNotNull(lltb);
        //Vérifier qu'il y a bien 24 tuiles        
        assertEquals(24, lltb.size());
    }

    /**
     *
     * On teste l'initialisation des différentes provinces
     * @assertEquals sur l'initialisation
     */
    @Test
    public void testinitialisationFinaleProvince() {

        listp = init.getHashProvince();
        //Nb final de province
        int resattendu1 = 8;
        assertEquals(resattendu1, listp.size());

    }

    /**
     *
     * On teste la distributions de cartes troupes
     * @assertEquals nombre de cartes troupes
     * @assertEquals nombre de cartes troupes par main
     */
    @Test
    public void testdistributionCartesDepart() {

        llct = init.getLlctroupe();

        //Vérifier que la liste n'est pas null
        assertNotNull(llct);
        //Vérifier qu'il y a bien 34 cartes
        assertEquals(34, llct.size());

    }

    /**
     *
     * On teste la distribution du titre de départ
     * @assertEquals sur le nombre de titre à distribuer
     */
    @Test
    public void testdistributionTitreDepart() {

        listt = init.getHashTitre();

        //Vérifier que la liste n'est pas null
        assertNotNull(listt);
        //Vérifier qu'il y a bien 4 titres
        assertEquals(4, listt.size());

    }

    /**
     *
     * On teste l'ajout de trois tuiles bonus sur chaque province
     * @assertEquals sur le nombre de tuiles bonus sur la province
     */
    @Test
    public void testAjoutTroisTuileBonus() {

        listp = init.getHashProvince();
        lltb = init.initialisationTuileBonus();

        //Nb de tuile bonus par province
        init.ajoutTroisTuileBonus(listp, lltb);
        for (Province p : listp) {
            prov.setLltuilebonus(p.getLltuilebonus());
        }
        lltb = prov.getLltuilebonus();
        assertEquals(3, lltb.size());
    }

    /**
     *
     * On teste le nombre de cartes troupes à piocher par joueurs
     * @assertEquals sur le nombre de tuiles bonus sur la province
     */
    @Test
    public void testNombreDeCartesTroupesAPiocher() {

        Joueur j1 = new Joueur("J1");
        Joueur j2 = new Joueur("J2");
        Joueur j3 = new Joueur("J3");
        Joueur j4 = new Joueur("J4");

        //Vérifier pour 2 joueurs
        joueur.add(j2);
        joueur.add(j1);
        assertEquals(4, init.nombreDeCartesTroupesAPiocher(joueur));

        //Vérifier pour 3 joueurs
        joueur.add(j3);
        assertEquals(6, init.nombreDeCartesTroupesAPiocher(joueur));

        //Vérifier pour 4 joueurs
        joueur.add(j4);
        assertEquals(8, init.nombreDeCartesTroupesAPiocher(joueur));

    }

}
