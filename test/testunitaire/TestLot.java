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
 * @author Pauline
 */
public class TestLot {

    private Iterable<Joueur> hjoueur;
    private int i;
    LinkedList<Kokus> llk = new LinkedList<Kokus>();
    LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
    Initialisation init = new Initialisation();
    Lot lot = new Lot();
    Set<Joueur> joueur = new HashSet<>();
    Set<Titre> listt;
    Titre titre = new Titre();

    public TestLot() {
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

    //SPRINT 2
    //************ CLASSE LOT ***************
    /**
     * TEST EFFECTUE SUR LA REPONSE OUI OU NON EN BRUT ET NON PAS PAR SCANNER
     * Activer la fonction uniquement pour la reponse en brut On teste si la
     * saisie est bien à oui ou à non
     *
     * @assertEquals sur la valeur de la saisie
     */
    //@Test
    public void testOuiOuNon() {

        //Vérifier la valeur du résultat attendu 
        String s1 = "OUI";
        String s2 = "Non";
        String s3 = "Bonjour";

        //Vérifier que ouiOuNon() accepte "OUI" 
        assertTrue(lot.ouiOuNon().equalsIgnoreCase(s1));
        //Vérifier que ouiOuNon() accepte "Non" 
        assertTrue(lot.ouiOuNon().equalsIgnoreCase(s2));
        //Vérifier que ouiOuNon() n'accepte pas "Bonjour" 
        assertFalse(lot.ouiOuNon().equalsIgnoreCase(s3));

        //  boolean ok = false;
        //Condition égalité
        /*if (("OUI".equals(s1) || "Oui".equals(s1) || "OUi".equals(s1) || "oui".equals(s1))&&("NON".equals(s1) 
         || "Non".equals(s1) || "NOn".equals(s1) || "non".equals(s1))){
         ok = true;
         assertTrue(ok);
         }
         assertFalse(ok);
         */
    }

    /**
     *
     * On teste quel joueur va recevoir le lot
     *
     * @assertEquals
     */
    // @Test
    public void TestjoueurQuiRecoitLot() {
        //---------------------NULL POINTER EXCEPTION----------------------

        Joueur j1 = new Joueur("J1");
        Joueur j2 = new Joueur("J2");
        Joueur j3 = new Joueur("J3");
        Joueur j4 = new Joueur("J4");
        Tairo tairo = new Tairo(j1);
        joueur.add(j1);
        joueur.add(j2);
        joueur.add(j3);
        joueur.add(j4);
        

        lot.joueurQuiRecoitLot(joueur, tairo);

        for (Joueur j : joueur) {
            lot.setTitre(lot.getTitre());
        }
        titre = lot.getTitre();

        // assertTrue(lot.joueurQuiRecoitLot(joueur, tairo).equals(j2));
        assertEquals("Tairo", titre);

    }

    /**
     *
     * On teste l'existence d'une carte selon son type donnée
     *
     * @assertEquals sur l'existence de la carte en fonction du type
     */
    @Test
    public void TestverifieExistenceCarte() {
        String typeCarteK = "koku";
        String CarteK = "3";
        String CarteK1 = "6";
        String typeCarteT = "troupe";
        String CarteT = "Bushi";
        String CarteT1 = "Sohei & Sohei";
        String CarteT2 = "Pauline";

        llk = init.initialisationPaquetKokus();

        llct = init.initialisationPaquetTroupe();

        lot.setAlk(new ArrayList(llk));
        lot.setAlct(new ArrayList(llct));
        //Vérifier les cartes Kokus
        assertTrue(lot.verifieExistenceCarte(CarteK, typeCarteK));
        assertFalse(lot.verifieExistenceCarte(CarteK1, typeCarteK));
        //Vérifier les cartes troupes double et simple
        assertTrue(lot.verifieExistenceCarte(CarteT, typeCarteT));
        assertTrue(lot.verifieExistenceCarte(CarteT1, typeCarteT));
        assertFalse(lot.verifieExistenceCarte(CarteT2, typeCarteT));

    }

    /**
     *
     * On teste la conversion d'un string en carte kokus
     *
     * @assertEquals sur le retour de la fonction
     */
    @Test
    public void TestconvertirStringEnCarteKokus() {

        llk = init.initialisationPaquetKokus();
        String s1 = "Pauline";
        String s2 = "1";
        lot.setAlk(new ArrayList(llk));

        //Vérifier que la liste est pas vide
        assertNotNull(llk);
        //Vérifier la mauvaise saisie
        assertNull(lot.convertirStringEnCarteKokus(s1));
        //Vérifier la bonne saisie
        assertNotNull(lot.convertirStringEnCarteKokus(s2));

    }

    /**
     *
     * On teste la conversion d'un string en carte troupe
     *
     * @assertEquals sur le retour de la fonction
     */
    @Test
    public void TestconvertirStringEnCarteTroupe() {

        llct = init.initialisationPaquetTroupe();

        String s1 = "Pauline";
        String s2 = "Shinobi";

        lot.setAlct(new ArrayList(llct));

        //Vérifier que la liste est pas null
        assertNotNull(llct);
        //Vérifier la mauvaise saisie
        assertNull(lot.convertirStringEnCarteTroupe(s1));
        //Vérifier la bonne saisie
        assertNotNull(lot.convertirStringEnCarteTroupe(s2));
    }

    /**
     *
     * On teste le choix d'une truile de hierarchie
     *
     * @assertEquals sur l'existence de la carte voulue
     */
    @Test
    public void TestchoixTuileHierarchie() {

        listt = init.getHashTitre();
        ArrayList<Titre> altitre = new ArrayList<Titre>(listt);

        String s1 = "Hatamoto";
        String s2 = "Daimyo";
        String s3 = "Shomyo";
        String s4 = "Sensei";

        //Vérifier que l'arraylist est complétée
        assertEquals(4, altitre.size());

        //Vérifier que les 4 titres sont possibles et sont dans la liste
        assertEquals(s1, altitre.get(2).getNom());
        assertEquals(s2, altitre.get(1).getNom());
        assertEquals(s3, altitre.get(3).getNom());
        assertEquals(s4, altitre.get(0).getNom());

    }

    /**
     * TEST EFFECTUE SUR L'AJOUT DE CARTES TROUPES EN BRUT ET PAS PAR DES
     * SCANNER Activer la fonction uniquement pour l'ajout en brut On teste le
     * retour de la fonction
     *
     * @assertEquals sur le retour des cartes troupes
     */
    //@Test
    public void TestchoixDesCartesTroupes() {
        //Vérifier cette fonction sans les scanner, données entrées en brut.

        llct = init.initialisationPaquetTroupe();
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);

        lot.setAlct(alct);
        //Vérifier que l'arraylist n'est pas vide
        assertNotNull(alct);
        //Vérifier que le lot n'est pas nul
        assertNotNull(lot);
        //Vérifier que le retour de la fonction contient des éléments de alct
        assertTrue(lot.choixDesCartesTroupes().containsAll(alct));

    }

