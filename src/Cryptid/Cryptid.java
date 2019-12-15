package Cryptid;

import Controller.JeuController;
import Controller.MenuController;
import Modele.Indice;
import Modele.Joueur;
import Modele.Types.TypePiece;
import Modele.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cryptid extends JFrame implements ActionListener {
    public static int WIDTH  = 1000;
    public static int HEIGHT = 1000;

    private int vitesseActualisation = 1000;

    private DrawPane       panneauJeu;
    private MenuController menuController;
    private JeuController jeuController;
    private Plateau plateau;

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


    public JPanel menuPartie;
    public JButton bPieceCubique;
    public JButton bPieceRonde;
    public JButton bPasserTour;
    public JButton bQuitterPartie;

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

        menuPartie = new JPanel();
        bPieceCubique = new JButton("Pièce cubique", TypePiece.PIECECUBIQUE);
        bPieceRonde = new JButton("Pièce ronde", TypePiece.PIECERONDE);
        bPasserTour = new JButton("Tour suivant");
        bQuitterPartie = new JButton("Quitter");
    }

    public void initWigets(){
        setContentPane(fPrincipale);

        bJouer.addActionListener(menuController);
        bQuitter.addActionListener(menuController);
        bQuitterPartie.addActionListener(menuController);
        bPasserTour.addActionListener(menuController);
        bPieceCubique.addActionListener(menuController);
        bPieceRonde.addActionListener(menuController);

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

        //menuPartie.setLayout(new GridLayout(4,1));
        //menuPartie.setSize(300,300);
        //menuPartie.add(bPieceCubique);
        //menuPartie.add(bPieceRonde);
        //menuPartie.add(bPasserTour);
        //menuPartie.add(bQuitterPartie);

    }

    public static void main(String[] args){
        new Cryptid();
    }

    public void lancerPartie(){
        updater.start();
        plateau = new Plateau(12);
        panneauJeu = new DrawPane(this,plateau);
        jeuController = new JeuController(this);
        panneauJeu.addMouseListener(jeuController);
        panneauJeu.add(bPieceCubique);
        panneauJeu.add(bPieceRonde);
        panneauJeu.add(bPasserTour);
        panneauJeu.add(bQuitterPartie);
        this.fPrincipale.remove(this.fConfig);
        setContentPane(panneauJeu);
        fPrincipale.revalidate();
        revalidate();
        fPrincipale.repaint();

        String nom="";
        String couleurstr="";
        Color couleur=Color.WHITE;
        //Création des joueurs
        for(Component jc : fConfig.getComponents()){
            if(jc instanceof JPanel){
                for(Component element : ((JPanel) jc).getComponents()){
                    if(element instanceof JTextField){
                        nom = ((JTextField) element).getText();
                    }
                    if(element instanceof JComboBox){
                         couleurstr=""+((JComboBox)element).getSelectedItem();
                    }
                }
                switch (couleurstr){
                    case "Rouge":
                        couleur = Color.RED;
                        break;
                    case "Vert":
                        couleur = Color.GREEN;
                        break;
                    case "Bleu":
                        couleur = Color.BLUE;
                        break;
                    case "Jaune":
                        couleur = Color.YELLOW;
                        break;
                    case "Rose":
                        couleur = Color.PINK;
                        break;
                }
                Joueur j = new Joueur(nom, couleur);
                j.donnerIndice(new Indice(plateau));
            }
        }
        new Notice(Joueur.getJoueurActuel());
        new Notice("La chasse au cryptid est ouverte !");

    }

    public void mainloop(){
        //à chaque actualisation
        repaint();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void vider(){
        this.removeAll();
    }

    public DrawPane getPanneauJeu(){
        return panneauJeu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.mainloop();
    }
}
