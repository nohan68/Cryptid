package Controller;

import Cryptid.Cryptid;
import Cryptid.Notice;
import Modele.Case;
import Modele.Joueur;
import Modele.Piece;
import Modele.Plateau;
import Modele.Types.TypePiece;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JeuController implements ActionListener, MouseListener {
     Cryptid root;
     public Case c;

    public JeuController(Cryptid root){
        this.root = root;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        c = root.getPlateau().pixelToCase(mouseEvent.getPoint(), root.getPanneauJeu().getTailleCase());
        Plateau.setDerniereCase(c);
        if(mouseEvent.getButton() == MouseEvent.BUTTON1) {
            TypePiece tp = TypePiece.typePieceSelectionnee;
            if (c.getPieces(Joueur.getJoueurActuel()).size() < 1) {
                c.addPiece(new Piece(tp, Joueur.getJoueurActuel()));
                if(tp == TypePiece.PIECERONDE){
                    if(root.getPlateau().verifDistanceAvecMonstre(Plateau.getDerniereCase())){
                        System.out.println("trouvé");
                        new Notice(Joueur.getJoueurActuel(), "Le joueur " + Joueur.getJoueurActuel().getNom() + " remporte à trouvé le monstre. Il remporte la partie !", 1);
                        root.bPieceCubique.setEnabled(false);
                        root.bPieceRonde.setEnabled(false);
                        root.bPasserTour.setEnabled(false);
                        TypePiece.typePieceSelectionnee = TypePiece.PIECECUBIQUE;
                    }

                    else if(!root.getPlateau().verifDistanceAvecMonstre(Plateau.getDerniereCase())){
                        System.out.println("raté");
                        new Notice("C'est raté !");
                    }
                }
            }
            System.out.println(root.getPlateau().pixelToCase(mouseEvent.getPoint(), root.getPanneauJeu().getTailleCase()).toFullString());
        }

        if(mouseEvent.getButton() == MouseEvent.BUTTON3){
            c.delPiece(c.getPieces(Joueur.getJoueurActuel()));
        }
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
