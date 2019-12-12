package Cryptid;

import Controller.NoticeController;
import Modele.Indice;
import Modele.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Notice extends JFrame {
    private final static String titre = "Cryptid - Notice";

    private JLabel  lMessage;
    public JButton bOk;
    public JButton bIndices;
    public JButton bToggleMask;

    private JPanel jpMain;
    private JPanel jpMessage;
    private JPanel jpBouttons;

    private boolean indicesAffichees;
    private String message;
    public Joueur j;

    private NoticeController noticeController;

    private void initWidgets(){
        bOk = new JButton("Ok");
        lMessage = new JLabel();
        bIndices = new JButton("Voir tout mes indices");
        bToggleMask = new JButton("Afficher/Cacher");

        jpMain = new JPanel();
        jpBouttons = new JPanel();
        jpMessage = new JPanel();

        jpMain.setLayout(new GridLayout(2,1));
        jpBouttons.setLayout(new GridLayout(1,3));
        setContentPane(jpMain);

        jpMessage.add(lMessage);
        jpBouttons.add(bOk);

        add(jpMessage);
        add(jpBouttons);

        bOk.addActionListener(noticeController);
        bIndices.addActionListener(noticeController);
        bToggleMask.addActionListener(noticeController);
    }

    public void toggleAffIndice(){
        if(indicesAffichees) {
            message = "<html>" + j.getNom() + " c'est à vous de jouer !" + "" +
                    "<br>Votre dernier indice est : <br>" + j.getDernierIndice();
            bToggleMask.setText("Cacher");
        }else {
            message = "<html>" + j.getNom() + " c'est à vous de jouer !" + "" +
                    "<br>Votre dernier indice est masqué <br>";
            bToggleMask.setText("Afficher");
        }
        lMessage.setText(message);
        indicesAffichees = !indicesAffichees;

        revalidate();
    }

    private Notice(){
        super(Notice.titre);
        noticeController = new NoticeController(this);
        setSize(600,150);
        this.initWidgets();
        setVisible(true);
    }

    public Notice(String message){
        this();
        lMessage.setText(message);
        jpMessage.revalidate();
        jpMessage.repaint();
    }

    public Notice(Joueur j){
        this();
        this.j = j;
        indicesAffichees = false;
        jpBouttons.add(bIndices);
        jpBouttons.add(bToggleMask);
        message = "<html>" + j.getNom() + " c'est à vous de jouer !" + ""+
                "<br>Cliquez sur afficher pour voire votre indice<br></html>";
        lMessage.setText(message);

    }

    public Notice(ArrayList<Indice> indices){
        this();
        String s = "<html> ";
        for(Indice i : indices){
            s = " " + i + "<br>";
        }
        s = s + "</html>";
        lMessage.setText(s);
    }
}
