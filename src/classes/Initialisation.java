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
        this.hashBonus = new JDom("src/fichierxml/Bonus.xml").initialisationJeu("bonus");
        this.hashGeneral = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
        this.hashKokus = new JDom("src/fichierxml/Kokus.xml").initialisationJeu("kokus");
        this.hashProvince = new JDom("src/fichierxml/Province.xml").initialisationJeu("province");
        this.hashTitre = new JDom("src/fichierxml/Titre.xml").initialisationJeu("titre");
        this.hashTroupes = new JDom("src/fichierxml/Troupes.xml").initialisationJeu("troupes");
        
        this.llctroupe = initialisationPaquetTroupe();
        this.llkokus = initialisationPaquetKokus();
        this.lltbonus = initialisationTuileBonus();
        initialisationFinaleProvince();
        for(Province p : this.hashProvince){
            System.out.println(p.toString());
        }
        
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
}
