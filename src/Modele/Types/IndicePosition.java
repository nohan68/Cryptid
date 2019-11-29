package Modele.Types;

import java.util.Random;

public enum IndicePosition {
    AUCUN(""),
    MIN_DISTANCE("est à plus de {0} cases"),
    MAX_DISTANCE("est à moins de {0} cases"),
    POSITION("est dans {0}");

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
