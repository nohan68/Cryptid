package Modele.Types;

import java.util.Random;

public enum IndiceLieu {
    BIOME("d'un biome %s"),
    ELEMENT("d'un(e) %s");

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
