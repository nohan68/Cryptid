package Modele;


import Modele.Types.IndiceLieu;
import Modele.Types.IndicePosition;

import java.util.Random;

public class Indice {
    private static int MAX_DISTANCE = 5;
    private static int MIN_DISTANCE = 1;

    private Plateau plateau;
    private IndicePosition iPos;
    private IndiceLieu iLieu;

    private Random hazardeur;
    private int distance;


    public Indice(Plateau plateau){
        this.plateau = plateau;
        System.out.println("Generation d'un indice");

        iPos  = IndicePosition.getOneRandom();
        iLieu = IndiceLieu.getOneRandom();
        hazardeur = new Random();
        distance = MIN_DISTANCE+hazardeur.nextInt(MAX_DISTANCE-MIN_DISTANCE);

    }


    @Override
    public String toString() {
        String chaine = "Le monstre "+iPos+" et "+iLieu;
        return "";
    }
}
