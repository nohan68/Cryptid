package Cryptid;

import Controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cryptid extends JFrame implements ActionListener {
    public final static int WIDTH  = 800;
    public final static int HEIGHT = 600;

    private int vitesseActualisation = 1000;

    private DrawPane       panneauJeu;
    private MenuController menuController;

    public JPanel  fPrincipale;

    public  JPanel fMenu;
    public JButton bJouer;
    public JButton bQuitter;
    public JLabel lTitre;

    public JPanel fConfig;
    public JLabel lTitreConfig;
    public JButton bAddJoueur;
    public JButton bLancerPartie;

    private Timer updater;


    public Cryptid(){
        super("Cryptid");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initAttr();
        initWigets();

        updater = new Timer(1000/vitesseActualisation, this);

        setVisible(true);
    }

    public void initAttr(){
        menuController = new MenuController(this);

        fPrincipale = new JPanel();

        fMenu       = new JPanel();
        bJouer      = new JButton("Jouer");
        bQuitter    = new JButton("Quitter");
        lTitre      = new JLabel("Cryptid",SwingConstants.CENTER);

        fConfig     = new JPanel();
        bAddJoueur  = new JButton("Ajouter un joueur");
        lTitreConfig= new JLabel("Préparation de la partie");
        bLancerPartie=new JButton("Lancer !");

        panneauJeu = new DrawPane(this);
    }

    public void initWigets(){
        setContentPane(fPrincipale);

        bJouer.addActionListener(menuController);
        bQuitter.addActionListener(menuController);

        fMenu.setLayout(new GridLayout(6,1));
        fPrincipale.add(fMenu);
        fMenu.add(lTitre);
        fMenu.add(bJouer);
        fMenu.add(new JLabel(""));
        fMenu.add(bQuitter);

        //fPrincipale.add(fConfig);
        bAddJoueur.addActionListener(menuController);
        bLancerPartie.addActionListener(menuController);
        bLancerPartie.setEnabled(false);
        fConfig.setLayout(new GridLayout(16,1));
        fConfig.add(lTitreConfig);
        fConfig.add(bAddJoueur);
        fConfig.add(bLancerPartie);





    }

    public static void main(String[] args){
        new Cryptid();
    }

    public void lancerPartie(){
        updater.start();
        this.fPrincipale.remove(this.fConfig);
        setContentPane(panneauJeu);
        fPrincipale.revalidate();
        revalidate();
        fPrincipale.repaint();
    }

    public void mainloop(){
        //à chaque actualisation
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.mainloop();
    }
}