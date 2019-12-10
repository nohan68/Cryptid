package Modele;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {
    private static ArrayList<Joueur> joueurs = new ArrayList<>();
    private static int idJoueurActuel = 0;

    private String nom;
    private Color  couleur;

    static public void joueurSuivant(){
        idJoueurActuel = idJoueurActuel++%getNombreJoueurs();
    }

    public Joueur(String nom, Color couleur){
        this.nom = nom;
        this.couleur = couleur;
        Joueur.joueurs.add(this);
        if(this.nom.equals("")){
            this.nom="Joueur "+getNombreJoueurs();
        }
        System.out.println("Nouveau Joueur <"+this.toString()+">");
    }

    public static Joueur getJoueurActuel() {
        return joueurs.get(idJoueurActuel);
    }

    public static ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public static int getNombreJoueurs() {
        return Joueur.joueurs.size();
    }

    public String getNom(){
        return this.nom;
    }

    public Color getCouleur(){
        return this.couleur;
    }

    @Override
    public String toString(){
        return this.nom+ " " + this.couleur;
    }

}
