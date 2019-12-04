package Modele.Types;

import java.util.Random;

public enum IndicePosition {
    MIN_DISTANCE("à %d cases ou plus"),
    MAX_DISTANCE("à %d cases ou moins"),
    POSITION("");

    String message;

    IndicePosition(String message){
        this.message = message;
    }

    public static IndicePosition getOneRandom(){
        Random hazardeur = new Random();
        return IndicePosition.values()[hazardeur.nextInt(IndicePosition.values().length)];
    }

    @Override
    public String toString(){
        return this.message;
    }
}
