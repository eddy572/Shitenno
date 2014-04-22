package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Bonus {
    private String nom;
    private final String KOKU = "koku";
    private final String TROUPES = "troupe";
    
    /* Constructor */
    public Bonus(String nom) {
        this.nom = nom;
    }

    /* Getters & Setters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append("Effet : ").append(nom));
    }
    
    /**
     * Méthode qui demande au joueur s'il veut échanger une troupe ou un koku
     * @return le choix fait (string)
     */
    public String demandeCarteAEchanger(String type){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(true){
            if(type.equals("Echanger")){System.out.print("Que voulez-vous échanger ? Une troupe ou un koku ? ");}
            else{System.out.print("Par quoi voulez-vous l'échanger ? Une troupe ou un koku ? ");}
            
            rep = sc.nextLine().toLowerCase();
            if(!rep.equals(this.TROUPES) && !rep.equals(this.KOKU)){
                System.err.println("Vous ne pouvez pas remplacer autre chose qu'une troupe ou un koku !");
            }
            else{
                return rep;
            }
        }
    }
    
    /**
     * Méthode qui permet de choisir la nouvelle troupe qu'on veut dans sa main (en échange d'une autre carte)
     * @param sTroupes liste des troupes pour vérifier que celle saisie existe bien
     * @return une carte troupe avec la troupe choisie
     */
    public CarteTroupe choixDeLaTroupePourEchange(Set<Troupes> sTroupes){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(true){
            System.out.print("Quelle troupe voulez-vous en échange ? ");
            rep = sc.nextLine().toLowerCase();
            
            for(Troupes t : sTroupes){
                if(rep.equalsIgnoreCase(t.getNom())){
                    return new CarteTroupe(t);
                }
            }
            if(rep.contains("&")){System.out.println("On t'a demandé une troupe pas une carte troupe !!!");}
            else{System.err.println("Cette troupe n'existe pas dans le jeu idiot !");}
        }
    }
    
    /**
     * Méthode qui choisi la carte koku qu'on veut modifier (retirer un koku en échange d'une nouvelle troupe)
     * @param sKokus liste des kokus disponibles dans le jeu
     * @return une nouvelle carte kokus (ancienne - 1 koku)
     */
    public Kokus choixDeLaCarteKokuAModifier(Set<Kokus> sKokus){
        Scanner sc = new Scanner(System.in);
        int rep = 0;
        
        while(true){
            try{
            System.out.print("Quelle carte koku voulez-vous utiliser pour l'échange ? (saisir le nombre de kokus) ");
            rep = sc.nextInt();
            
            for(Kokus k : sKokus){
                if(rep == k.getNbkoku()){
                    return new Kokus(rep);
                }
            }
            System.err.println("Cette carte koku n'existe pas dans le jeu idiot !");
            }
            catch(InputMismatchException ime){
                System.err.println("Vous devez saisir un entier est rien d'autre, merci !!!");
                sc.next();
            }
        }
    }
    
    public CarteTroupe choixDeLaCarteTroupeAModifier(Set<Troupes> sTroupes){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(true){
            System.out.print("Quelle carte troupe voulez-vous utiliser pour l'échange ? ");
            rep = sc.nextLine();
            
            // Véification d'une carte double
            if(rep.contains("&")){
                String split[] = rep.split("&");
                for(Troupes t1 : sTroupes){
                    for(Troupes t2 : sTroupes){
                        if(split[0].trim().equalsIgnoreCase(t1.getNom()) && split[1].trim().equalsIgnoreCase(t2.getNom())){
                            return new CarteTroupe(t1, t2);
                        }
                    } 
                }
            }
            else{ // Vérification d'une carte simple
                for(Troupes t1 : sTroupes){
                    if(rep.equalsIgnoreCase(t1.getNom())){
                        return new CarteTroupe(t1);
                    }
                }
            }
            System.err.println("Cette carte troupe n'existe pas dans le jeu idiot !");
        }
    }
    
    /**
     * Méthodes qui renvoie la troupe qu'on veut garder (malgré le fait qu'on demande la troupe qu'on veut échanger)
     * @param ct la carte dont on veut connaitre quelle troupe garder
     * @return la troupe à garder
     */
    public Troupes choixParmiDeuxTroupes(CarteTroupe ct){
        Scanner sc = new Scanner(System.in);
        String rep = null;
        
        while(true){
            rep = sc.nextLine();
            // SI on veut échanger la première troupe, alors on renvoi la deuxième et vice versa
            if(rep.equalsIgnoreCase(ct.getTroupe1().getNom())){
                return ct.getTroupe2();
            }
            if(rep.equalsIgnoreCase(ct.getTroupe2().getNom())){
                return ct.getTroupe1();
            }
            System.err.println("Faut choisir l'une des deux troupes sur la carte idiot bête !");
            System.err.print("Retentes ta chance : ");
        }
    }
    
    /**
     * Méthode qui créé une carte troupe avec la troupe que le joueur a décidé de garder
     * @param ct carte troupe que l'on veut modifier
     * @return une nouvelle carte troupe contenant la troupe à garder
     */
    public CarteTroupe carteTroupeDivise(CarteTroupe ct){
        Troupes tNew = null;
        
        System.out.println("Voici la carte que vous avez choisi : " + ct.toString());
        System.out.print("Quelle troupe parmi l'une des deux présentes voulez-vous échanger ? ");
        // Troupe qu'il faut supprimer de la carte double du joueur
        tNew = choixParmiDeuxTroupes(ct);
        
        return new CarteTroupe(tNew);
    }
    
    public void bonusEchange(Initialisation init, Joueur j, Troupes t){
        String choix = demandeCarteAEchanger("Echanger");
        String choixEchange = null;
        
        // Echange d'un koku = choix de la carte à modifier + choix de la troupe désirée + modification de la carte koku + ajout de la carte troupe
        if(choix.equalsIgnoreCase(this.KOKU)){
            CarteTroupe ct = choixDeLaTroupePourEchange(init.getHashTroupes());
            Kokus k = choixDeLaCarteKokuAModifier(init.getHashKokus());
            // On boucle jusqu'à que le joueur choisisse une carte koku qu'il a dans sa main
            while(j.verifExistenceCarteKokus(k.getNbkoku()) == null){
                System.err.println("Comment veux-tu modifier une carte koku que tu n'as pas, tu m'expliques ?!");
                k = choixDeLaCarteKokuAModifier(init.getHashKokus());
            }
            // On ajoute une carte koku (mais avec un koku de moins que la carte choisie) à la main du joueur
            if(k.getNbkoku() > 1){
                j.getAlkokus().add(new Kokus(k.getNbkoku()-1));
            }
            // On supprime la carte choisi (car une modification = suppression + ajout)
            j.getAlkokus().remove(k);
            // On ajoute la troupe de remplacement dans la main du joueur
            j.getAlctroupe().add(ct);
        }
        else{
            CarteTroupe ctAModif = choixDeLaCarteTroupeAModifier(init.getHashTroupes());
            while(!j.verifExistenceCarte(ctAModif.toString())){
                System.err.println("Comment veux-tu modifier une carte troupe que tu n'as pas, tu m'expliques ?!");
                ctAModif = choixDeLaCarteTroupeAModifier(init.getHashTroupes());
            }
            // On demande par quoi la troupe doit-être échangée : une autre troupe ou un koku ?
            choixEchange = demandeCarteAEchanger("Contre");
            
            if(choixEchange.equals(this.KOKU)){
                j.getAlctroupe().remove(ctAModif);
                if(ctAModif.getTroupe2() != null){
                    CarteTroupe cNew = carteTroupeDivise(ctAModif);
                    j.getAlctroupe().add(cNew);
                }
                j.getAlkokus().add(new Kokus(1));
            }
            else{
                CarteTroupe ct = choixDeLaTroupePourEchange(init.getHashTroupes());
                // Suppression de la carte troupe car : modification = suppr + création (carte double) ou suppression (carte simple)
                j.getAlctroupe().remove(ctAModif);
                if(ctAModif.getTroupe2() != null){
                    CarteTroupe cNew = carteTroupeDivise(ctAModif);
                    j.getAlctroupe().add(cNew);
                }
                // Ajout de la carte désirée durant l'échange (carte troupe simple)
                j.getAlctroupe().add(ct);
            }
        }
    }
    
    /**
     * Méthode qui cré une nouvelle carte troupe
     * @param t troupe à partir de laquelle la carte doit être créée
     * @return la nouvelle carte troupe
     */
    public CarteTroupe bonusPlusUn(Troupes t){
        return new CarteTroupe(t);
    }
    /**
     * Méthodes qui cré une nouvelle carte koku
     * @return une nouvelle carte koku de 1
     */
    public Kokus bonusPlusUn(){
        return new Kokus(1);
    }
    
    /**
     * Méthode qui permet de piocher une nouvelle carte troupe à tout moment, sile joueur
     * fait appel à une tuile bonus "Pioche"
     * @param llct liste des cartes formant la pioche
     * @return la nouvelle carte troupe piochée
     */
    public CarteTroupe bonusPioche(LinkedList<CarteTroupe> llct){
        CarteTroupe ct = null;
        
        if(!llct.isEmpty()){
            ct = llct.getLast();
            llct.removeLast();
        }
        
        return ct;
    }
    
    
}
