package Cryptid;

import Modele.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPane extends JPanel implements ActionListener {
    private Cryptid root;
    private Timer timer;
    private int ips = 60;

    //Modele
    Plateau plateau;

    public DrawPane(Cryptid root, Plateau plateau){
        super();
        this.root = root;
        this.plateau = plateau;
        timer = new Timer(1000/ips,this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.dessinerFond(g);
        //

        //
        Toolkit.getDefaultToolkit().sync();
    }

    public void dessinerFond(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Cryptid.WIDTH,Cryptid.HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.timer){
            repaint();
        }
    }

}
