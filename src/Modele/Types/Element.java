package Modele.Types;

import java.util.ArrayList;
import java.util.Random;

public enum Element {
    ARBRE(Biome.PLAINE,Biome.MONTAGNE,Biome.SAVANE),
    ROCHER(Biome.OCEAN,Biome.DESERT,Biome.MONTAGNE,Biome.PLAINE,Biome.SAVANE,Biome.MARECAGES),
    DUNE(Biome.DESERT),
    CACTUS(Biome.DESERT),
    MAELSTORM(Biome.OCEAN),
    ETANG(Biome.DESERT),
    SAPIN(Biome.MONTAGNE),
    PYRAMIDE(Biome.DESERT),
    MAISON(Biome.DESERT, Biome.SAVANE, Biome.PLAINE),
    ANIMEAUX(Biome.SAVANE, Biome.PLAINE, Biome.MONTAGNE),
    BUISSONS(Biome.PLAINE, Biome.SAVANE, Biome.MONTAGNE);


    Biome[] compatibles;

    Element(Biome ... biomes){ this.compatibles = biomes; }

    public static ArrayList<Element> getRandom(){
        Random hazardeur = new Random();
        ArrayList<Element> l = new ArrayList<>();
        int n = hazardeur.nextInt(4);
        for(int i=0;i<=n;i++){
            l.add(Element.getOneRandom());
        }
        return l;
    }

    public static ArrayList<Element> getRandom(Biome b){
        ArrayList<Element> elements = getRandom();
        ArrayList<Element> elementsToReturn = new ArrayList<>();
        for(Element e : elements){
            for(Biome biome : e.compatibles){
                if(biome == b){
                    elementsToReturn.add(e);
                    break;
                }
            }
        }
        return elementsToReturn;
    }


    public static Element getOneRandom(){
        Random hazardeur = new Random();
        return Element.values()[hazardeur.nextInt(Element.values().length)];
    }
}
