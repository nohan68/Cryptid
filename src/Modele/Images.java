package Modele;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images
{
    public static Image imgArbre;
    public static Image imgBuisson;
    public static Image imgCactus;
    public static Image imgDune;
    public static Image imgMaelstorm;
    public static Image imgMaison;
    public static Image imgPyramide;
    public static Image imgRocher;
    public static Image imgSapin;
    public static Image imgAnimaux;
    public static Image imgEtang;
    static {
        try {
            imgArbre = ImageIO.read(new File("src/Ressources/arbre.png"));
            imgBuisson = ImageIO.read(new File("src/Ressources/buisson.png"));
            imgCactus = ImageIO.read(new File("src/Ressources/cactus.png"));
            imgDune = ImageIO.read(new File("src/Ressources/dune.png"));
            imgMaelstorm = ImageIO.read(new File("src/Ressources/maelstorm.png"));
            imgMaison = ImageIO.read(new File("src/Ressources/maison.png"));
            imgPyramide = ImageIO.read(new File("src/Ressources/pyramide.webp"));
            imgRocher = ImageIO.read(new File("src/Ressources/rocher.png"));
            imgSapin = ImageIO.read(new File("src/Ressources/sapin.webp"));
            imgAnimaux = ImageIO.read(new File("src/Ressources/animaux.png"));
            imgEtang = ImageIO.read(new File("src/Ressources/etang.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
