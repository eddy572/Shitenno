package classes;

import java.io.*;
import java.util.*;
import jdom.JDom;

/**
 *
 * @author Damien
 * @version 1.0
 */
public class Initialisation {
    private Set<Bonus> hashBonus;
    private Set<General> hashGeneral;
    private Set<Kokus> hashKokus;
    private Set<Province> hashProvince;
    private Set<Titre> hashTitre;
    private Set<Troupes> hashTroupes;
    private LinkedList<CarteTroupe> llctroupe; // Paquet "Troupes"
    private LinkedList<Kokus> llkokus; // Paquet "Kokus"
    private LinkedList<TuileBonus> lltbonus; // Paquet "Tuile Bonus"
    
/* Constructors */
    public Initialisation() {
        // Lecture des fichiers XML grâce à JDom
        this.hashBonus = new JDom("src/fichierxml/Bonus.xml").initialisationJeu("bonus");
        this.hashGeneral = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
        this.hashKokus = new JDom("src/fichierxml/Kokus.xml").initialisationJeu("kokus");
        this.hashProvince = new JDom("src/fichierxml/Province.xml").initialisationJeu("province");
        this.hashTitre = new JDom("src/fichierxml/Titre.xml").initialisationJeu("titre");
        this.hashTroupes = new JDom("src/fichierxml/Troupes.xml").initialisationJeu("troupes");
        
        
        // Affichage des résultats d'initialisation
        System.out.println("*** Les généraux ***");
        for(General g : this.hashGeneral){
            System.out.println(g.toString());
        }
        
        System.out.println("\n*** Les Titres ***");
        for(Titre t : this.hashTitre){
            System.out.println(t.toString());
        }
        
        System.out.println("\n*** Le paquet Troupes (mélangé) ***");
        this.llctroupe = initialisationPaquetTroupe();
        for(CarteTroupe ct : this.llctroupe){
            System.out.println(ct.toString());
        }
        
        System.out.println("\n*** Le paquet Kokus (mélangé) ***");
        this.llkokus = initialisationPaquetKokus();
        for(Kokus k : this.llkokus){
            System.out.println(k.toString());
        }
        
        System.out.println("\n*** Les Tuiles Bonus (mélangées) ***");
        this.lltbonus = initialisationTuileBonus();
        for(TuileBonus tb : this.lltbonus){
            System.out.println(tb.toString());
        }
        
        System.out.println("\n*** Les Provinces ***");
        initialisationFinaleProvince();
        ajoutTroisTuileBonus(hashProvince, lltbonus);
        for(Province p : this.hashProvince){
            System.out.println("\n" + p.toString());
            for(TuileBonus tb : p.getLltuilebonus()){
                System.out.println(tb.toString());
            }
        }
        
    }

/* Getters & Setters */
    public Set<Bonus> getHashBonus() {
        return hashBonus;
    }

    public void setHashBonus(Set<Bonus> hashBonus) {
        this.hashBonus = hashBonus;
    }

    public Set<General> getHashGeneral() {
        return hashGeneral;
    }

    public void setHashGeneral(Set<General> hashGeneral) {
        this.hashGeneral = hashGeneral;
    }

    public Set<Kokus> getHashKokus() {
        return hashKokus;
    }

    public void setHashKokus(Set<Kokus> hashKokus) {
        this.hashKokus = hashKokus;
    }

    public Set<Province> getHashProvince() {
        return hashProvince;
    }

    public void setHashProvince(Set<Province> hashProvince) {
        this.hashProvince = hashProvince;
    }

    public Set<Titre> getHashTitre() {
        return hashTitre;
    }

    public void setHashTitre(Set<Titre> hashTitre) {
        this.hashTitre = hashTitre;
    }

    public Set<Troupes> getHashTroupes() {
        return hashTroupes;
    }

    public void setHashTroupes(Set<Troupes> hashTroupes) {
        this.hashTroupes = hashTroupes;
    }

    public LinkedList<CarteTroupe> getLlctroupe() {
        return llctroupe;
    }

    public void setLlctroupe(LinkedList<CarteTroupe> llctroupe) {
        this.llctroupe = llctroupe;
    }

    public LinkedList<Kokus> getLlkokus() {
        return llkokus;
    }

    public void setLlkokus(LinkedList<Kokus> llkokus) {
        this.llkokus = llkokus;
    }

    public LinkedList<TuileBonus> getLltbonus() {
        return lltbonus;
    }

    public void setLltbonus(LinkedList<TuileBonus> lltbonus) {
        this.lltbonus = lltbonus;
    }
    
    
    
/* Methodes */
    /**
     * Ajout de la troupe présente dans la province
     * On fait un void car la liste existe déjà
     * On ne fait que la modifier
     */
    public void initialisationFinaleProvince(){
        for(Province p : this.hashProvince){
            switch(p.getNom()){
                case "Chugoku" : 
                case "Kanto" : p.setTroupe(new Troupes("Samouraï", "Vert"));
                    break;
                case "Chubu" : 
                case "Kansai" : p.setTroupe(new Troupes("Shinobi", "Noir"));
                    break;
                case "Hokkaido" : 
                case "Shikoku" : p.setTroupe(new Troupes("Sohei", "Orange"));
                    break;
                case "Kyushu" : 
                case "Tohoku" : p.setTroupe(new Troupes("Bushi", "Bleu"));
                    break;
            }
        }
    }
    
