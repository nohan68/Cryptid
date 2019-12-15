package Modele;


import Modele.Types.Biome;
import Modele.Types.Element;

import java.awt.*;
import java.util.Random;


public class Plateau {
    private int taille;
    private Random hazardeur;
    public Point monstre;
    private Case[][] cases;
    public boolean isMonstreTrouve = false;

    public Plateau(int taille){
        this.taille = taille;
        this.hazardeur = new Random();
        monstre= new Point(
                this.hazardeur.nextInt(this.taille),
                this.hazardeur.nextInt(this.taille)
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
                        cases[x][y] = new Case(b, Element.getRandom(b));
                        casesPosees++;
                    }
                }
            }
            //System.out.println(casesPosees);
        }
        System.out.println(this);
        System.out.println("Monstre : "+monstre);
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

    public Point getMonstre() { return monstre; }

    public Biome getMonstreBiome(){
        return cases[monstre.x][monstre.y].getBiome();
    }

    public Case getCase(int x, int y){
        return cases[x][y];
    }
    public Case getCase(Point p){
        return cases[p.x][p.y];
    }

    public int getDistance(Point a, Point b){
        return (int) Math.abs(Math.floor(Math.sqrt(Math.pow(b.x-a.x,2)+Math.pow(b.y-a.y,2))));
    }

    public int getDistanceFromCryptid(Point a){
        return getDistance(a,this.monstre);
    }

    public boolean verifDistanceAvecMonstre(Case c){
        if(c == getCase(monstre.x, monstre.y)){
            return true;
        }
        return false;
    }

    public Case getClosestCaseFromCryptidWith(Element e){
        int min_distance = taille;
        Case caseToReturn = null;
        for(int i=0; i<taille;i++){
            for(int j=0; j<taille;j++){
                for(Element ec : getCase(i,j).getElements()){
                    if(ec == e && getDistanceFromCryptid(new Point(i,j))<min_distance){
                        min_distance = getDistanceFromCryptid(new Point(i,j));
                        caseToReturn = getCase(i,j);
                    }
                }
            }
        }
        return caseToReturn;
    }

    public Point caseToPosition(Case c){
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                if(c==cases[i][j]){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    public Case getClosestCaseFromCryptidWith(Biome b){
        int min_distance = taille;
        Case caseToReturn = null;
        for(int i=0; i<taille;i++){
            for(int j=0; j<taille;j++){
                if(b == getCase(i,j).getBiome() && getDistanceFromCryptid(new Point(i,j))<min_distance){
                    min_distance = getDistanceFromCryptid(new Point(i,j));
                    caseToReturn = getCase(i,j);
                }
            }
        }
        return caseToReturn;
    }

    @Override
    public String toString() {
        String r = "";
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                r = r + this.cases[j][i];
            }
            r = r + "\n";
        }
        return r;
    }
}
