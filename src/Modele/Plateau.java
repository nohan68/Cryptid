package Modele;


import java.awt.*;
import java.util.Random;


public class Plateau {
    private int taille;
    private Random hazardeur;
    private Point monstre;
    private Case[][] cases;

    public Plateau(int taille){
        this.taille = taille;
        this.hazardeur = new Random();
        monstre= new Point(
                this.hazardeur.nextInt(this.taille+1),
                this.hazardeur.nextInt(this.taille+1)
        );

        int casesPosees=0;
        int x;
        int y;

        Point hzPos;
        Point txExp;
        cases = new Case[taille][taille];

        while(casesPosees < this.taille*this.taille){
            txExp = new Point(
                    this.hazardeur.nextInt(this.taille/5),
                    this.hazardeur.nextInt(this.taille/5)
            );
            hzPos = new Point(
                    this.hazardeur.nextInt(this.taille+1),
                    this.hazardeur.nextInt(this.taille+1)
            );
            Biome b = Biome.getRandom();
            for(int i=-txExp.x;i<txExp.x;i++){
                for(int j=-txExp.y;j<txExp.y;j++){
                    x = Math.abs(hzPos.x+i)%this.taille;
                    y = Math.abs(hzPos.y+j)%this.taille;
                    //System.out.println(x+ " "+y);
                    if(cases[x][y] == null){
                        cases[x][y] = new Case(b,Element.getRandom());
                        casesPosees++;
                    }
                }
                System.out.println(casesPosees);
            }
        }
        System.out.println(this);
    }

    public Case pixelToCase(Point pixel, Point tailleCase){
        int i;
        int j;

        i = pixel.x/tailleCase.x;
        if((pixel.x/tailleCase.x)%2==0){
            j = (pixel.y - tailleCase.y/2)/tailleCase.y;
        }else{
            j = pixel.y/tailleCase.y;
        }
        return getCase(i,j);
    }


    public int getTaille() {
        return this.taille;
    }

    public Case getCase(int x, int y){
        return cases[x][y];
    }

    @Override
    public String toString() {
        String r = "";
        for(Case[] x : this.cases){
            for(Case y : x){
                r = r + y;
            }
            r = r +"\n";
        }
        return r;
    }
}
