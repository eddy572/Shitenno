package jeu;

import classes.*;
import comparateur.*;
import java.util.*;

/**
 *
 * @author Damien
 */
public class MainTest {
    static Scanner sc = new Scanner(System.in);
    private static int an = 0;

    
    public static void main(String[] args) {
    /*************/
    /* Variables */
    /*************/
        LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
        LinkedList<Kokus> llk = new LinkedList<Kokus>();
        ArrayList<Titre> altitre = new ArrayList<Titre>();
        ArrayList<Joueur> aljoueur = new ArrayList<Joueur>();
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
        
        // Création des joueurs      
        hjoueur.add(new Joueur("J1", 10));
        hjoueur.add(new Joueur("J2", 10));
        hjoueur.add(new Joueur("J3", 10));
        // Initialisation du nombre de cartes troupes à piocher chaque année paire
        nbcartes = 6;
        int compteur = 1, compteur2 = 1;
        // Choix des généraux pour chaque joueur
        for(Joueur jo : hjoueur){
            compteur2 = 1;
            for(General g : init.getHashGeneral()){
                if(compteur == compteur2){
                    jo.setGeneral(g);
                }
                compteur2++;
            }
            compteur++;
        }
        
        // Distribution de deux cartes Troupes au début du jeu
        altitre = new ArrayList(init.getHashTitre());
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
            // On cast les hashSet en ArrayList pour pouvoir effectuer des modifications, tout en gardant l'initialisation intact
            altitre = new ArrayList(init.getHashTitre());
            aljoueur = new ArrayList(hjoueur);
            Collections.sort(aljoueur);
            // On initialise le tairo
            Tairo tairo = new Tairo();
            tairo.devientLeTairo(aljoueur);
            // Tests de bon fonctionnement
            System.out.println(tairo.getTairo());
            tairo.piocheCartesTroupes(llct, llk, nbcartes);
            System.out.println("Paquet de cartes Troupes piochées : " + tairo.getAlct());
            System.out.println("Paquet de cartes Kokus piochées : " + tairo.getAlk());
            System.out.println("");
            
            // Proposition des lots
            Lot lot = new Lot(tairo.getAlct(), tairo.getAlk());

            while((tairo.getAlct().size()>0) && (tairo.getAlk().size()>0)){
                Lot aSoumettre = new Lot();
                int nbCarteMain = 0;
                boolean isAccepted = false;

                for(Joueur player : aljoueur){  
                    // Le traitement ne se fait que s'il ne s'agit pas du Tairo et qu'il n'a pas encore reçu de lot
                    if(!player.getPseudo().equals(tairo.getTairo().getPseudo()) && player.getTitre() != null){
                        if(aSoumettre.getTitre() == null){
                            System.out.print(tairo.getTairo().getPseudo() + ", vous allez proposer un lot a " + player.getPseudo());
                            nbCarteMain = player.nombreDeCartesEnMain();
                            System.out.println(" qui a actuellement " + nbCarteMain + " cartes dans sa main.");

                            aSoumettre = lot.compositionDuLot(altitre);
                            System.out.println("\n** Lot formé : **");
                            System.out.println(aSoumettre.toString());
                            lot.soumettreLeLot(altitre, aSoumettre);
                        }

                        if(player.accepterRefuserLot(tairo.getTairo(), aSoumettre).equalsIgnoreCase("accepter")){
                            isAccepted = true;
                            break;
                        }
                    }
                }
                if(!isAccepted){
                    System.out.println(tairo.getTairo().getPseudo() + ", ce lot vous reviens puisque personne ne le veut.");
                    tairo.getTairo().cartesAcceptees(aSoumettre);
                    System.out.println("Voici votre nouvelle main : ");
                    System.out.println(tairo.getTairo().getAlctroupe().toString());
                    System.out.println(tairo.getTairo().getAlkokus().toString());
                    System.out.println(tairo.getTairo().getHierarchie().toString());
                    aljoueur.remove(tairo.getTairo());
                    tairo.devientLeTairo(aljoueur);
                    System.out.println("Le nouveau Tairo est maintenant : " + tairo.getTairo().getPseudo());
                }

            }
            an++;
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
    
}
