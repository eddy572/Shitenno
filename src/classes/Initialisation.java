/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.io.*;
import java.util.*;
import jdom.JDom;

/**
 *
 * @author Damien
 */
public class Initialisation {
    private Set<Bonus> hashBonus;
    private Set<General> hashGeneral;
    private Set<Kokus> hashKokus;
    private Set<Province> hashProvince;
    private Set<Titre> hashTitre;
    private Set<Troupes> hashTroupes;
    private ArrayList<CarteTroupe> alctroupe; // Paquet "Troupes"
    private ArrayList<Kokus> alkokus; // Paquet "Kokus"
    
/* Constructors */
    public Initialisation() {
        this.hashBonus = new JDom("src/fichierxml/Bonus.xml").initialisationJeu("bonus");
        this.hashGeneral = new JDom("src/fichierxml/General.xml").initialisationJeu("general");
        this.hashKokus = new JDom("src/fichierxml/Kokus.xml").initialisationJeu("kokus");
        this.hashProvince = new JDom("src/fichierxml/Province.xml").initialisationJeu("province");
        this.hashTitre = new JDom("src/fichierxml/Titre.xml").initialisationJeu("titre");
        this.hashTroupes = new JDom("src/fichierxml/Troupes.xml").initialisationJeu("troupes");
        
        this.alctroupe = initialisationPaquetTroupe();
        for(CarteTroupe ct : alctroupe){
            System.out.println(ct.toString());
        }
    }
    
/* Methodes */
    /**
     * On affecte la troupe adéquate à chaque province
     */
    public void initialisationFinaleProvince(){
        for(Province p : this.hashProvince){
            
        }
    }
    
    /**
     * On créé la paquet de carte Troupes
     * @return 
     */
    public ArrayList<CarteTroupe> initialisationPaquetTroupe(){
        ArrayList<CarteTroupe> alct = new ArrayList<CarteTroupe>();
        int i=1;
        
        for(Troupes t : hashTroupes){
            CarteTroupe ct = new CarteTroupe(t);
            // On met 6 fois la même carte dans la liste
            for(int k=0; k<6; k++){
                alct.add(ct);
            }
            // il faut également mettre un carte avec deux troupes (en tout 6 cartes)
            int j = 1;
            for(Troupes t2 : hashTroupes){
                // On ne reprend pas les cartes précédentes (elles ont déjà ét traitées)
                if(i== j || i<j){
                    CarteTroupe ct2 = new CarteTroupe(t,t2);
                    alct.add(ct2);
                }
                j++;
            }
            i++;
        }
        // On mélange le paquet
        Collections.shuffle(alct);
        
        return alct;
    }
    
    /**
     * On créé le paquet de cartes Kokus
     * @return 
     */
    public ArrayList<Kokus> initialisationPaquetKokus(){
        ArrayList<Kokus> alk = new ArrayList<Kokus>();
        
        for(Kokus k : this.hashKokus){
            // 12 cartes kokus de 1 unité
            if(k.getNbkoku()==1){
                for(int i=0; i<12; i++){
                    alk.add(k);
                }
            }
            
             // 8 cartes kokus de 2 unités
            if(k.getNbkoku()==2){
                for(int i=0; i<8; i++){
                    alk.add(k);
                }
            }
            
             // 4 cartes kokus de 3 unités
            if(k.getNbkoku()==3){
                for(int i=0; i<4; i++){
                    alk.add(k);
                }
            }
        }
        Collections.shuffle(alk);
        
        return alk;
    }
    
}
