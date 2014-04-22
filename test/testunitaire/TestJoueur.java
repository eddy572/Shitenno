
/* To change this license header, choose License Headers in Project Properties.
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
 * @author Pauline
 */
public class TestJoueur {

    Set<Province> setp;
    Joueur joueur = new Joueur();
    General general = new General();
    Lot lot = new Lot();
    Initialisation init = new Initialisation();
    LinkedList<Kokus> llk = new LinkedList<Kokus>();
    LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
    LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();

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
    /* Méthodes de tests */
    /**
     * ******************
     */
    @Test
    public void testALesTroupesNecessaires() {
        Province p = null;

        for (Province pr : setp) {
            p = pr;
            break;
        }

        // Aucune troupe dans la main du joueur
        assertFalse(joueur.aLesTroupesNecessaires(p));

        Troupes bushi = new Troupes("Bushi", null);
        CarteTroupe ct1 = new CarteTroupe(bushi);
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct1);
        alct.add(ct1);
        alct.add(ct1);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        // Le joueur a les troupes qu'il faut
        assertTrue(joueur.aLesTroupesNecessaires(p1));

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
        Kokus k1 = new Kokus(1);
        Kokus k2 = new Kokus(2);
        Kokus k3 = new Kokus(3);
        Troupes shinobi = new Troupes("Shinobi", null);
        Troupes soheishi = new Troupes("Sohei", "Shinobi");
        CarteTroupe ct1 = new CarteTroupe(shinobi);
        CarteTroupe ct2 = new CarteTroupe(soheishi);
        //Ajout à la liste des kokus
        ArrayList<Kokus> alk = new ArrayList<Kokus>(llk);
        alk.add(k1);
        alk.add(k2);
        alk.add(k1);
        alk.add(k3);
        //Ajout à la liste des cartes troupes
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
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

    @Test
    public void TesttroupeProvinceAndTroupeBonus() {

        Troupes sohei = new Troupes("Sohei", null);
        CarteTroupe ct1 = new CarteTroupe(sohei);
        Troupes bushi = new Troupes("Bushi", null);
        CarteTroupe ct2 = new CarteTroupe(bushi);
        Province p1 = new Province("Hokkaido", 3, sohei);
        //Ajout à la liste des cartes troupes
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
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
        //Vérifier que le joueur a 3 cartes qui pourraient servir à prendre la province 
        assertEquals(3, joueur.troupeProvinceAndTroupeBonus(alct, p1.getTroupe()));
        alct.add(ct1);
        joueur.setAlctroupe(alct);
        //Vérifier que le joueur a 4 cartes qui pourraient servir à prendre la province 
        assertEquals(4, joueur.troupeProvinceAndTroupeBonus(alct, p1.getTroupe()));

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
        Troupes sohei = new Troupes("Sohei", "Sohei");
        CarteTroupe ct1 = new CarteTroupe(sohei);
        Troupes bushi = new Troupes("Bushi", null);
        CarteTroupe ct2 = new CarteTroupe(bushi);
        //Ajout à la liste des cartes troupes
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
        alct.add(ct2);
        alct.add(ct1);
        joueur.setAlctroupe(alct);

        //Vérifier les cartes troupes double et simple
        assertTrue(joueur.verifExistenceCarte(CarteT));
        assertFalse(joueur.verifExistenceCarte(CarteT1));

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

        Troupes sohei = new Troupes("Sohei", "Sohei");
        CarteTroupe ct1 = new CarteTroupe(sohei);
        Troupes bushi = new Troupes("Bushi", null);
        CarteTroupe ct2 = new CarteTroupe(bushi);
        //Ajout à la liste des cartes troupes
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
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

        Troupes sohei = new Troupes("Sohei", "Sohei");
        CarteTroupe ct1 = new CarteTroupe(sohei);
        Troupes bushi = new Troupes("Bushi", null);
        CarteTroupe ct2 = new CarteTroupe(bushi);

        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct1);
        alct.add(ct2);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        // Le joueur a une troupe en adéquat avec celles de la province
        assertTrue(joueur.rapportCarteTroupeProvince(ct2, p1));
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
        Troupes sohei = new Troupes("Sohei", "orange");
        CarteTroupe ct1 = new CarteTroupe(sohei, sohei);
        Troupes bushi = new Troupes("Bushi", "bleue");
        CarteTroupe ct2 = new CarteTroupe(bushi);

        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct1);
        alct.add(ct2);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        // Le joueur a une troupe en adéquat avec la troupe bonus
        assertTrue(joueur.rapportCarteTroupeBonus(ct2, bushi));
        // Le joueur n'a pas une troupe en adéquat avec la troupe bonus
