package Cryptid;

import Modele.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                        delta.x + i+(tailleCase.x/3),
                        delta.x + i - tailleCase.x/4, ///
                        delta.x + i+(tailleCase.x/3),
                        delta.x + i+(2*tailleCase.x/3),
                        delta.x + i+(2*tailleCase.x/3),
                        delta.x + i+tailleCase.x + tailleCase.x/4,
                        delta.x + i+(2*tailleCase.x/3)
                };

                int[] polygoney = new int[]{
                        delta.y + j ,
                        delta.y + j+(tailleCase.y/2),
                        delta.y + j+tailleCase.y,
                        delta.y + j+tailleCase.y,
                        delta.y + j+tailleCase.y,
                        delta.y + j+tailleCase.y/2 +1,
                        delta.y + j +1
                };

                switch (plateau.getCase(i/tailleCase.x,j/tailleCase.y).getBiome()){
                    case OCEAN:
                        g.setColor(new Color(117, 193, 255));
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


                Polygon p =new Polygon(polygonex,polygoney,polygonex.length);
                g.fillPolygon(p);

            }

        }
    }

    public Point getTailleCase() {
        return tailleCase;
    }

    public void dessinerFond(Graphics g){
        g.setColor(new Color(97, 79, 60));
        g.fillRect(0,0,Cryptid.WIDTH,Cryptid.HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.timer){
            repaint();
        }
    }

}
