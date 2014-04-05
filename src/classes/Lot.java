package classes;

import java.util.*;
/**
 *
 * @author Damien
 * @version 1.0
 */
public class Lot {
    ArrayList<CarteTroupe> alct;
    ArrayList<Kokus> alk;
    Titre titre;
    Set<Joueur> sjoueur;
    
/* Constructeurs */
    
    public Lot() {
        this.alct = new ArrayList<CarteTroupe>();
        this.alk = new ArrayList<Kokus>();
        this.sjoueur = new HashSet<Joueur>();
    }

    
    public Lot(ArrayList<CarteTroupe> alct, ArrayList<Kokus> alk) {
        this.alct = alct;
        this.alk = alk;
        this.sjoueur = new HashSet<Joueur>();
    }
    
    public Lot(ArrayList<CarteTroupe> alct, ArrayList<Kokus> alk, Set<Joueur> sjoueur) {
        this.alct = alct;
        this.alk = alk;
        this.sjoueur = sjoueur;
    }
    
/* Getters & Setters */
    public ArrayList<CarteTroupe> getAlct() {
        return alct;
    }

    public void setAlct(ArrayList<CarteTroupe> alct) {
        this.alct = alct;
    }

    public ArrayList<Kokus> getAlk() {
        return alk;
    }

    public void setAlk(ArrayList<Kokus> alk) {
        this.alk = alk;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }
    
    
/* Methodes */
    @Override
    public String toString() {
        return new String(new StringBuilder().append(alct).append("\n").append(alk).append("\n").append(this.titre));
    }
    
