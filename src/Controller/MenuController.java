package Controller;

import Cryptid.Cryptid;
import Modele.Joueur;
import Modele.Plateau;
import Modele.Types.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuController implements ActionListener {
    Cryptid root;
    Piece p;

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
                Joueur.nJoueurs++;
                root.bLancerPartie.setEnabled(Joueur.nJoueurs > 2);

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
                Joueur.nJoueurs--;
                root.bLancerPartie.setEnabled(Joueur.nJoueurs > 2);
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

            if(e.getSource() == root.bPasserTour){
                System.out.println("Tour passé");
            }

            if(e.getSource() == root.bPieceRonde){
                root.bPieceRonde.setSelectedIcon(Piece.PIECERONDE);
                System.out.println("Le joueur choisit une pièce ronde à placer");

            }

            if(e.getSource() == root.bPieceCubique){
                root.bPieceCubique.setSelectedIcon(Piece.PIECECUBIQUE);
                System.out.println("Le joueur choisit une pièce cubique à placer");
            }

        }
    }
}
