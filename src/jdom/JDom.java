package jdom;

import classes.*;
import java.io.File;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Damien
 */
public class JDom {
    private org.jdom2.Document document;
    private Element racine;
    
/* Constructor */
    public JDom(String url) {
        //On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();
        try {
            //On cré un nouveau document JDOM avec en argument le fichier XML
            //Le parsing est terminé ;)
            document = sxb.build(new File(url));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //On initialise un nouvel élément racine avec l'élément racine du document.
        racine = document.getRootElement();
    }
    
/* Methodes */
    
    /**
     * On initialise les généraux, les troupes, les kokus, etc...
     * @param classe (classe à initialiser)
     * @return un hashSet (pour éviter les doublons) de toutes les occurences de la classe
     */
    public Set initialisationJeu(String classe) {
        //On crée une List contenant tous les noeuds "general" de l'Element racine
        List list = null;
        switch(classe){
            case "general" : list = racine.getChildren("general");
                break;
            case "troupes" : list = racine.getChildren("troupe");
                break;
            case "bonus" : list = racine.getChildren("effet");
                break;
            case "kokus" : list = racine.getChildren("koku");
                break;
            case "province" : list = racine.getChildren("province");
                break;
            case "titre" : list = racine.getChildren("titre");
                break;
        }
        
        Set hashset = new HashSet<>();
        //On crée un Iterator sur notre liste
        Iterator i = list.iterator();
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            
            switch(classe){
                case "general" : hashset = initialisationGeneral(hashset, courant);
                    break;
                case "troupes" : hashset = initialisationTroupes(hashset, courant);
                    break;
                case "bonus" : hashset = initialisationBonus(hashset, courant);
                    break;
                case "kokus" : hashset = initialisationKokus(hashset, courant);
                    break;
                case "province" : hashset = initialisationProvince(hashset, courant);
                    break;
                case "titre" : hashset = initialisationTitre(hashset, courant);
                    break;
            }
        }
        
        return hashset;
    }
    
    public Set initialisationGeneral(Set hset, Element current){
        String nom = current.getChild("nom").getText();
        String prenom = current.getChild("prenom").getText();
        String couleur = current.getChild("couleur").getText();
        hset.add(new General(nom, prenom, couleur));
        
        return hset;
    }
    
    public Set initialisationTroupes(Set hset, Element current){
        String nom = current.getChild("nom").getText();
        String couleur = current.getChild("couleur").getText();
        hset.add(new Troupes(nom, couleur));
        
        return hset;
    }
    
    public Set initialisationBonus(Set hset, Element current){
        String effet = current.getText();
        hset.add(new Bonus(effet));
        
        return hset;
    }
    
    public Set initialisationKokus(Set hset, Element current){
        int nbkokus = Integer.parseInt(current.getText());
        hset.add(new Kokus(nbkokus));
        
        return hset;
    }
    
    public Set initialisationProvince(Set hset, Element current){
        String nom = current.getChild("nom").getText();
        int point1 = Integer.parseInt(current.getChild("point1").getText());
        int point2 = Integer.parseInt(current.getChild("point2").getText());
        int point3 = Integer.parseInt(current.getChild("point3").getText());
        int point4 = Integer.parseInt(current.getChild("point4").getText());
        int nbtroupes = Integer.parseInt(current.getChild("nbtroupes").getText());
        hset.add(new Province(nom, point1, point2, point3, point4, nbtroupes));
        
        return hset;
    }
    
    public Set initialisationTitre(Set hset, Element current){
        String nom = current.getChild("nom").getText();
        int bakufu = Integer.parseInt(current.getChild("bakufu").getText());
        String bonus = current.getChild("bonus").getText();
        hset.add(new Titre(nom, bakufu, bonus));
        
        return hset;
    }
    
}
