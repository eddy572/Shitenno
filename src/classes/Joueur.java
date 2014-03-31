package classes;

import java.util.*;
/**
 *
 * @author Damien
 * @version 1.0
 */
public class Joueur {
    private String pseudo;
    private int score;
    private General general;
    private int nbkamons;
    private ArrayList<CarteTroupe> alctroupe;
    private ArrayList<Kokus> alkokus;
    private Titre titre;

/* Constructors */
    public Joueur(){
        
    }
    /**
     * Constructeur utile pour l'initialisation du joueur :
     * choix du pseudo, du général et nombre de kamons défini selon le nombre de joueurs
     * @param pseudo
     * @param general
     * @param nbkamons nombre de kamons défini selon le nombre de joueurs
     * @param score=0 au début du jeu le joueur n'a pas de points
     */
    public Joueur(String pseudo, General general, int nbkamons) {
        this.pseudo = pseudo;
        this.general = general;
        this.nbkamons = nbkamons;
        this.score = 0;
        this.alctroupe = new ArrayList<CarteTroupe>();
        this.alkokus = new ArrayList<Kokus>();
        this.titre = null;
    }

    public Joueur(String pseudo, int nbkamons) {
        this.pseudo = pseudo;
        this.nbkamons = nbkamons;
        this.general = null;
        this.score = 0;
        this.alctroupe = new ArrayList<CarteTroupe>();
        this.alkokus = new ArrayList<Kokus>();
        this.titre = null;
    }

    /* Getters & Setters */
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public int getNbkamons() {
        return nbkamons;
    }

    public void setNbkamons(int nbkamons) {
        this.nbkamons = nbkamons;
    }

    public ArrayList<CarteTroupe> getAlctroupe() {
        return alctroupe;
    }

    public void setAlctroupe(ArrayList<CarteTroupe> alctroupe) {
        this.alctroupe = alctroupe;
    }

    public ArrayList<Kokus> getAlkokus() {
        return alkokus;
    }

    public void setAlkokus(ArrayList<Kokus> alkokus) {
        this.alkokus = alkokus;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.pseudo);
        hash = 83 * hash + this.score;
        hash = 83 * hash + Objects.hashCode(this.general);
        hash = 83 * hash + this.nbkamons;
        hash = 83 * hash + Objects.hashCode(this.alctroupe);
        hash = 83 * hash + Objects.hashCode(this.alkokus);
        hash = 83 * hash + Objects.hashCode(this.titre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.general, other.general)) {
            return false;
        }
        if (this.nbkamons != other.nbkamons) {
            return false;
        }
        if (!Objects.equals(this.alctroupe, other.alctroupe)) {
            return false;
        }
        if (!Objects.equals(this.alkokus, other.alkokus)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }
    
/* Methods */
    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", score=" + score + ", general=" + general + ", nbkamons=" + nbkamons + ", alctroupe=" + alctroupe + ", alkokus=" + alkokus + ", titre=" + titre + '}';
    }
   
    public int nombreKamonInitial(int nbjoueur){
        int nbkamons = 0;
        
        if(nbjoueur == 2){
            nbkamons = 12;
        }
        if(nbjoueur == 3){
            nbkamons = 10;
        }
        if(nbjoueur == 4){
            nbkamons = 8;
        }
        
        return nbkamons;
    }
    
    /**
     * Demande de saisie des pseudo + vérification d'unicité de celui-ci
     * @param nbjoueur
     * @return 
     */
    public Set pseudoAlreadyUse(int nbjoueur){
        Set<Joueur> hjoueur = new HashSet<Joueur>();
        Scanner sc = new Scanner(System.in);
        boolean isAlreadyUsed = false;
        String pseudo = new String();
        
        for(int i=1; i<nbjoueur+1; i++){
            // On demande le pseudo du joueur i jusqu'à ce que celui-ci soit unique
            do{
                isAlreadyUsed = false;
                System.out.print("Pseudo pour le Joueur " + i +" : ");
                pseudo = sc.nextLine();
                
                for(Joueur j : hjoueur){
                    if(j.getPseudo().equals(pseudo)){
                        isAlreadyUsed = true;
                        System.err.println("Ce pseudo a déjà été choisi !");
                        break;
                    }
                }
            }while(isAlreadyUsed);
            
            isAlreadyUsed = false;
            Joueur j = new Joueur(pseudo, nombreKamonInitial(nbjoueur));
            hjoueur.add(j);
        }
        
        return hjoueur;
    }
    
    /**
     * Choix du général pour chaque joueur avec vérification de la saisie
     * Et impossibilité de prendre un général déjà sélectionné
     * @param hjoueur liste des joueurs
     * @param hgeneral liste des généraux
     */
    public void choixDuGeneral(Set<Joueur> hjoueur, Set<General> hgeneral){
        Scanner sc = new Scanner(System.in);
        String nomgeneral = new String();
        
        for(Joueur j : hjoueur){
            boolean isCorrect = false;
            // On vérifie que le choix du général est bien possible (pas déjà pris, existant)
            // Et on affecte ce général au joueur
            do{
                System.out.println("\n" + j.getPseudo() + ", quel général désirez-vous être ? ");
                // Affichage des généraux
                for(General g : hgeneral){
                    System.out.println(g.toString());
                }
                nomgeneral = sc.nextLine();
            
                // On ajoute le général au joueur s'il existe
                for(General g : hgeneral){
                    if(nomgeneral.equalsIgnoreCase(g.getNom())){
                        j.setGeneral(g);
                        hgeneral.remove(g);
                        isCorrect = true;
                        break;
                    }
                }
                if(!isCorrect){System.err.println("Le général que vous avez choisi n'existe pas !");}
            }while(!isCorrect);
        }
    }

}
