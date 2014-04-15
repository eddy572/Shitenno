package classes;

import java.util.*;
/**
 *
 * @author Damien
 * @version 1.0
 */
public class Joueur implements Comparable<Joueur>{
    private String pseudo;
    private int score;
    private General general;
    private int nbkamons;
    private ArrayList<CarteTroupe> alctroupe;
    private ArrayList<Kokus> alkokus;
    private ArrayList<Bonus> albonus;
    private Titre titre;
    private Titre hierarchie;

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
        this.albonus = new ArrayList<Bonus>();
        this.titre = null;
    }

    public Joueur(String pseudo, int nbkamons) {
        this.pseudo = pseudo;
        this.nbkamons = nbkamons;
        this.general = null;
        this.score = 0;
        this.alctroupe = new ArrayList<CarteTroupe>();
        this.alkokus = new ArrayList<Kokus>();
        this.albonus = new ArrayList<Bonus>();
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

    public Titre getHierarchie() {
        return hierarchie;
    }

    public void setHierarchie(Titre hierarchie) {
        this.hierarchie = hierarchie;
    }

    public ArrayList<Bonus> getAlbonus() {
        return albonus;
    }

    public void setAlbonus(ArrayList<Bonus> albonus) {
        this.albonus = albonus;
    }
    
    
    
/* HashCode & Equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pseudo);
        hash = 97 * hash + this.score;
        hash = 97 * hash + Objects.hashCode(this.general);
        hash = 97 * hash + this.nbkamons;
        hash = 97 * hash + Objects.hashCode(this.alctroupe);
        hash = 97 * hash + Objects.hashCode(this.alkokus);
        hash = 97 * hash + Objects.hashCode(this.albonus);
        hash = 97 * hash + Objects.hashCode(this.titre);
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
        if (!Objects.equals(this.albonus, other.albonus)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.hierarchie, other.hierarchie)) {
            return false;
        }
        return true;
    }

/* Methods */   
    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", score=" + score + ", general=" + general + ", nbkamons=" + nbkamons + ", alctroupe=" + alctroupe + ", alkokus=" + alkokus + ", albonus=" + albonus + ", titre=" + titre + ", hierarchie=" + hierarchie + '}';
    }

    @Override
    public int compareTo(Joueur j) {
        if(this.getTitre().getNbsceaux() < j.getTitre().getNbsceaux())
            return 1;
        if(this.getTitre().getNbsceaux() > j.getTitre().getNbsceaux())
            return -1;
        return 0;
    }
   
    /**
     * Retourn le nombre de Kamon que chaque joueur doit avoir en début de partie
     * Le nombre se calcul selon le nombre de joueur
     * @param nbjoueur nombre de joueur dans la partie
     * @return nbkamons nombre de kamons par joueur
     */
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
    
    /**
     * Compte le nombre de cartes qu'un joueur a en main
     * @return 
     */
    public int nombreDeCartesEnMain(){
        return this.alctroupe.size() + this.alkokus.size();
    }
    
    /**
     * Fonction qui vérifie la saisie et la redemande si le mot inscrit est différent de 'accepter' ou 'refuser'
     * @return le mot saisie correctement
     */
    public String accepterOuRefuser(){
        Scanner sc = new Scanner(System.in);
        String rep = new String();
        
        while(!rep.equalsIgnoreCase("accepter") && !rep.equalsIgnoreCase("refuser")){
            System.out.println("");
            System.out.print("Désirez-vous l'accepter ou le refuser ? ");
            rep = sc.next();
            if(!rep.equalsIgnoreCase("accepter") && !rep.equalsIgnoreCase("refuser")){System.err.println("Seul les mot 'accepter' et 'refuser' sont autorisés ! ");}
        }
        return rep;
    } 
    
    /**
     * Fonction qui ajoute les cartes du lot soumis à la main du joueur, ainsi que la tuile de hiérarchie 
     * et enlève la tuile titre
     * @param lot 
     */
    public void cartesAcceptees(Lot lot){
        // On ajoute les nouvelles cartes à la main et on les tries
        if (lot.getAlct() != null) {
            this.alctroupe.addAll(lot.getAlct());
        }
        if (lot.getAlk() != null) {
            this.alkokus.addAll(lot.getAlk());
            Collections.sort(this.alkokus);
        }
        // On affecte la tuile hiérachie du lot
        this.hierarchie = lot.getTitre();
        // On retire la tuile titre pour ne pas reproser le lot
        this.titre = null;
    }
    
    /**
     * Fonction qui ajoute les cartes du lot soumis par le tairo, aux cartes que le joueur a déjà en main
     * Ou affiche un message si le joueur a refusé le lot.
     * @param tairo
     * @param lot
     * @return 
     */
    public String accepterRefuserLot(Joueur tairo, Lot lot){
        System.out.println(this.pseudo + ", votre Tairo " + tairo.getPseudo() + " vous propose le lot suivant : ");
        System.out.println(lot.toString());
        String rep = this.accepterOuRefuser();
        
        if(rep.equalsIgnoreCase("accepter")){
            System.out.println("");
            System.out.println("Vous venez d'accepter le lot !");
            System.out.println("Voici votre nouvelle main : ");
            // On met à jours les cartes dans la main du joueur
            this.cartesAcceptees(lot);
            // On affiche la nouvelle main et le nouveau titre
            System.out.println(this.alctroupe.toString());
            System.out.println(this.alkokus);
            System.out.println("Et vous passerez " + this.hierarchie + " à la fin de l'année.");
        }
        else{
            System.out.println("");
            System.out.println("Vous venez de refuser le lot ! Impossible de revenir sur votre décision !");
        }
        
        return rep;
    }
    
    /**
     * Echange les tuiles titres en fonction des tuiles hiérarchie
     * A ne lancer qu'une fois tout les lots formés
     * Hierarchie devient à null
     */
    public void changerHierachieEnTitre(){
        this.titre = this.hierarchie;
        this.hierarchie = null;
    }

    /**
     * On vérifie la saisie quand au fait de vouloir envahir une province ou de vouloir passer son tour
     * @return rep qui est la réponse donnée (passer ou envahir)
     */
    public String envahirOuPasser(){
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        boolean envahir = rep.equalsIgnoreCase("envahir");
        boolean passer = rep.equalsIgnoreCase("passer");
        
        while(!envahir && !passer){
            System.err.print("Merci de faire votre choix parmi les deux possibles (Envahir ou Passer votre tour) : ");
            rep = sc.nextLine();
            envahir = rep.equalsIgnoreCase("envahir");
            passer = passer = rep.equalsIgnoreCase("passer");
        }
        
        return rep.toLowerCase();
    }
    
    /**
     * On demande le nom de la province à contrôler
     * Et on vérifie que celle-ci existe, sinon on redemande la saisie.
     * @return s le nom de la province
     */
    public Province demandeProvinceAControler(){
        Scanner sc = new Scanner(System.in);
        String s = new String();
        boolean stop = false;
        Initialisation init = new Initialisation();
        
        while(!stop){
            s = sc.nextLine();
            for(Province p : init.getHashProvince()){
                if(p.getNom().equalsIgnoreCase(s)){
                    return p;
                }
            }
            if(!stop){
                System.err.println("Cette province n'est pas connue de nos services !");
                System.err.print("Veuillez en saisir une de connue : ");
            }
        }
        
        return null;
    }
    
    /**
     * On vérifie que le joueur voulant prendre une province a bien les troupes nécessaires 
     * On vérifie donc en fonction de la tuile bonus, des troupes et du nombre de celles-ci
     * @param p
     * @return 
     */
    public boolean aLesTroupesNecessaires(Province p){
        int nbTroupes = p.getNbtroupes();
        Troupes troupe = p.getTroupe();
        TuileBonus tb = p.bonusCommeTroupe();
        int cpt = 0;
        
        // On ne vérifie la présence des cartes que si la liste n'est pas vide
        if(!this.alctroupe.isEmpty()){
            // On compte le nombre de carte troupe ayant la troupe nécessaire à la prise de contrôle
            for(CarteTroupe ct : this.alctroupe){
                if(ct.getTroupe2() == null){
                    if(ct.getTroupe1().equals(troupe)){
                        System.out.println("TROUPE : " + ct.toString());
                        cpt++;
                    }
                }
                else{
                    if(ct.getTroupe1().equals(troupe) || ct.getTroupe2().equals(troupe)){
                        System.out.println("TROUPESS : " + ct.toString());
                        cpt++;
                    }
                    if(ct.getTroupe1().equals(troupe) && ct.getTroupe2().equals(troupe)){
                        System.out.println("TROUPEAC : " + ct.toString());
                        cpt++;
                    }
                }
            }
            // On retourne vrai s'il n'y a pas de tuileBonus et que le joueur a assez de troupes
            if(tb == null && (cpt > nbTroupes || cpt == nbTroupes)){
                return true;
            }
            
            // S'il y a une tuile bonus dans la province, il faut que la joueur ait au moins nb - 1 troupes
            // et la troupe correspondant à la tuile bonus
            if(tb != null && (cpt > nbTroupes-1 || cpt == nbTroupes-1)){
                for(CarteTroupe ct : this.alctroupe){
                    if(ct.getTroupe2() == null){
                        if(ct.getTroupe1().equals(tb.getTroupe())){
                            System.out.println("TROUPETB : " + ct.toString());
                            return true;
                        }
                    }
                    else{
                        if(ct.getTroupe1().equals(tb.getTroupe()) || ct.getTroupe2().equals(tb.getTroupe())){
                            System.out.println("TROUPETTBB : " + ct.toString());
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Vérifie l'existence d'une carte troupe dans la main du joueur
     * @param carte nom de la carte troupe à vérifieé
     * @return true si la carte existe dans sa main, false sinon
     */
    public boolean verifExistenceCarte(String carte){
        boolean existe = false;            
        // Traitement de vérification s'il s'agit d'une carte avec deux troupes
        if (carte.contains("&")) {
            String[] split = carte.split("&"); // Retourne un tableau du type ||Troupe1|Troupe2||
            for (CarteTroupe ct : this.alctroupe) {
                if ((split[0].trim().equalsIgnoreCase(ct.getTroupe1().getNom())) && (!existe)) {
                    existe = true;
                }
                if ((ct.getTroupe2() != null) && (split[1].trim().equalsIgnoreCase(ct.getTroupe2().getNom())) && existe) {
                    return true;
                }
            }
        } 
        else { // Il s'agit d'une carte troupe simple
            for (CarteTroupe ct : this.alctroupe) {
                if (carte.equalsIgnoreCase(ct.getTroupe1().getNom()) && ct.getTroupe2() == null) {
                    return true;
                }
            }
        }
        return false;
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
            for(CarteTroupe ct : this.alctroupe){
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
            for(CarteTroupe ct : this.alctroupe){
                if(carte.equalsIgnoreCase(ct.getTroupe1().getNom()) && ct.getTroupe2() == null){
                    return ct;
                }
            }
        }
        return null;
   }
    
    /**
     * On demande au joueur la(les) cartes dont il souhaite se défausser pour prendre
     * le contrôle d'une province.
     * @return s, le nom de la carte troupe
     */
    public CarteTroupe demandeCarteTroupeADefausser(){
        Scanner sc = new Scanner(System.in);
        String s = new String();
        Lot l = new Lot();
        boolean existe = false;
        
        while(!existe){
            System.out.print("De quelle carte Troupe voulez-vous vous défausser ? ");
            s = sc.nextLine();
            existe = verifExistenceCarte(s);
            if(!existe){
                System.err.println("Vous ne possédez pas cette carte !");
            }
        }
        return convertirStringEnCarteTroupe(s);
    }
    
    /**
     * On vérifie que la carte troupe choisit a bien une troupe en adéquation avec celle de la province
     * @param ct carte troupe à vérifier
     * @param p province dans laquelle on vérifie si la carte troupe peut-être jouée
     * @return true si la carte peut-être jouée, false sinon
     */
    public boolean rapportCarteTroupeProvince(CarteTroupe ct, Province p){
        // Retourne true s'il s'agit d'une carte unitroupe et qu'elle correspond à la troupe de la province
        if(ct != null){System.out.println("C'est pas nul mon pote !!! ");}
        else{ System.out.println("Y a un putain de problème !!! ");}
        
        if(ct != null){
            if(ct.getTroupe2() == null && ct.getTroupe1().equals(p.getTroupe())){
                System.out.println("P : Troupe 2 == NULL");
                return true;
            }
            // Retourne si la carte comprend deux troupes et que l'une d'elles correspond à la troupe de la province
            if(ct.getTroupe2() != null && (ct.getTroupe1().equals(p.getTroupe()) || ct.getTroupe2().equals(p.getTroupe()))){
                System.out.println("P : Troupe 2 != NULL");
                return true;
            }
            System.err.println("Cette carte ne peut pas être utilisée pour prendre le contrôle de cette province !");
        }
        return false;
    }
    
    public boolean rapportCarteTroupeProvince(CarteTroupe ct, TuileBonus tb){
        // Retourne true s'il s'agit d'une carte unitroupe et qu'elle correspond à la troupe de la province
        if(ct != null){
            if(ct.getTroupe2() == null && ct.getTroupe1().equals(tb.getTroupe())){
                System.out.println("TB : Troupe 2 == NULL");
                return true;
            }
            // Retourne si la carte comprend deux troupes et que l'une d'elles correspond à la troupe de la province
            if(ct.getTroupe2() != null && (ct.getTroupe1().equals(tb.getTroupe()) || ct.getTroupe2().equals(tb.getTroupe()))){
                System.out.println("TB : Troupe 2 != NULL");
                return true;
            }
            System.err.println("Cette carte ne peut pas être utilisée pour prendre le contrôle de cette province !");
        }
        return false;
    }
    
    /**
     * Indique le nombre de carte troupe équivalente à celle passée en paramètre on veut supprimer de la main du joueur. 
     * Le nombre doit être compris entre 0 et le maximum de carte troupes (si ce max est inférieur au nombre de troupe
     * dans la province).
     * Sinon égale au nombre de troupes dans la province
     * @param ct carte troupe dont on a besoin pour prendre le contrôle
     * @return nb le nombre de cartes 'xxx' à défausser.
     */
    public int nombreCarteTroupeADefausser(CarteTroupe ct, int nbMax){
        Scanner sc = new Scanner(System.in);
        int nb = 0;
        int cpt = 0;
        boolean isNumber = false;
        // On compte le nombre d'occurence de la carte dans la main du joueur
        for(CarteTroupe ctr : this.alctroupe){
            if(ctr.equals(ct)){cpt++;}
        }
        // On fixe le nombre max de carte à retirer au nombre de troupes max dans la province (si trop de cartes en mains)
        // Ou au nombre de carte en main sinon (on ne peut en choisir plus qu'on en a).
        if(nbMax > cpt){ nbMax = cpt;}
        // On redemande le choix si la saisie n'est pas un entier
        while(!isNumber){
            try{
                System.out.print("De combien de cartes troupes '" + ct.toString() + "' voulez-vous vous défausser ?" );
                isNumber = true;
                nb = sc.nextInt();

                if (nb < 1 || nb > nbMax) {
                    System.err.println("Vous ne pouvez vous défausser de plus de cartes que vous en n'avez !");
                    isNumber = false;
                }

            } catch (InputMismatchException e) {
                System.err.println("Vous n'avez pas saisie un nombre entier !");
                sc.next();
                isNumber = false;
            }
        }
        return nb;
    }
    
    /**
     * On cherche à savoir s'il s'agit d'une carte double troupe et si elle satisfait
     * aux conditions de la tuile bonus et d'une troupe de la province
     * @param p province à prendre en compte
     * @param ct carte troupe à vérifier
     * @return true si la carte satisfait la tuile bonus et une troupe
     */
    public boolean satisfaitBonusEtTroupe(Province p, CarteTroupe ct){
        TuileBonus tb = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast();
        
        if(rapportCarteTroupeProvince(ct, p) && rapportCarteTroupeProvince(ct, tb)){
            // Troupe 1 = troupe province & Troupe 2 = troupe bonus
            if(ct.getTroupe1().equals(p.getTroupe()) && ct.getTroupe2().equals(tb.getTroupe())){
                return true;
            }
            // Troupe 1 = troupe province & Troupe 2 = troupe bonus
            if(ct.getTroupe2().equals(p.getTroupe()) && ct.getTroupe1().equals(tb.getTroupe())){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * On cherche à savoir si la carte troupe choisi est utilisée par la tuile bonus ou non
     * @param p
     * @param ct
     * @return true si oui, false sinon
     */
    public boolean satisfaitBonus(Province p, CarteTroupe ct){
        TuileBonus tb = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast();
        // Carte Troupe simple
        if(ct.getTroupe2() == null){
            if(ct.getTroupe1().equals(tb.getTroupe())){
                return true;
            }
        }
        else{
            if(ct.getTroupe1().equals(tb.getTroupe()) || ct.getTroupe2().equals(tb.getTroupe())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * On cherche à savoir si la carte troupe choisie est utilisée par la troupe de la province ou non
     * @param p
     * @param ct
     * @return true si oui, false sinon
     */
    public boolean satisfaitTroupe(Province p, CarteTroupe ct){
        if(ct.getTroupe2() == null){
            if(ct.getTroupe1().equals(p.getTroupe())){
                return true;
            }
        }
        else{
            if(ct.getTroupe1().equals(p.getTroupe()) || ct.getTroupe2().equals(p.getTroupe())){
                return true;
            }
        }
        return false;
    }
    
    public int troupeCompteDouble(Province p, CarteTroupe ct){
        if(ct.getTroupe1().equals(p.getTroupe()) && ct.getTroupe2().equals(ct.getTroupe1())){
            return 2;
        }
        return 1;
    }
    
    /**
     * On se défausse des cartes troupes choisit et selon leur nombre.
     * Ces cartes se retrouvent alors dans une pioche de défausse. 
     * Cette pioche est nécessaire dans le cas où il n'y a plus de cartes troupes sur le plateau
     * @param p
     * @return 
     */   
    public LinkedList<CarteTroupe> defausserLesTroupes(Province p){
        LinkedList<CarteTroupe> llct = new LinkedList<>();
        CarteTroupe ct = null;
        TuileBonus tb = p.getLltuilebonus().isEmpty() ? null : p.getLltuilebonus().getLast();
        int nbADefausser = 1, nbTotal = p.getNbtroupes();
        boolean isBonus = false, satisfait = false, satisfaitTroupe = false;

        // On répète les actions suivantes jusqu'à ce qu'on ai engagé toutes les troupes nécessaires pour contrôler la province
        while(nbTotal > 0){
            nbADefausser = 1;
            satisfait = false;
            satisfaitTroupe = false;
            isBonus = false;
            
            // On demande au joueur la carte qu'il veut jouer jusqu'à ce que la carte ait une troupe en adéquation avec celle de la province ou de la tuile bonus
            while(!rapportCarteTroupeProvince(ct, p) && !rapportCarteTroupeProvince(ct, tb)){
                ct = demandeCarteTroupeADefausser();
                if(!rapportCarteTroupeProvince(ct, p) && !rapportCarteTroupeProvince(ct, tb)){
                    System.err.println("C'est pas avec cette carte que tu vas prendre le contrôle man ! ");
                }
            }
            
            // On voit si la carte est une carte double et si elle peut servir pour la tuile bonus et une troupe
            satisfait = satisfaitBonusEtTroupe(p, ct);
            // Si la carte ne satisfait pas ET le bonus ET la troupe de la province, on regarde si elle vérifie au moins les troupes de la province
            if(!satisfait){ satisfaitTroupe = satisfaitTroupe(p, ct); }
            else{nbTotal -= 2; nbADefausser = 1;}
            // Si la carte ne satisfait ni la combinaison des deux, ni les troupes alors elle satisfait la tuile bonus
            if(!satisfait && !satisfaitTroupe){ isBonus = true; }
            if(!satisfaitTroupe){
                // On retire deux troupes si c'est une carte troupe double avec 2x la même troupe
                // Et une seule troupe si sur la carte seule une des deux troupes est utilisable
                if(troupeCompteDouble(p, ct) > 1){nbTotal -= troupeCompteDouble(p, ct);}
            }
            
            // Si on n'a qu'une seule troupe, on demande le nombre de carte à défausser (pour cette troupe)
            // Si c'est une carte avec 2 troupe, on ne l'a qu'une fois au max, donc pas besoin de saisie.
            if(ct.getTroupe2() == null && !isBonus){
                nbADefausser = nombreCarteTroupeADefausser(ct, nbTotal);
                nbTotal -= nbADefausser;
            }
            
            // On ajoute la carte à la liste de défausse et on l'enlève de la main du joueur
            if(nbADefausser > 1){
                for (int i = 0; i < nbADefausser; i++) {
                    llct.add(ct);
                    this.alctroupe.remove(ct);
                }
            }
            else{
                llct.add(ct);
                this.alctroupe.remove(ct);
            }
        }
        return llct;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Lance les fonctions pour passer son tour ou prendre le contrôle d'une province
     * Ceci est itéré 3 fois au maximum.
     */
    public void jouer(LinkedList<CarteTroupe> llct){
        int i = 0;
        String rep = new String();
        // Il peut jouer tant qu'il n'a pas encore posé trois kamons et qu'il ne choisit pas de passer
        while(i < 3 && !rep.equals("passer")){
            System.out.print(this.pseudo + ", désirez-vous passer votre tour ou envahir une province ? ");
            // Soit on décide contrôler une province, soit on passe son tour
            rep = envahirOuPasser();
            // On applique les fonctions nécessaires si on désire contrôler une province
            if(rep.equals("envahir")){
                System.out.print("Quelle province voulez-vous contrôler ? ");
                Province p = demandeProvinceAControler();
                // On ne peut défausser que si le joueur a les troupes requises
                if(aLesTroupesNecessaires(p)){
                    llct.addAll(defausserLesTroupes(p));
                }
                else{
                    System.out.println("Vous n'avez pas les troupes nécessaires pour attaquer cette province ! ");
                }
            } 
            i++;
        }
        
        // Affichage des messages de fin de tour
        if(rep.equals("passer")){
            System.out.println(this.pseudo + ", vous avez décidé de passer votre tour !");
        }
        if(i == 3){
            System.out.println("Vous venez d'atteindre le nombre maximal de Kamons posés. Votre tour est fini ! ");
        }
    }
}
