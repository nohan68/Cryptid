import Modele.Joueur;
import Modele.Piece;
import Modele.Plateau;
import Modele.Types.TypePiece;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TestPiece {
    @Test
    public void testTypePiece(){
        String nom = "Zaid";
        Joueur j = new Joueur(nom, Color.RED);

        Piece piece = new Piece(TypePiece.PIECECUBIQUE, j);
        Assert.assertEquals(piece.getTypePiece(), TypePiece.PIECECUBIQUE);
    }

    @Test
    public void testProprietairePiece(){
        String nom = "Zaid";
        Joueur j = new Joueur(nom, Color.RED);
        Piece piece = new Piece(TypePiece.PIECECUBIQUE, j);

        Assert.assertEquals(piece.getProprietaire(), j);
    }
}