//        assertFalse(joueur.rapportCarteTroupeBonus(ct1, sohei));

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
        Troupes sohei = new Troupes("Sohei", "orange");
        CarteTroupe ct1 = new CarteTroupe(sohei, sohei);
        Troupes bushi = new Troupes("Bushi", "bleue");
        CarteTroupe ct2 = new CarteTroupe(bushi);

        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
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

    public void TestsatisfaitTroupeEtBonus() {

        /*    Troupes tProvince = p.getTroupe();
         Troupes tBonus = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast().getTroupe();
         Troupes troupe1 = ct.getTroupe1();
         Troupes troupe2 = ct.getTroupe2();
        
         if(troupe2 != null && tBonus != null){
         if((troupe1.equals(tProvince) && troupe2.equals(tBonus)) || (troupe1.equals(tBonus) && troupe2.equals(tProvince))){
         return true;
         }
         }
         return false;*/
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
     * On teste la tuile bonus sur la province
     *
     * @assertEquals sur la tuile bonus
     */
    // @Test
    public void TestdefausserLesTroupes() {

        Troupes sohei = new Troupes("Sohei", "orange");
        CarteTroupe ct1 = new CarteTroupe(sohei);
        Troupes bushi = new Troupes("Bushi", "bleue");
        CarteTroupe ct2 = new CarteTroupe(bushi, bushi);

        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
        Province p1 = new Province("Kyushu", 3, bushi);
        alct.add(ct2);
        alct.add(ct2);
        alct.add(ct2);
        alct.add(ct2);
        alct.add(ct1);
        alct.add(ct1);
        joueur.setAlctroupe(alct);

        // Le joueur a des troupes
        assertNotNull(alct.size());
        System.out.println(alct.toString());
        assertSame(alct, joueur.defausserLesTroupes(p1));

    }

    /**
     *
     * On teste la tuile bonus sur la province
     *
     * @assertEquals sur la tuile bonus
     */
    // @Test
    public void TestposerKamonDeScore() {
        Controle[] cont = null;
        Troupes sohei = new Troupes("Sohei", null);
        CarteTroupe ct1 = new CarteTroupe(sohei);
        Troupes bushi = new Troupes("Bushi", null);
        CarteTroupe ct2 = new CarteTroupe(bushi);

        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>(llct);
        int points[] = {3, 4, 6, 9};
        alct.add(ct2);
        alct.add(ct2);
        alct.add(ct2);
        alct.add(ct2);
        alct.add(ct1);
        alct.add(ct1);
        joueur.setAlctroupe(alct);
        Province p1 = new Province("Kyushu", points, 3, bushi, lltb, cont);
        Controle controle = new Controle();
        System.out.println(controle.toString());
        assertNull(controle.getJoueur());
        System.out.println(joueur.toString());
        joueur.aLesTroupesNecessaires(p1);

        controle = new Controle(joueur, false);
        joueur.poserKamonDeScore(p1);

        assertNotNull(controle.getJoueur());
        assertNotSame(0, p1.getPointsFaveur());

    }

    /**
     *
     * On teste la tuile bonus sur la province
     *
     * @assertEquals sur la tuile bonus
     */
    @Test
    public void TestpointsMarques() {
        
         Province p1 = new Province();
        assertEquals(0, joueur.getScore());

        for (Province p : init.getHashProvince()){
            p1 = p;
            joueur.pointsMarques(p1);
            break;
        }
        System.out.println(joueur.toString());
        System.out.println(p1.toString());
        System.out.println(p1.getControle());
 
        System.out.println(joueur.pointsMarques(p1));
        System.out.println(joueur.toString());
  
    }

    /**
     *
     * On teste la tuile bonus sur la province
     *
     * @assertEquals sur la tuile bonus
     */
     // @Test
    public void TestincrementerScore() {
       
        Province p1 = new Province();
        assertEquals(0, joueur.getScore());

        for (Province p : init.getHashProvince()) {
            p1 = p;
            break;
        }
        System.out.println(joueur.toString());
        System.out.println(p1.toString());
        joueur.pointsMarques(p1);
        joueur.incrementerScore(p1);
        System.out.println(joueur.toString());
       // assertEquals(0, joueur.getScore());
    }

    /**
     *
     * On teste la tuile bonus sur la province
     *
     * @assertEquals sur la tuile bonus
     */
    @Test
    public void Testjouer() {
        /*     Bonus bonus = null;
         String rep = new String();
         int i = 0, points = 0;
        
         // Il peut jouer tant qu'il n'a pas encore posé trois kamons et qu'il ne choisit pas de passer
         while(i < 3 && !rep.equals("passer")){
         // Affiche les province qu'on peut contrôler avec la main du joueur
         controleProvincePossible(hProvince);
         System.out.print(this.pseudo + ", désirez-vous passer votre tour ou envahir une province ? ");
         // Soit on décide contrôler une province, soit on passe son tour
         rep = envahirOuPasser();
         // On applique les fonctions nécessaires si on désire contrôler une province
         if(rep.equals("envahir")){
         System.out.print("Quelle province voulez-vous contrôler ? ");
         Province p = demandeProvinceAControler(hProvince);
                
         // On ne peut défausser que si le joueur a les troupes requises
         if(aLesTroupesNecessaires(p)){
         llct.addAll(defausserLesTroupes(p));
         bonus = recupererTuileBonus(p);
         poserKamonDeScore(p);
         points = pointsMarques(p);
         incrementerScore(p);
         System.out.println("Félicitation, vous venez de prendre le contrôle de " + p.getNom() + " et vous récupérez le bonus " + bonus);
         System.out.println("Vous avez également marqué " + points + " points et votre score s'élève à " + this.score + " points !");
         }
         else{
         System.out.println("Vous n'avez pas les troupes nécessaires pour attaquer cette province ! ");
         }
         } 
         i++;
         }
        
         // Affichage des messages de fin de tour
         if(rep.equals("passer")){
         System.out.println(this.pseudo + ", vous avez décidé de passer votre tour !");
         }
         if(i == 3){
         System.out.println("Vous venez d'atteindre le nombre maximal de Kamons posés. Votre tour est fini ! ");
         }*/
    }

}