    /**
     * TEST EFFECTUE SUR L'AJOUT DE CARTES KOKUS EN BRUT ET PAS PAR DES SCANNER
     * Activer la fonction uniquement pour l'ajout en brut On teste le retour de
     * la fonction
     *
     * @assertEquals sur le retour des cartes kokus
     */
    //@Test   
    public void TestchoixDesCartesKokus() {
        //Vérifier cette fonction sans les scanner, données entrées en brut.
        llk = init.initialisationPaquetKokus();
        ArrayList<Kokus> alk = new ArrayList<Kokus>(llk);

        lot.setAlk(alk);
        //Vérifier que l'arraylist n'est pas vide
        assertNotNull(alk);
        //Vérifier que le lot n'est pas nul
        assertNotNull(lot);
        //Vérifier que le retour de la fonction contient des éléments de alct
        assertTrue(lot.choixDesCartesKokus().containsAll(alk));

    }

    /**
     *
     * On teste la composition du lot
     *
     * @assertEquals sur le fait que le lot composé ne soit pas nul
     */
    @Test
    public void TestcompositionDuLot() {

        listt = init.getHashTitre();
        ArrayList<Titre> allistt = new ArrayList<Titre>(listt);
        System.out.println(lot.toString());
        //Vérifier que la liste n'est pas vide
        assertNotNull(allistt);
        //Vérifier qu'elle a bien 4 titres
        assertEquals(4, allistt.size());

        //Ajout dans le lot
        lot.setAlct(new ArrayList(allistt));
        //Vérifier qu'il est pas null
        assertNotNull(lot);

    }

    /**
     *
     * On teste le nombre de cartes troupes à piocher par joueurs
     *
     * @assertEquals sur le nombre de tuiles bonus sur la province
     */
    //@Test
    public void TestsoumettreLeLot() {

        listt = init.getHashTitre();
        ArrayList<Titre> allistt = new ArrayList<Titre>(listt);

        lot.setAlct(new ArrayList(allistt));

        String reponse = "oui";
        lot.soumettreLeLot(allistt, lot);

    }

}
