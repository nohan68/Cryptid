import Modele.Joueur;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TestJoueur {

    @Test
    public void testJoueur(){
        String nom = "Nohan";
        Color c = Color.BLUE;

        Joueur j = new Joueur(nom, c);
        Assert.assertEquals(j.getNom(), nom);
        Assert.assertEquals(j.getCouleur(), c);
    }

    @Test
    public void testjoueurAGangne(){
        String nom = "Zaid";
        Color c = Color.RED;

        Joueur j = new Joueur(nom, c);
    }
}
