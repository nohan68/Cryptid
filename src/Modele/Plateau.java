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
        int tailleGrandBiomes = this.taille/4;
        int nombreGrandBiomes = this.taille/3;


        cases = new Case[taille][taille];
    }


    public int getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        String r = "";
        for(Case[] y : this.cases){
            for(Case x : y){
                r = r + x;
            }
            r = r +"\n";
        }
        return r;
    }
}
