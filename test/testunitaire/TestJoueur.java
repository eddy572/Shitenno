/* To change this license header, choose License Headers in Project Properties.
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
public class TestJoueur {

    //Set
    Set<Province> setp;
    //Instance
    Joueur joueur = new Joueur();
    General general = new General();
    Lot lot = new Lot();
    Initialisation init = new Initialisation();
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
    Troupes shinobi = new Troupes("Shinobi", "Noir");
    CarteTroupe ct4 = new CarteTroupe(shinobi);
    //ArrayList
    ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
    ArrayList<Kokus> alk = new ArrayList<Kokus>(llk);

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
        setp = init.getHashProvince();
    }

    @After
    public void tearDown() {
    }

    /**
     * ******************
     */
    /* TESTS DES METHODES */
    /**
     * ******************
     */
    /**
     *
     * On teste si on a les troupes nécessaires
     *
     * @assertTrue si on les a
     */
    @Test
    public void testALesTroupesNecessairesSeules() {

        Province p = null;
        for (Province pr : setp) {
            p = pr;
            break;
        }

        // Aucune troupe dans la main du joueur
        assertFalse(joueur.aLesTroupesNecessairesSeules(p));

        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct2);
        alct.add(ct3);
        alct.add(ct3);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        // Le joueur a les troupes qu'il faut
        assertTrue(joueur.aLesTroupesNecessairesSeules(p1));

    }

    /**
     *
     * On teste le nombre de cartes en main
     *
     * @assertEquals sur le nb de carte en main
     */
    @Test
    public void testnombreDeCartesEnMain() {
        Joueur j1 = new Joueur("Pauline");

        //Ajout à la liste des kokus
        alk.add(k1);
        alk.add(k2);
        alk.add(k1);
        alk.add(k3);
        //Ajout à la liste des cartes troupes

        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct2);
        //Ajout des listes au joueur
        j1.setAlctroupe(alct);
        j1.setAlkokus(alk);

        //Vérifier que la liste des troupes du joueur n'est pas vide
        assertNotNull(j1.getAlctroupe());
        //Vérifier que la liste des kokus du joueur n'est pas vide
        assertNotNull(j1.getAlkokus());
        //nb de cartes
        int nbcartes = j1.nombreDeCartesEnMain();
        //Vérifie que le joueurs à des cartes
        assertEquals(7, nbcartes);
    }

    /**
     * TEST EFFECTUE SUR LA REPONSE ACCEPTER OU REFUSER EN BRUT ET NON PAS PAR
     * SCANNER Activer la fonction uniquement pour la reponse en brut On teste
     * si la saisie est bien à accepter ou à refuser
     *
     * @assertEquals sur la valeur de la saisie
     */
    //@Test
    public void TestaccepterRefuserLot() {
        //Vérifier la valeur du résultat attendu 

        String s1 = "accepter";
        String s2 = "refuser";
        String s3 = "Bonjour";

        //Vérifier que ouiOuNon() accepte "OUI" 
        assertTrue(joueur.accepterOuRefuser().equalsIgnoreCase(s1));
        //Vérifier que ouiOuNon() accepte "Non" 
        assertTrue(joueur.accepterOuRefuser().equalsIgnoreCase(s2));
        //Vérifier que ouiOuNon() n'accepte pas "Bonjour" 
        assertFalse(joueur.accepterOuRefuser().equalsIgnoreCase(s3));
    }

    /**
     *
     * On teste le nombre de kamons par joueurs
     *
     * @assertEquals sur le nombre de kamons en fonction du nb de joueurs
     */
    @Test
    public void TestnombreKamonInitial() {

        //Vérifer que si on est 2 joueurs chacun aura 12 kamons initialement
        assertEquals(12, joueur.nombreKamonInitial(2));
        //Vérifer que si on est 3 joueurs chacun aura 10 kamons initialement
        assertEquals(10, joueur.nombreKamonInitial(3));
        //Vérifer que si on est 4 joueurs chacun aura 8 kamons initialement
        assertEquals(8, joueur.nombreKamonInitial(4));
    }

    /**
     *
     * On teste le retour des cartes acceptées
     *
     * @assertEquals les listes retournées
     */
    @Test
    public void TestcartesAcceptees() {

        Province p1 = new Province("Hokkaido", 3, sohei);

        //Vérifier que la liste est à null 
        assertEquals(alct, joueur.getAlctroupe());
        assertEquals(alk, joueur.getAlkokus());
        //Ajouter les cartes dans le lot
        alct.add(ct2);
        alct.add(ct1);
        alk.add(k1);
        alk.add(k2);
        alk.add(k1);
        alk.add(k3);
        lot.setAlct(alct);
        lot.setAlk(alk);
        //Ajouter les cartes du lot dans la main de joueur
        joueur.cartesAcceptees(lot);
        //Vérifier que c'est pas nul et que c'est égal à la liste du lot
        assertNotNull(joueur.getAlctroupe());
        assertNotNull(joueur.getAlkokus());
        assertEquals(alct, joueur.getAlctroupe());
        assertEquals(alk, joueur.getAlkokus());

    }

    /**
     * TEST EFFECTUE SUR LA REPONSE ENVAHIR OU PASSER EN BRUT ET NON PAS PAR
     * SCANNER Activer la fonction uniquement pour la reponse en brut On teste
     * si la saisie est bien à envahir ou à passer
     *
     * @assertEquals sur la valeur de la saisie
     */
    //@Test
    public void TestenvahirOuPasser() {
        String s1 = "envahir";
        String s2 = "passer";
        String s3 = "Bonjour";

        //Vérifier que ouiOuNon() accepte "OUI" 
        assertTrue(joueur.envahirOuPasser().equalsIgnoreCase(s1));
        //Vérifier que ouiOuNon() accepte "Non" 
        assertTrue(joueur.envahirOuPasser().equalsIgnoreCase(s2));
        //Vérifier que ouiOuNon() n'accepte pas "Bonjour" 
        assertFalse(joueur.envahirOuPasser().equalsIgnoreCase(s3));
    }

    /**
     *
     * On teste le nombre de kokus en main
     *
     * @assertEquals sur le nombre de kokus
     */
    @Test
    public void testcompteNbKokusEnMain() {

        alk.add(k1);
        alk.add(k2);
        alk.add(k1);
        alk.add(k3);

        joueur.setAlkokus(alk);
        //Vérifier que le nombres de kokus en main est bien 7
        assertEquals(7, joueur.compteNbKokusEnMain());
    }

    /**
     *
     * On teste le nombre de cartes kokus
     *
     * @assertEquals sur le nombre de carte kokus
     */
    @Test
    public void testcompteNbCartesKokus() {

        alk.add(k1);
        alk.add(k2);
        alk.add(k1);
        alk.add(k3);

        joueur.setAlkokus(alk);
        //Vérifier que le nb de carte koku 1 est égal à 2
        assertEquals(2, joueur.compteNbCarteKokus(k1));
        //Vérifier que le nb de carte koku 2 est égal à 1
        assertEquals(1, joueur.compteNbCarteKokus(k2));
    }

    /**
     *
     * On teste le nombre de troupes en main
     *
     * @assertEquals sur le nb en main
     */
    @Test
    public void testcompteTroupesEnMain() {

        //Ajouter les cartes dans le lot
        alct.add(ct2);
        alct.add(ct1);
        //Au début le joueur à 0 cartes troupes en main
        assertEquals(0, joueur.compteTroupesEnMain());
        joueur.setAlctroupe(alct);
        //Après l'ajout à la liste, il a 3 troupes
        assertEquals(3, joueur.compteTroupesEnMain());
        alct.add(ct1);
        joueur.setAlctroupe(alct);
        //Après le deuxième ajout à la liste, il a 5 troupes
        assertEquals(5, joueur.compteTroupesEnMain());
    }

    /**
     *
     * On teste le nombre de troupes necessaire qu'on a en main
     *
     * @assertEquals sur le nombre de troupes
     */
    @Test
    public void testcompteTroupesNecessaire() {

        //Ajouter les cartes dans le lot
        alct.add(ct2);
        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct2);
        alct.add(ct3);
        joueur.setAlctroupe(alct);

        Province p1 = new Province();
        LinkedList<TuileBonus> altb = new LinkedList<>();
        Controle[] cont;

        for (Province p : init.getHashProvince()) {
            p1 = p;
            altb.add(new TuileBonus(sohei, new Bonus("+1")));
            p1.setLltuilebonus(altb);
            break;
        }

        //On compte le nombre de cartes que l'on peut jouer
        assertEquals(4, joueur.compteTroupesNecessaire(p1));

    }

    /**
     * TEST EFFECTUE SUR LA REPONSE ACCEPTER OU REFUSER EN BRUT ET NON PAS PAR
     * SCANNER Activer la fonction uniquement pour la reponse en brut On teste
     * si la saisie est bien à oui ou à non
     *
     * @assertEquals sur la valeur de la saisie
     */
    // @Test
    public void TestdemandeProvinceAControler() {

        String s = "Hokkaido";
        String s1 = "Bonjour";

        //Vérifier que la province existe et peut être controlée
        assertEquals(s, joueur.demandeProvinceAControler(setp).getNom());
        //Vérifier que la province n'existe pas
        assertNotSame(s1, joueur.demandeProvinceAControler(setp).getNom());

    }

    /**
     *
     * On teste le nombre de troupes qui pourraient servir avec les troupes
     * bonus
     *
     * @assertEquals sur le nombres de troupes
     */
    @Test
    public void TesttroupeProvinceAndTroupeBonus() {

        Province p1 = new Province("Hokkaido", 3, sohei);

        alct.add(ct2);
        //Ajout des listes au joueur
        joueur.setAlctroupe(alct);
        //Vérifier que la main n'est pas vide
        assertNotNull(alct);
        //Vérifier que le joueur n'a aucune carte qui pourrait servir à prendre la province
        assertEquals(0, joueur.troupeProvinceAndTroupeBonus(alct, p1.getTroupe()));
        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct1);
        joueur.setAlctroupe(alct);
        //Vérifier que le joueur a 6 troupes qui pourraient servir à prendre la province 
        assertEquals(6, joueur.troupeProvinceAndTroupeBonus(alct, p1.getTroupe()));
        alct.add(ct1);
        joueur.setAlctroupe(alct);
        //Vérifier que le joueur a 8 troupes qui pourraient servir à prendre la province 
        assertEquals(8, joueur.troupeProvinceAndTroupeBonus(alct, p1.getTroupe()));

    }

    /**
     *
     * On teste l'existence d'une carte selon son type donnée
     *
     * @assertEquals sur l'existence de la carte en fonction du type
     */
    @Test
    public void TestverifExistenceCarte() {

        String CarteT = "Bushi";
        String CarteT1 = "Sohei & Sohei";
        Troupes sohei = new Troupes("Sohei", "Orange");
        CarteTroupe ct1 = new CarteTroupe(sohei, sohei);
        Troupes bushi = new Troupes("Bushi", "Bleu");
        CarteTroupe ct2 = new CarteTroupe(bushi);
        //Ajout à la liste des cartes troupes

        alct.add(ct2);
        alct.add(ct1);
        joueur.setAlctroupe(alct);

        //Vérifier les cartes troupes double et simple
        assertTrue(joueur.verifExistenceCarte(CarteT));
        assertTrue(joueur.verifExistenceCarte(CarteT1));

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

        joueur.setAlctroupe(new ArrayList(llct));

        //Vérifier que la liste est pas null
        assertNotNull(llct);
        //Vérifier la mauvaise saisie
        assertNull(joueur.convertirStringEnCarteTroupe(s1));
        //Vérifier la bonne saisie
        assertNotNull(joueur.convertirStringEnCarteTroupe(s2));
        //Vérifier que le string renvoie la même chose que ct4
        assertEquals(ct4, joueur.convertirStringEnCarteTroupe(s2));
    }

    /**
     * TEST EFFECTUE SUR LA REPONSE D'UNE CARTE TROUPES PAR SCANNER Activer la
     * fonction uniquement pour la reponse en brut On teste si la saisie est
     * bien égal à une carte troupes que l'on possède
     *
     * @assertEquals sur la valeur de la saisie
     */
    //@Test
    public void TestdemandeCarteTroupeADefausser() {
        String s = "Bushi";
        String s1 = "Sohei";

        alct.add(ct2);
        alct.add(ct1);
        joueur.setAlctroupe(alct);

        assertSame(ct2, joueur.demandeCarteTroupeADefausser());
        assertNotSame(ct1, joueur.demandeCarteTroupeADefausser());

    }

    /**
     *
     * On teste le rapport entre une carte troupe et les troupes de la province
     *
     * @assertEquals sur le retour de la fonction
     */
    @Test
    public void TestrapportCarteTroupeProvince() {

        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct1);
        alct.add(ct2);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        // Le joueur a une troupe en adéquat avec celles de la province
        assertTrue(joueur.rapportCarteTroupeProvince(ct3, p1));
        // Le joueur n'a pas une troupe en adéquat avec celles de la province
        assertFalse(joueur.rapportCarteTroupeProvince(ct1, p1));

    }

    /**
     *
     * On teste le rapport entre une carte Troupe et une tuile bonus pour une
     * province
     *
     * @assertEquals sur le retour de la fonction
     */
    @Test
    public void rapportCarteTroupeBonus() {

        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct1);
        alct.add(ct2);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        // Le joueur a une troupe en adéquat avec la troupe bonus
        assertTrue(joueur.rapportCarteTroupeBonus(ct3, bushi));

    }

    /**
     * TEST EFFECTUE SUR LA REPONSE D'UNE CARTE TROUPES PAR SCANNER Activer la
     * fonction uniquement pour la reponse en brut On teste si la saisie est
     * bien égal à une carte troupes que l'on possède
     *
     * @assertEquals sur la valeur de la saisie
     */
    //@Test
    public void TestnombreCarteTroupeADefausser() {
        int nbmax = 2;

        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct2);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        //nbmax = 2 donc on retire 2 carte ct1
        assertEquals(2, joueur.nombreCarteTroupeADefausser(ct1, nbmax));
    }

    /**
     * TEST EFFECTUE SUR LA REPONSE D'UN NOMBRE DE CARTES PAR SCANNER Activer la
     * fonction uniquement pour la reponse en brut
     *
     * @assertEquals sur la valeur de la saisie
     */
    //@Test
    public void TestnbCarteKokusADefausser() {
        int nbmax = 2;

        Province p1 = new Province();
        alk.add(k1);
        alk.add(k1);
        alk.add(k2);
        alk.add(k3);
        joueur.setAlkokus(alk);
        for (Province p : init.getHashProvince()) {
            p1 = p;
            break;
        }

        // Le joueur a des troupes
        assertNotNull(alct.size());
        //nbmax = 2 donc on retire 2 carte ct1
        assertEquals(2, joueur.nbCarteKokusADefausser(k1));

    }

    /**
     *
     * On teste la tuile bonus et le bonus
     *
     * @assertEquals sur la tuile bonus
     */
    @Test
    public void TesttroupeEgaleBonus() {

        Troupes tprovince = new Troupes("Sohei", "Orange");
        Troupes tbonus = new Troupes("Sohei", "Orange");
        Troupes tbonus1 = new Troupes("Samourai", "Vert");

        assertTrue(joueur.troupeEgaleBonus(tprovince, tbonus));
        assertFalse(joueur.troupeEgaleBonus(tprovince, tbonus1));

    }

    /**
     *
     * On teste la tuile bonus sur la province
     *
     * @assertEquals sur la tuile bonus
     */
    @Test
    public void TestrecupererTuileBonus() {
        Bonus bonus = null;
        Set<Province> listp;
        Province prov = new Province();
        listp = init.getHashProvince();
        lltb = init.initialisationTuileBonus();

        //Nb de tuile bonus par province
        init.ajoutTroisTuileBonus(listp, lltb);
        for (Province p : listp) {
            prov.setLltuilebonus(p.getLltuilebonus());
        }
        bonus = prov.getLltuilebonus().getLast().getBonus();
        assertSame(bonus, joueur.recupererTuileBonus(prov));

    }

    /**
     *
     * On teste la possibilité de prendre le controle avec kokus et bonus
     *
     * @assertTrue sur la possibilité
     */
    @Test
    public void testverifPossibiliteControleProvinceAvecKokusEtBonus() {
        Province p1 = new Province();

        for (Province p : init.getHashProvince()) {
            p1 = p;
            break;
        }

        alk.add(k1);
        joueur.setAlkokus(alk);
        //Vérifier que le joueur n'a pas assez de kokus ni de bonus
        assertFalse(joueur.verifPossibiliteControleProvinceAvecKokusEtBonus(p1));
        alk.add(k2);
        alk.add(k1);
        alk.add(k3);
        joueur.setAlkokus(alk);
        //Vérifier que maintenant c'est possible
        assertTrue(joueur.verifPossibiliteControleProvinceAvecKokusEtBonus(p1));
    }

    /**
     *
     * On teste la possibilité de prendre le controle avec kokus et bonus
     *
     * @assertTrue sur la possibilité
     */
    @Test
    public void testcontroleProvincePossibleAvecKokus() {

        alk.add(k1);
        joueur.setAlkokus(alk);
        //Vérifier que le joueur n'a pas assez de kokus ni de bonus
        assertEquals(0, joueur.controleProvincePossibleAvecKokus(setp));
        alk.add(k2);
        alk.add(k1);
        joueur.setAlkokus(alk);
        //Vérifier qu'au départ 4 des provinces sont accessibles avec 3 kokus
        assertEquals(4, joueur.controleProvincePossibleAvecKokus(setp));
    }

    /**
     *
     * On teste l'existence de la carte kokus
     *
     * @assertTrue sur l'existence
     */
    @Test
    public void testverifExistenceCarteKokus() {
        alk.add(k2);
        alk.add(k1);
        alk.add(k1);
        joueur.setAlkokus(alk);
        //Vérifier que les deux cartes kokus existent dans la main du joueur
        assertEquals(k1, joueur.verifExistenceCarteKokus(1));
        assertEquals(k2, joueur.verifExistenceCarteKokus(2));

    }

    /**
     *
     * On teste la pose du kamons de score
     *
     * @assertEquals sur le score décrémenté
     */
    @Test
    public void TestposerKamonDeScore() {

        Controle[] cont;
        Province p1 = new Province();

        for (Province p : init.getHashProvince()) {
            p1 = p;
            Controle[] c = new Controle[4];
            c[0] = new Controle(joueur);
            c[1] = new Controle(joueur, true);
            p1.setControle(c);
            break;
        }

        cont = p1.getControle();

        joueur.poserKamonDeScore(p1);
        //Le joueur à 10 kamons au départ, voir si on a bien décrémenter
        assertEquals(9, joueur.getNbkamons());

    }

    /**
     *
     * On teste le nombre de points marqués sur la province
     *
     * @assertEquals sur le nb de points
     */
    @Test
    public void TestpointsMarques() {
        Controle[] cont;
        Province p1 = new Province();

        for (Province p : init.getHashProvince()) {
            p1 = p;
            Controle[] c = new Controle[4];
            c[0] = new Controle(joueur);
            c[1] = new Controle(joueur, true);
            p1.setControle(c);
            break;
        }

        cont = p1.getControle();

        assertEquals(3, joueur.pointsMarques(p1));

    }

    /**
     *
     * On teste l'incrémentation du score
     *
     * @assertEquals sur le score obtenu
     */
    @Test
    public void TestincrementerScore() {

        Controle[] cont;
        Province p1 = new Province();

        assertEquals(0, joueur.getScore());

        for (Province p : init.getHashProvince()) {
            p1 = p;
            Controle[] c = new Controle[4];
            c[0] = new Controle(joueur);
            c[1] = new Controle(joueur, true);
            p1.setControle(c);
            break;
        }

        System.out.println(joueur.toString());
        System.out.println(p1.toString());
        cont = p1.getControle();
        // joueur.pointsMarques(p1);
        joueur.incrementerScore(p1);

        // System.out.println(joueur.toString());
        System.out.println(joueur.toString());
        assertEquals(3, joueur.getScore());
    }

}
