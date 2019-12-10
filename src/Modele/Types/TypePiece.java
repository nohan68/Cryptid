package Modele.Types;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public enum TypePiece implements Icon {
    PIECECUBIQUE("../Ressources/cube.png"),
    PIECERONDE("../Ressources/rond.png");

    public static TypePiece typePieceSelectionnee = PIECECUBIQUE;

    private final BufferedImage image;

    TypePiece(String filename) {
        BufferedImage tempImage;
        try {
            tempImage = ImageIO.read(new File(filename));
        } catch (Exception e) {
            tempImage = null;
        }
        image = tempImage;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawImage(image, 5, 5, null);
    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }
}