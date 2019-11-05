package Modele;

import java.awt.*;

public class Joueur {
    public static int nJoueurs = 0;

    private String nom;
    private Color  couleur;

    public Joueur(String nom, Color couleur){
        this.nom = nom;
        this.couleur = couleur;
    }

    public String getNom(){
        return this.nom;
    }

    public Color getCouleur(){
        return this.couleur;
    }

}
