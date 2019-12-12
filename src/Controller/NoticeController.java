package Controller;

import Cryptid.Notice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeController implements ActionListener {
    Notice root;

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
        }
    }
}
