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
        
        // Choix des pseudos       
        hjoueur = j.pseudoAlreadyUse(nbJoueur());
        // Initialisation du nombre de cartes troupes à piocher chaque année paire
        nbcartes = init.nombreDeCartesTroupesAPiocher(hjoueur);
        // Choix des généraux pour chaque joueur
        j.choixDuGeneral(hjoueur, init.getHashGeneral());
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
            // On initialise le tairo
            Tairo tairo = new Tairo();
            tairo.devientLeTairo(aljoueur);
            // Tests de bon fonctionnement
            System.out.println(tairo.getTairo());
            tairo.piocheCartes(llct, llk, nbcartes);
            System.out.println("Paquet de cartes Troupes piochées : " + tairo.getAlct());
            System.out.println("Paquet de cartes Kokus piochées : " + tairo.getAlk());
            System.out.println("");
            
            // Proposition des lots
            Lot lot = new Lot(tairo.getAlct(), tairo.getAlk());
            int dernier = hjoueur.size();
            
            while(dernier > 0){
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
                        // On demande au joueur s'il accepte ou non le lot et on affecte les cartes à sa main si oui
                        if(player.accepterRefuserLot(tairo.getTairo(), aSoumettre).equalsIgnoreCase("accepter")){
                            dernier--;
                            isAccepted = true;
                            break;
                        }
                    }
                }
                if(!isAccepted){
                    System.out.println(tairo.getTairo().getPseudo() + ", ce lot vous reviens puisque personne ne le veut.");
                    if(dernier > 1){tairo.getTairo().cartesAcceptees(aSoumettre);}
                    else{
                        tairo.getTairo().cartesAcceptees(lot);
                        tairo.getTairo().setTitre(null);
                        tairo.getTairo().setHierarchie(altitre.get(0));
                    }
                    System.out.println("Voici votre nouvelle main : ");
                    System.out.println(tairo.getTairo().getAlctroupe().toString());
                    System.out.println(tairo.getTairo().getAlkokus().toString());
                    System.out.println(tairo.getTairo().getHierarchie().toString());
                    aljoueur.remove(tairo.getTairo());
                    if(dernier > 1){
                        tairo.devientLeTairo(aljoueur);
                        System.out.println("");
                        System.out.println("Le nouveau Tairo est maintenant : " + tairo.getTairo().getPseudo());
                    }
                    dernier--;
                }

            }
            System.out.println("************************");
            System.out.println("*** Fin de l'an " + an + " ***");
            System.out.println("************************");
            an++;
            
            // A supprimer : vérification que les listes de cartes de chaque joueurs ont bien été modifiées
            for(Joueur jou : hjoueur){
                System.out.println(jou.getPseudo());
                System.out.println(jou.getAlctroupe().toString());
                System.out.println(jou.getAlkokus().toString());
                System.out.println(jou.getHierarchie().toString());
                System.out.println("");
            }
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
}
