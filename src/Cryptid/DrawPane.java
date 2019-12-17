package Cryptid;

import Modele.*;
import Modele.Types.Element;
import Modele.Types.TypePiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPane extends JPanel implements ActionListener {
    private Point tailleCase;
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
        Cryptid.WIDTH = (int) root.getContentPane().getSize().getWidth();
        Cryptid.HEIGHT =  (int) root.getContentPane().getSize().getHeight();
        tailleCase = new Point(
                root.WIDTH/plateau.getTaille(),
                root.HEIGHT/plateau.getTaille()
        );
        this.dessinerFond(g);
        //
        this.dessinnerBiomes(g);
        //this.dessinnerGrille(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void dessinnerGrille(Graphics g){
        g.setColor(Color.PINK);

        for(int i=0;i<tailleCase.x*plateau.getTaille();i=i+tailleCase.x){

            g.drawLine(i,0,i,root.HEIGHT);
        }
        for(int j=0;j<tailleCase.y*plateau.getTaille();j=j+tailleCase.y){
            g.drawLine(0,j,root.WIDTH,j);
        }

    }

    public void dessinnerBiomes(Graphics g){

        Point delta = new Point();
        for(int i=0;i<tailleCase.x*plateau.getTaille();i=i+tailleCase.x){
            for(int j=0;j<tailleCase.y*plateau.getTaille();j=j+tailleCase.y){
                /*
                    Dessin en fonction de la Case 'laCase'
                 */

                Case laCase = plateau.getCase(i/tailleCase.x,j/tailleCase.y);

                if((i/tailleCase.x)%2==0){
                    delta.x = 0;
                    delta.y = tailleCase.y/2;
                    g.setColor(Color.YELLOW);
                }else{
                    delta.x = 0;
                    delta.y = 0;
                    g.setColor(Color.RED);
                }

                int[] polygonex = new int[]{
                        delta.x + i+(tailleCase.x/6),
                        delta.x + i - tailleCase.x/8, ///
                        delta.x + i+(tailleCase.x/6),
                        delta.x + i+(5*tailleCase.x/6),
                        delta.x + i+(5*tailleCase.x/6),
                        delta.x + i+tailleCase.x + tailleCase.x/8,
                        delta.x + i+(5*tailleCase.x/6)
                };

                int[] polygoney = new int[]{
                        delta.y + j ,
                        delta.y + j+(tailleCase.y/2)+1,
                        delta.y + j+tailleCase.y,
                        delta.y + j+tailleCase.y,
                        delta.y + j+tailleCase.y,
                        delta.y + j+tailleCase.y/2 +1,
                        delta.y + j +1
                };

                switch (laCase.getBiome()){
                    case OCEAN:
                        g.setColor(new Color(117, 193, 255));
                        g.drawImage(Images.imgArbre, i + delta.x, j + delta.y, tailleCase.x, tailleCase.y, this);
                        break;
                    case DESERT:
                        g.setColor(new Color(255, 248, 117));
                        break;
                    case PLAINE:
                        g.setColor(new Color(90, 209, 122));
                        break;
                    case SAVANE:
                        g.setColor(new Color(219, 171, 75));
                        break;
                    case MONTAGNE:
                        g.setColor(new Color(212, 175, 135));
                        break;
                    case MARECAGES:
                        g.setColor(new Color(86, 105, 54));
                        break;
                }

                Polygon p = new Polygon(polygonex,polygoney,polygonex.length);
                g.fillPolygon(p);

                if(new Point(i/tailleCase.x,j/tailleCase.y).equals(plateau.getMonstre())){
                    g.setColor(Color.BLACK);
                    g.fillOval(i+delta.x,j+delta.y,tailleCase.x,tailleCase.y);
                }

                int compteur = laCase.getElements().size();
                for(Element e : laCase.getElements()){
                    switch (e) {
                        case ARBRE:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgArbre, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgArbre, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgArbre, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case ROCHER:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgRocher, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgRocher, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgRocher, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case DUNE:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgDune, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgDune, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgDune, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case CACTUS:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgCactus, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgCactus, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgCactus, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case MAELSTORM:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgMaelstorm, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgMaelstorm, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgMaelstorm, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case ETANG:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgEtang, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgEtang, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgEtang, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case SAPIN:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgSapin, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgSapin, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgSapin, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case PYRAMIDE:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgPyramide, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgPyramide, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgPyramide, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case MAISON:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgMaison, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgMaison, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgMaison, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case ANIMEAUX:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgAnimaux, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgAnimaux, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgAnimaux, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                        case BUISSONS:
                            if ( compteur == 1 ) {
                                g.drawImage(Images.imgBuisson, i + delta.x, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 2 ) {
                                g.drawImage(Images.imgBuisson, i + delta.x + tailleCase.x/2, j + delta.y, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            } else if ( compteur == 3 ) {
                                g.drawImage(Images.imgBuisson, i + delta.x + tailleCase.x/3 , j + delta.y + tailleCase.y/2, tailleCase.x/2, tailleCase.y/2, this);
                                compteur++;
                            }
                            break;
                    }

                }
                Point decalageRect = new Point(Math.round(tailleCase.x/4),Math.round(tailleCase.y/4));
                for(Piece pi : laCase.getPieces()){
                    switch(pi.getTypePiece()){
                        case PIECECUBIQUE:
                            //g.drawImage(Images.imgPieceCubique, i + delta.x, j + delta.y, tailleCase.x, tailleCase.y, this);
                            g.setColor(pi.getProprietaire().getCouleur());
                            /*
                            g.drawRect(
                                        i+delta.x+decalageRect.x,
                                        j+delta.y+decalageRect.y,
                                        tailleCase.x-(decalageRect.x*2),
                                        tailleCase.y-(decalageRect.y*2)
                            );
                             */
                            g.drawRect(
                                    i+delta.x+pi.getProprietaire().getTaille(tailleCase).x,
                                    j+delta.y+pi.getProprietaire().getTaille(tailleCase).y,
                                    tailleCase.x-(pi.getProprietaire().getTaille(tailleCase).x*2),
                                    tailleCase.y-(pi.getProprietaire().getTaille(tailleCase).y*2)
                            );
                            break;
                        case PIECERONDE:
                            //g.drawImage(Images.imgPieceRonde, i + delta.x, j + delta.y, tailleCase.x, tailleCase.y, this);
                            g.setColor(pi.getProprietaire().getCouleur());
                            g.drawOval(
                                    i+delta.x+pi.getProprietaire().getTaille(tailleCase).x,
                                    j+delta.y+pi.getProprietaire().getTaille(tailleCase).y,
                                    tailleCase.x-(pi.getProprietaire().getTaille(tailleCase).x*2),
                                    tailleCase.y-(pi.getProprietaire().getTaille(tailleCase).y*2)
                            );
                            break;
                    }
                }

            }

        }
    }

    public Point getTailleCase() {
        return tailleCase;
    }

    public void dessinerFond(Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0,0,Cryptid.WIDTH,Cryptid.HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.timer){
            repaint();
        }
    }

}
