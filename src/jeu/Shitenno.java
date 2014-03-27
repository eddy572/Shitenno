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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Joueur> hjoueur = new HashSet<Joueur>();
        Joueur j = new Joueur();
        
        // Initialisation du jeu (hors plateau de jeu)
        Initialisation init = new Initialisation();
        // Choix des pseudos       
        hjoueur = j.pseudoAlreadyUse(nbJoueur());
        // Choix des généraux
        j.choixDuGeneral(hjoueur, init.getHashGeneral());
        // Distribution de deux cartes Troupes au début du jeu
        init.distributionCartesDepart(hjoueur, init.getLlctroupe());
        for(Joueur jo : hjoueur){
            System.out.println(jo.toString());
        }
        
        init.distributionTitreDepart(hjoueur, init.getHashTitre());
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