    /**
     * Fonction qui vérifie que la saisie à bien retournée 'oui' ou 'non'
     * Dans le cas contraire, on redemande la saisie
     * @return 
     */
    public String ouiOuNon(){
        Scanner sc = new Scanner(System.in);
        String reponse = new String();
        
        do{
            reponse = sc.nextLine();
            if(!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")){
                System.err.println("Merci de bien vouloir répondre à la question par 'oui' ou 'non' !");
            }
        }while(!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non"));
        
        return reponse;
    }
   
    /**
     * Fonction qui vérifie quel joueur va recevoir le lot
     * @param hjoueur
     * @param tairo
     * @return 
     */
    public Joueur joueurQuiRecoitLot(Set<Joueur> hjoueur, Tairo tairo){  
        boolean trouve = false;
        int successeur = tairo.getTairo().getTitre().getNbsceaux()-1;
        
        // On ne peut décrémenter de 1 direct car si le tairo à 4sceaux et son successeur 2, il y a problème
        while((successeur > 0)){
            for(Joueur j : hjoueur){
                if(j.getTitre().getNbsceaux() == successeur){
                    return j;
                }
            }
            successeur--;
        }
        return null;
    } 
    
    /**
     * Fonction qui vérifie l'existence d'une carte selon son type donnée en paramètre
     * @param carte
     * @param typeCarte
     * @return true si la carte existe, false sinon
     */
    public boolean verifieExistenceCarte(String carte, String typeCarte){
        // On vérifie que la carte est une koku et qu'elle existe
        // Sinon il s'agit d'un carte troupe
        if(typeCarte.equals("koku")){
            for(Kokus k : this.getAlk()){
                if(carte.contains(Integer.toString(k.getNbkoku()))){
                    return true;
                }
            }
        }
        else{
            boolean existe = false;            
            // Traitement de vérification s'il s'agit d'une carte avec deux troupes
            if(carte.contains("&")){
                String[] split = carte.split("&"); // Retourne un tableau du type ||Troupe1|Troupe2||
                for(CarteTroupe ct : this.getAlct()){
                    if((split[0].trim().equalsIgnoreCase(ct.getTroupe1().getNom())) && (!existe)){
                        existe = true;
                    }
                    if((ct.getTroupe2()!=null) && (split[1].trim().equalsIgnoreCase(ct.getTroupe2().getNom())) && existe){
                        return true;
                    }
                } 
            } 
            else{ // Il s'agit d'une carte troupe simple
                for(CarteTroupe ct : this.alct){
                    if(carte.equalsIgnoreCase(ct.getTroupe1().getNom())){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Fonction qui convertit une chaine de caractères en Carte Kokus
     * @param carte nom de la carte
     * @return carte kokus
     */
    public Kokus convertirStringEnCarteKokus(String carte){      
        for(Kokus koku : this.alk){
            if(carte.contains(Integer.toString(koku.getNbkoku()))){
                return koku;
            }
        }
        return null;
   }
    
    /**
     * Fonction qui convertit une chaine de caractères en CarteTroupe
     * @param carte
     * @return 
     */
    public CarteTroupe convertirStringEnCarteTroupe(String carte){
        boolean presque = false;
        if(carte.contains("&")){
            String[] split = carte.split("&");
            for(CarteTroupe ct : this.alct){
                if(split[0].trim().equalsIgnoreCase(ct.getTroupe1().getNom()) && (!presque)){
                    presque = true;
                }
                
                if((ct.getTroupe2() != null) && (split[1].trim().equalsIgnoreCase(ct.getTroupe2().getNom())) && presque){
                    return ct;
                }
                presque = false;
            }
        }
        else{
            for(CarteTroupe ct : this.alct){
                if(carte.equalsIgnoreCase(ct.getTroupe1().getNom())){
                    return ct;
                }
            }
        }
        return null;
   }
    
    
    public Titre choixTuileHierarchie(ArrayList<Titre> altitre){
        Scanner sc = new Scanner(System.in);
        String reponse = new String();
        
        while(true){
            System.out.println("\nQuelle tuile Hiérarchie voulez-vous associer à ce lot ? ");
            System.out.println(altitre);
            reponse = sc.nextLine();

            for(Titre t : altitre){
                if(t.getNom().equalsIgnoreCase(reponse)){
                    altitre.remove(t);
                    return t;
                }
            }
            System.err.println("Ce titre n'existe pas ! Merci d'en choisir un vrai !");
        }
    }
    
    /**
     * Composition d'un lot avec saisie manuelle des cartes troupes et kokus
     * + Vérification d'existence de ces cartes
     * @return 
     */
    public Lot compositionDuLot(ArrayList<Titre> altitre){
        Scanner sc = new Scanner(System.in);
        ArrayList<CarteTroupe> tempct = new ArrayList<CarteTroupe>();
        ArrayList<Kokus> tempk = new ArrayList<Kokus>();
        String reponse = new String();
        Lot lot = new Lot();
        boolean existe = false, fin = false;
        
        // Choix des cartes troupes à soumettre
        System.out.print("Voulez-vous mettre des cartes Troupes dans le lot ? ");
        reponse = ouiOuNon();
        if(reponse.equalsIgnoreCase("oui")){
            while(!fin){
                System.out.println("\nListe des cartes troupes à donner :  " + this.alct.toString());
                System.out.print("Nom de la carte 'Troupes' à sélectionner : ");
                reponse = sc.nextLine();
                
                // Soit on arrete la saisie des cartes troupes, soit on vérifie que la carte choisie existe bien
                if(reponse.equalsIgnoreCase("fin")){
                    fin = true;
                }
                else{
                    existe = verifieExistenceCarte(reponse, "troupe");
                    if(existe){
                        CarteTroupe tmp = convertirStringEnCarteTroupe(reponse);
                        tempct.add(tmp);
                        this.alct.remove(tmp);
                    }
                    else{
                        System.err.println("Cette carte n'existe pas !!!");
                    }
                }
            }
        }
        
        fin = false;
        reponse = "";
        existe = false;
        // Choix des cartes kokus à soumettre
        System.out.print("Voulez-vous mettre des cartes Kokus dans le lot ? ");
        reponse = ouiOuNon();
        if(reponse.equalsIgnoreCase("oui")){
           
            while(!fin){
                System.out.println("\nListe des cartes Kokus à distribuer : " + this.alk.toString());
                System.out.print("Indiquer le nombre de kokus qu'a la carte choisie : ");
                reponse = sc.nextLine();
                // Soit on arrete la saisie des cartes troupes, soit on vérifie que la carte choisie existe bien
                if(reponse.equalsIgnoreCase("fin")){
                    fin = true;
                }
                else{
                    existe = verifieExistenceCarte(reponse, "koku");
                    if(existe){
                        Kokus tmp = convertirStringEnCarteKokus(reponse);
                        tempk.add(tmp);
                        this.alk.remove(tmp);
                    }
                    else{
                        System.err.println("Cette carte n'existe pas !!!");
                    }
                }
            }
        }
        // On met les cartes troupes sélectionnées dans le vrai lot
        if(tempct.size() > 0 ){lot.setAlct(tempct);}
        else{lot.setAlct(null); }
        // On met les cartes kokus sélectionnées dans le vrai lot
        if(tempk.size() > 0 ){lot.setAlk(tempk);}
        else{lot.setAlk(null); }
        // On choisit la tuile de hiérarchie à affectuer au lot
        lot.setTitre(choixTuileHierarchie(altitre));
        
        return lot;
    }
    
    
}
