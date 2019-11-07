package Modele;

import java.util.Random;

public enum Biome {
    OCEAN,
    DESERT,
    PLAINE,
    MONTAGNE,
    MARECAGES,
    SAVANE;

    public static Biome getRandom(){
        Random hazardeur = new Random();
        return Biome.values()[hazardeur.nextInt(Biome.values().length)];
    }
}
