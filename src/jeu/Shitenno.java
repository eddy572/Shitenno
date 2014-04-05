package jeu;

import classes.*;
import jdom.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Damien
 */
public class Shitenno {
    static Scanner sc = new Scanner(System.in);
    private static int an = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*************/
    /* Variables */
    /*************/
        LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
        LinkedList<Kokus> llk = new LinkedList<Kokus>();
        ArrayList<Titre> altitre = new ArrayList<Titre>();
        int nbcartes = 0;
        // Liste qui récupère toutes les cartes troupes jouées.
        // Utile si le jeu n'est pas fini mais qu'il n'y a plus (assez) de cartes troupes à la pioche
        LinkedList<CarteTroupe> defaussetroupe = new LinkedList<CarteTroupe>();
        Set<Joueur> hjoueur = new HashSet<Joueur>();
        Joueur j = new Joueur();
        
     /******************/   
     /* Initialisation */
     /******************/
        // Initialisation du jeu (hors plateau de jeu)
        Initialisation init = new Initialisation();
        // On place l'initialisation des paquets dans des variables par soucis de simplicité dans le futur
        llct = init.initialisationPaquetTroupe();
        llk = init.initialisationPaquetKokus();
        
        // Choix des pseudos       
        hjoueur = j.pseudoAlreadyUse(nbJoueur());
        // Initialisation du nombre de cartes troupes à piocher chaque année paire
        nbcartes = init.nombreDeCartesTroupesAPiocher(hjoueur);
        // Choix des généraux pour chaque joueur
        j.choixDuGeneral(hjoueur, init.getHashGeneral());
        // Distribution de deux cartes Troupes au début du jeu
        altitre = SetEnArrayListTitre(init.getHashTitre());
        init.distributionCartesDepart(hjoueur, init.getLlctroupe(), altitre);
        for(Joueur jo : hjoueur){
            System.out.println(jo.toString());
        }
        
     /*********/
     /* Jouer */
     /*********/
        // On commence réellement la partie
        // Elle s'arrête si le paquet de Kokus est vide (la LinkedList)
        //while(init.getLlkokus().size() > 0){
            System.out.println("");
            System.out.println("***************************");
            System.out.println("*** Début de l'an " + an + " ***");
            System.out.println("***************************");
            // On initialise le tairo
            Tairo tairo = new Tairo();
            tairo.devientLeTairo(hjoueur);
            // Tests de bon fonctionnement
            System.out.println(tairo.getTairo());
            tairo.piocheCartesTroupes(llct, llk, nbcartes);
            System.out.println("Paquet de cartes Troupes piochées : " + tairo.getAlct());
            System.out.println("Paquet de cartes Kokus piochées : " + tairo.getAlk());
            System.out.println("");
            
            // Proposition des lots
            Lot lot = new Lot(tairo.getAlct(), tairo.getAlk());
            altitre = SetEnArrayListTitre(init.getHashTitre());
            //while((tairo.getAlct().size()>0) && (tairo.getAlk().size()>0)){
                Lot aSoumettre = new Lot();
                Joueur receveur = new Joueur();
                int nbCarteMain = 0;
                receveur = lot.joueurQuiRecoitLot(hjoueur, tairo);
                System.out.print(tairo.getTairo().getPseudo() + ", vous allez proposer un lot a " + receveur.getPseudo());
                nbCarteMain = receveur.nombreDeCartesEnMain();
                System.out.println(" qui a actuellement " + nbCarteMain + " cartes dans sa main.");

                aSoumettre = lot.compositionDuLot(altitre);
                System.out.println(aSoumettre.toString());
            //}
            an++;
        //}
        
    }
    
/* Methods */
    public static int nbJoueur() {
        int nb = 0;
        boolean isNumber = false;

        while(!isNumber){
            try{
                isNumber = true;
                System.out.println("\nA combien de joueur voulez-vous jouer ? 2,3 ou 4");
                nb = sc.nextInt();  
                
                if(nb < 2 || nb > 4){
                    System.err.println("Vous ne pouvez jouer qu'à 2, 3 ou 4 personnes !");
                    isNumber = false;
                }
                
            }
            catch(InputMismatchException e){
                System.err.println("Vous n'avez pas saisie un nombre !");
                sc.next();
                isNumber = false;
            }
        }
        
        return nb;
    }
    
    /**
     * Convertit un Set<Titre> en ArrayList<Titre> pour pouvoir faire des manipulations sans risquer de toucher au set d'initialisation
     * @param htitre Hashset de titre
     * @return une ArrayList de titre
     */
    public static ArrayList<Titre> SetEnArrayListTitre(Set<Titre> htitre){
        // On copie le hashSet des titre dans un tableau
        // On modifiera donc uniquement le tableau et non le hashSet d'initialisation
        Titre[] tabtitre = htitre.toArray(new Titre[htitre.size()]);
        // On convertit le tableau en liste pour mélanger et plus de simplicitée.
        ArrayList<Titre> list = new ArrayList<Titre>(Arrays.asList(tabtitre));
        Collections.shuffle(list);
        
        return list;
    }
    
}
