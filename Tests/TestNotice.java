import Cryptid.Notice;
import Modele.Indice;
import Modele.Joueur;
import Modele.Plateau;
import org.junit.Test;

import java.awt.*;

public class TestNotice {

    public static void main(String args[]){
        Joueur j = new Joueur("Nohan", Color.YELLOW);
        Plateau p = new Plateau(12);
        j.donnerIndice(new Indice(p));
        j.donnerIndice(new Indice(p));
        j.donnerIndice(new Indice(p));
        j.donnerIndice(new Indice(p));
        new Notice(j);
        new Notice("Bienvenue à la chasse au crytid");
    }
}
