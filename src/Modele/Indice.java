package Modele;


import Modele.Types.Biome;
import Modele.Types.Element;
import Modele.Types.IndiceLieu;
import Modele.Types.IndicePosition;

import java.awt.*;
import java.util.Random;

public class Indice {
    private Plateau plateau;
    private IndicePosition iPos;
    private IndiceLieu iLieu;

    private Random hazardeur;
    private int dilution;
    private int distanceDiluee;

    private Biome biome;
    private Element element;

    private String message;

    private int distance;

    public Indice(Plateau plateau){
        this.plateau = plateau;

        iPos  = IndicePosition.getOneRandom();
        iLieu = IndiceLieu.getOneRandom();
        hazardeur = new Random();

        Case c =null;

        if(iLieu == IndiceLieu.BIOME){
            biome = Biome.getRandom();
            c = plateau.getClosestCaseFromCryptidWith(biome);
        }
        if(iLieu == IndiceLieu.ELEMENT){
            element = Element.getOneRandom();
            c = plateau.getClosestCaseFromCryptidWith(element);
        }

        distance = plateau.getDistanceFromCryptid(plateau.caseToPosition(c));
        dilution = hazardeur.nextInt(1+(int)Math.round(distance/2));

        if(distance==0)
            iPos = IndicePosition.POSITION;

        message = "Le cryptid se trouve "+iPos+" "+iLieu;

        switch (iPos){
            case MAX_DISTANCE:
                distanceDiluee = distance+dilution;
                if(iLieu == IndiceLieu.ELEMENT){
                    message = String.format(message, distance, element);
                }
                if(iLieu == IndiceLieu.BIOME){
                    message = String.format(message, distance, biome);
                }
                break;
            case MIN_DISTANCE:
                distanceDiluee = distance-dilution;
                if(iLieu == IndiceLieu.ELEMENT){
                    message = String.format(message, distance, element);
                }
                if(iLieu == IndiceLieu.BIOME){
                    message = String.format(message, distance, biome);
                }

                break;
            case POSITION:
                message = "Le cryptid se trouve à l'interieur "+iLieu;
                if(iLieu == IndiceLieu.ELEMENT){
                    message = String.format(message, plateau.getMonstreBiome());
                }
                if(iLieu == IndiceLieu.BIOME){
                    message = String.format(message, plateau.getCase(plateau.getMonstre()).getBiome());
                }
                break;

        }

    }


    @Override
    public String toString() {
        return this.message;
    }

    public boolean equals(Indice i){
        return i.iLieu == this.iLieu && i.iPos == this.iPos && this.distanceDiluee == i.distanceDiluee;
    }
}
