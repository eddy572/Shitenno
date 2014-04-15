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
        hjoueur.add(new Joueur("J4", 10));
        // Initialisation du nombre de cartes troupes à piocher chaque année paire
        nbcartes = 8;
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
            tairo.piocheCartes(llct, llk, nbcartes);
       /*
            System.out.println("Paquet de cartes Troupes piochées : " + tairo.getAlct());
            System.out.println("Paquet de cartes Kokus piochées : " + tairo.getAlk());
            System.out.println("");
            
            // Proposition des lots
            Lot lot = new Lot(tairo.getAlct(), tairo.getAlk());
            // Variable qu'on décrémente a chaque fois qu'on change de Tairo ou que le lot soumis est accepté
            int dernier = hjoueur.size();
            
            // On propose des lots tant qu'on est pas arrivé au dernier joueur
            while(dernier > 0){
                Lot aSoumettre = new Lot();
                System.out.println(aSoumettre.verifieExistenceCarte("1", "koku"));
                int nbCarteMain = 0;
                boolean isAccepted = false;
                
                for(Joueur player : aljoueur){  
                    // Le traitement ne se fait que s'il ne s'agit pas du Tairo et qu'il n'a pas encore reçu de lot
                    if(!player.getPseudo().equals(tairo.getTairo().getPseudo()) && player.getTitre() != null){
                        // Formation d'un lot uniquement si on n'a pas encore de lot de formé ou non accepté
                        if(aSoumettre.getTitre() == null){
                            System.out.print(tairo.getTairo().getPseudo() + ", vous allez proposer un lot a " + player.getPseudo());
                            nbCarteMain = player.nombreDeCartesEnMain();
                            System.out.println(" qui a actuellement " + nbCarteMain + " cartes dans sa main.");

                            aSoumettre = lot.compositionDuLot(altitre);
                            System.out.println("\n** Lot formé : **");
                            System.out.println(aSoumettre.toString());
                            lot.soumettreLeLot(altitre, aSoumettre);
                        }
                        // Si le joueur accepte le lot, on lui attribue les cartes de celui-ci et on affiche la nouvelle main
                        // On mais le booléen à true et on casse la boucle pour ne pas soumettre le lot accepté aux autres joueurs
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
        */
            for(Joueur jj : hjoueur){
                ArrayList<Kokus> alkk = new ArrayList<>();
                alkk.add(tairo.getAlk().get(0));
                tairo.getAlk().remove(0);
                jj.setAlkokus(alkk);
                jj.setTitre(altitre.get(0));
                altitre.remove(0);
                ArrayList<CarteTroupe> alctt = new ArrayList<>();
                for(int i=0; i<3; i++){
                    alctt.add(llct.getFirst());
                    llct.removeFirst();
                }
                jj.getAlctroupe().addAll(alctt);
            }
            
            aljoueur = new ArrayList<>(hjoueur);
            Collections.sort(aljoueur);
            
            System.out.println("************************");
            System.out.println("*** Fin de l'an " + an + " ***");
            System.out.println("************************");
            an++;
            
            System.out.println("\n\n\n***************************");
            System.out.println("***** Début de l'an " + an + " *****");
            System.out.println("*** (Prise de contrôle) ***");
            System.out.println("***************************");
            for(Province p : init.getHashProvince()){
                System.out.println(p.toString());
            }
            
            for(Joueur jo : aljoueur){
                System.out.println(jo.toString());
                jo.jouer(defaussetroupe);
            }
    }

/* Methods */
    /**
     * Choix du nombre de joueurs dans la partie
     * @return 
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
    
}
