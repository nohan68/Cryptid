package Controller;

import Cryptid.Cryptid;
import Modele.Indice;
import Modele.Joueur;
import Cryptid.Notice;
import Modele.Types.TypePiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuController implements ActionListener {
    Cryptid root;
    TypePiece p;

    int tempNombreJoueur = 0;

    public MenuController(Cryptid root){
        this.root = root;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            if (e.getSource() == root.bJouer) {
                root.fPrincipale.remove(root.fMenu);
                root.fPrincipale.add(root.fConfig);
                root.revalidate();
            }

            if (e.getSource() == root.bAddJoueur) {
                tempNombreJoueur++;
                root.bLancerPartie.setEnabled(tempNombreJoueur > 2);

                JPanel nouveauPanneau = new JPanel();
                JButton bSupprimer = new JButton("X");
                JTextField JTNom = new JTextField(5);
                String[] couleurs = {"Rouge", "Vert", "Bleu", "Rose", "Jaune"};
                JComboBox JCcouleur = new JComboBox(couleurs);

                nouveauPanneau.setLayout(new GridLayout(1, 3));
                nouveauPanneau.add(JTNom);
                nouveauPanneau.add(JCcouleur);
                bSupprimer.addActionListener(this);
                nouveauPanneau.add(bSupprimer);

                root.fConfig.add(nouveauPanneau);
                root.revalidate();
            }

            if (((JButton) e.getSource()).getText().equals("X")) {
                tempNombreJoueur--;
                root.bLancerPartie.setEnabled(tempNombreJoueur > 2);
                root.fConfig.remove(((JButton) e.getSource()).getParent());
                root.revalidate();
                root.fConfig.revalidate();
            }

            if(e.getSource() == root.bLancerPartie){
                root.lancerPartie();
            }

            if(e.getSource() == root.bQuitter){
                System.exit(0);
            }

            if(e.getSource() == root.bQuitterPartie){
                System.exit(0);
            }

            if(e.getSource() == root.bPieceRonde){
                //root.bPieceRonde.setSelectedIcon(TypePiece.PIECERONDE);
                TypePiece.typePieceSelectionnee = TypePiece.PIECERONDE;
                System.out.println("Le joueur choisit une pièce ronde à placer");

            }

            if(e.getSource() == root.bPieceCubique){
                //root.bPieceCubique.setSelectedIcon(TypePiece.PIECECUBIQUE) ;
                TypePiece.typePieceSelectionnee = TypePiece.PIECECUBIQUE;
                System.out.println("Le joueur choisit une pièce cubique à placer");
            }

            if(e.getSource() == root.bPasserTour){
                //root.bPieceCubique.setSelectedIcon(TypePiece.PIECECUBIQUE);
                Joueur.joueurSuivant();
                Joueur.getJoueurActuel().donnerIndice(new Indice(root.getPlateau()));
                new Notice(Joueur.getJoueurActuel());
                System.out.println("Tour suivant");
            }

        }
    }
}
