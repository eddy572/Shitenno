package jeu;

import classes.*;
import jdom.*;
import java.util.*;
import java.io.*;
import static jeu.MainTest.classementDesJoueurs;
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
        int nbJoueur = 0;
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
        
        // Choix du nombre de joueurs
        nbJoueur = nbJoueur();
        // Choix des pseudos       
        hjoueur = j.pseudoAlreadyUse(nbJoueur);
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
        while(!init.getLlkokus().isEmpty()){
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
            remplirPiocheVide(llct, defaussetroupe, nbJoueur);
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

            System.out.println("************************");
            System.out.println("*** Début de l'an " + an + " ***");
            System.out.println("*** (Prise de contrôle) ***");
            System.out.println("************************");
            for(Joueur jo : hjoueur){
                System.out.println("");
                System.out.println("");
                System.out.println(jo.toString());
                System.out.println("");
                jo.jouer(llct, defaussetroupe, init.getHashProvince());
            }
       }
        
        System.out.println("");
        System.out.println("");
        System.out.println("************************");
        System.out.println("*** FIN DE LA PARTIE ***");
        System.out.println("************************");
        System.out.println("");
        // Ajout des derniers points de score (provinces contrôlées, cartes encore en main, etc...)
        for(Joueur joueur : hjoueur){
            System.out.println("");
            System.out.println("");
            joueur.scoreFinal(init.getHashProvince());
        }
        // Affichage du classement final
        classementDesJoueurs(hjoueur);
    }
    
/* Methods */
    /**
     * On demande la saisie du nombre de joueur compris entre 2 et 4
     * Si le nombre saisie n'est pas entre 2 et 4 inclus
     * ou n'est pas un entier on redemande la saisie
     * @return nb le nombre de joueurs
     */
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
     * Remplit la pioche avec toutes les cartes troupes défaussées si celle-ci est vide.
     * On vide la pile de défausse et on mélange la nouvelle pioche
     * @param llPioche est la pioche
     * @param llDefausse est la pile de cartes défaussées
     */
    public static void remplirPiocheVide(LinkedList<CarteTroupe> llPioche, LinkedList<CarteTroupe> llDefausse, int nbJoueur){
        if(llPioche.isEmpty() || llPioche.size() < nbJoueur * 2){
            llPioche.addAll(llDefausse);
            Collections.shuffle(llPioche);
            llDefausse.clear();
        } 
    }
    
    /**
     * Affichage du classement des joueurs selon leur score afin de connaitre le vainqueur
     * @param sJoueur liste des joueurs participants
     */
    public static void classementDesJoueurs(Set<Joueur> sJoueur){
        List<Joueur> lJoueur = new ArrayList<>(sJoueur);
        int i = 0, suppr = 0, score = 0, classement = 1;
        boolean stop = false;
        
        System.out.println("Voici le classement final : ");
        while(!stop){
            i = 0; suppr = 0; score = 0;
            if(lJoueur.size() > 1){
                for(Joueur j : lJoueur){
                    if(j.getScore() > score){
                        score = j.getScore();
                        suppr = i;
                    }
                    i++;
                }
            }
            else{
                stop = true;
            }
            // Affichage du classement et suppression de la personne affichée
            System.out.println(classement + ". " + lJoueur.get(suppr).getPseudo() + " avec " + lJoueur.get(suppr).getScore() + " points.");
            // On enlève le joueur de la liste pour ne pas l'afficher à nouveau
            lJoueur.remove(suppr);
            // On augmente le numéro du classement
            classement++;
        }
    }
}