    /**
     * On créé la paquet de carte Troupes
     * @return 
     */
    public LinkedList<CarteTroupe> initialisationPaquetTroupe(){
        LinkedList<CarteTroupe> llct = new LinkedList<CarteTroupe>();
        int i=1;
        
        for(Troupes t : hashTroupes){
            CarteTroupe ct = new CarteTroupe(t);
            // On met 6 fois la même carte dans la liste
            for(int k=0; k<6; k++){
                llct.add(ct);
            }
            // il faut également mettre un carte avec deux troupes (en tout 6 cartes)
            int j = 1;
            for(Troupes t2 : hashTroupes){
                // On ne reprend pas les cartes précédentes (elles ont déjà ét traitées)
                if(i== j || i<j){
                    CarteTroupe ct2 = new CarteTroupe(t,t2);
                    llct.add(ct2);
                }
                j++;
            }
            i++;
        }
        // On mélange le paquet
        Collections.shuffle(llct);
        
        return llct;
    }
    
    /**
     * On créé le paquet de cartes Kokus
     * @return 
     */
    public LinkedList<Kokus> initialisationPaquetKokus(){
        LinkedList<Kokus> llk = new LinkedList<Kokus>();
        
        for(Kokus k : this.hashKokus){
            // 12 cartes kokus de 1 unité
            if(k.getNbkoku()==1){
                for(int i=0; i<12; i++){
                    llk.add(k);
                }
            }
            
             // 8 cartes kokus de 2 unités
            if(k.getNbkoku()==2){
                for(int i=0; i<8; i++){
                    llk.add(k);
                }
            }
            
             // 4 cartes kokus de 3 unités
            if(k.getNbkoku()==3){
                for(int i=0; i<4; i++){
                    llk.add(k);
                }
            }
        }
        Collections.shuffle(llk);
        
        return llk;
    }
    
    /**
     * On créé les tuiles bonus en fonction des troupes et des bonus
     * @return lltb liste des tuiles bonus
     */
    public LinkedList<TuileBonus> initialisationTuileBonus(){
        LinkedList<TuileBonus> lltb = new LinkedList<TuileBonus>();
        
        for(Troupes t : hashTroupes){
            for(Bonus b : hashBonus){
                TuileBonus tb = new TuileBonus(t, b);
                for(int i=1; i<3; i++){
                    lltb.add(tb);
                }
            }
        }
        Collections.shuffle(lltb);
        
        return lltb;
    }
    
    /**
     * Distribution de 2 cartes Troupes à chaque joueurs
     * On retire les deux dernières cartes du paquet de troupes
     * @param hjoueur liste des joueurs
     * @param llct paquet des cartes troupes qui sert à donner des cartes aux joueurs 
     */
    public void distributionCartesDepart(Set<Joueur> hjoueur, LinkedList<CarteTroupe> llct){
        for(Joueur j : hjoueur){
            // Distibution des titres aléatoirement
            distributionTitreDepart(hjoueur, hashTitre);
            
            int i = 0;
            // On prend la liste de carte troupe du joueur
            ArrayList<CarteTroupe> alct = j.getAlctroupe();
            
            // On ne prend que deux cartes troupes (à chaque fois la dernière du paquet)
            while(i < 2){
                alct.add(llct.getLast());
                // On supprime la carte pour ne plus l'avoir dans le paquet
                llct.removeLast();
                i++;
            }
        }
    }
    
    /**
     * On distribue 2 cartes troupes à chaque joueur
     * Methode appelé dans "distributionCartesDepart(x, y)"
     * @param hjoueur hashset des joueurs
     * @param htitre hashset des titres
     */
    public void distributionTitreDepart(Set<Joueur> hjoueur, Set<Titre> htitre){
        // On copie le hashSet des titre dans un tableau
        // On modifiera donc uniquement le tableau et non le hashSet d'initialisation
        Titre[] tabtitre = htitre.toArray(new Titre[htitre.size()]);
        // On convertit le tableau en liste pour mélanger et plus de simplicitée.
        ArrayList<Titre> list = new ArrayList<Titre>(Arrays.asList(tabtitre));
        Collections.shuffle(list);
        
        for(Joueur j : hjoueur){
            // On affecte le titre au joueur
            j.setTitre(list.get(0));
            // On supprimer le titre de la liste pour ne pas le redonner
            list.remove(0);
        }
    }
    
    /**
     * On ajoute trois tuile bonus par province
     * @param hprovince hashset de toutes les provinces
     * @param lltb LinkedList des tuiles bonus (utile pour chopper la dernière tuile de la pile)
     */
    public void ajoutTroisTuileBonus(Set<Province> hprovince, LinkedList<TuileBonus> lltb){       
        for(Province p : hprovince){
            LinkedList<TuileBonus> llp = new LinkedList<TuileBonus>();
            int i = 0;
            
            while(i < 3){
                llp.add(lltb.getLast());
                lltb.removeLast();
                i++;
            }
            p.setLltuilebonus(llp);
        }
    }
    
    /**
     * Fonction qui défini le nombre de cartes troupes à piocher
     * selon le nombre de joueurs présents
     * @param hjoueur liste des joueurs utile pour connaître leur nombre
     * @return 
     */
    public int nombreDeCartesTroupesAPiocher(Set<Joueur> hjoueur){
        // Le nombre de cartes se calcul comme suit :
        // Nombre de joueur * 2 (ex : 3 joueurs => 6 cartes)
        return hjoueur.size()*2;
    }
}
