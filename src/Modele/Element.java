package Modele;

import java.util.ArrayList;
import java.util.Random;

public enum Element {
    ARBRE,
    ROCHER,
    DUNE,
    CACTUS,
    MAELSTORM,
    ETANG,
    SAPIN,
    PYRAMIDE,
    MAISON,
    ANIMEAUX,
    BUISSONS;

    public static ArrayList<Element> getRandom(){
        Random hazardeur = new Random();
        ArrayList<Element> l = new ArrayList<>();
        int n = hazardeur.nextInt(4);
        for(int i=0;i<=n;i++){
            l.add(Element.getOneRandom());
        }
        return l;
    }

    private static Element getOneRandom(){
        Random hazardeur = new Random();
        return Element.values()[hazardeur.nextInt(Element.values().length)];
    }
}
