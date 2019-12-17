package Controller;

import Cryptid.Cryptid;
import Cryptid.Notice;
import Modele.Joueur;
import Modele.Plateau;
import Modele.Types.TypePiece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeController implements ActionListener {
    Notice root;
    public static JButton boutonCreuser;

    public NoticeController(Notice root){
        this.root = root;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            if(((JButton) e.getSource()) == root.bOk){
                root.setVisible(false);
                root.dispose();
            }
            if(e.getSource() == root.bToggleMask){
                root.toggleAffIndice();
            }
            if(e.getSource() == root.bIndices){
                new Notice(root.j.getIndices());
            }

            if(e.getSource() == root.bCreuser){
                boutonCreuser = root.bCreuser;
                System.out.println(Joueur.getJoueurActuel() + " décide de creuser");
                root.dispose();
            }

            if(e.getSource() == root.bNon){
                root.setVisible(false);
                root.dispose();
            }

            if(e.getSource() == root.bQuitter){
                System.exit(0);
            }

            if(e.getSource() == root.bRecommencer){

            }
        }
    }
}
