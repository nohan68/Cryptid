import Modele.Joueur;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TestJoueur {

    @Test
    public void testNomJoueur(){
        String nom = "Nohan";
        Color c = Color.BLUE;

        Joueur j = new Joueur(nom, c);
        Assert.assertEquals(j.getNom(), nom);
        Assert.assertEquals(j.getCouleur(), c);
    }

    @Test
    public void testCouleurJoueur(){
        String nom = "Zaid";
        Color c = Color.BLUE;

        Joueur j = new Joueur(nom, c);
        Assert.assertEquals(j.getCouleur(), c);
    }

    @Test
    public void testNombreJoueurs(){
        String nom1 = "Zaid";
        String nom2 = "Nohan";
        String nom3 = "Ted";

        Joueur j1 = new Joueur(nom1, Color.RED);
        Joueur j2 = new Joueur(nom2, Color.GREEN);
        Joueur j3 = new Joueur(nom3, Color.BLUE);

        Assert.assertEquals(Joueur.getNombreJoueurs(), 3);
    }
}
