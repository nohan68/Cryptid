package Cryptid;

import Modele.Case;
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
        this.dessinnerGrille(g);
        //
        Toolkit.getDefaultToolkit().sync();
    }

    public void dessinnerGrille(Graphics g){

        g.setColor(Color.PINK);
        Point tailleCase = new Point(
                root.WIDTH/plateau.getTaille(),
                root.HEIGHT/plateau.getTaille()
        );
        Point delta = new Point();

        /*
        for(int i=0;i<tailleCase.x*plateau.getTaille();i=i+tailleCase.x){

            g.drawLine(i,0,i,root.HEIGHT);
        }
        for(int j=0;j<tailleCase.y*plateau.getTaille();j=j+tailleCase.y){
            g.drawLine(0,j,root.WIDTH,j);
        }
        */

        for(int i=0;i<tailleCase.x*plateau.getTaille();i=i+tailleCase.x){
            for(int j=0;j<tailleCase.y*plateau.getTaille();j=j+tailleCase.y){
                /*
                double[][] polygone = new double[][]{
                        {i+(tailleCase.x/3),j},
                        {i,j+(tailleCase.y/2)},
                        {i+(tailleCase.x/3),j+tailleCase.y},
                        {i+(2*tailleCase.x/3),j+tailleCase.y},
                        {i+(tailleCase.x/2),j+tailleCase.y},
                        {i+(2*tailleCase.x/3),j}
                };
                */
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
                        g.setColor(Color.BLUE);
                        break;
                    case DESERT:
                        g.setColor(Color.YELLOW);
                        break;
                    case PLAINE:
                        g.setColor(Color.GREEN);
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
