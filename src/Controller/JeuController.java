package Controller;

import Cryptid.Cryptid;
import Modele.Case;
import Modele.Types.Piece;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JeuController implements ActionListener, MouseListener {
     Cryptid root;

    public JeuController(Cryptid root){
        this.root = root;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(root.getPlateau().pixelToCase( mouseEvent.getPoint(), root.getPanneauJeu().getTailleCase()).toFullString() );
        Case c = root.getPlateau().pixelToCase( mouseEvent.getPoint(), root.getPanneauJeu().getTailleCase());
        Piece p = Piece.pieceSelectionnee;
        c.getPieces().add(p);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
