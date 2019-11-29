package Modele.Types;

import java.util.Random;

public enum IndiceLieu {
    AUCUN(""),
    BIOME("d'un biome {1}"),
    ELEMENT("d'un(e){1}");

    String message;

    IndiceLieu(String message){
        this.message = message;
    }

    public static IndiceLieu getOneRandom(){
        Random hazardeur = new Random();
        return IndiceLieu.values()[hazardeur.nextInt(IndiceLieu.values().length)];
    }

    @Override
    public String toString(){
        return this.message;
    }
}
