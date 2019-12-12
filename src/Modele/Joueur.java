package Modele;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {
    private static ArrayList<Joueur> joueurs = new ArrayList<>();
    private static int idJoueurActuel = 0;

    private String nom;
    private Color  couleur;
    private double taille;
    private ArrayList<Indice> indices;

    static public void joueurSuivant(){
        idJoueurActuel = (idJoueurActuel+1)%getNombreJoueurs();
        System.out.println("joueurActuel: "+idJoueurActuel + "\nNombredejoueurs: "+getNombreJoueurs());
    }

    public Joueur(String nom, Color couleur){
        this.nom = nom;
        this.couleur = couleur;
        Joueur.joueurs.add(this);
        if(this.nom.equals("")){
            this.nom="Joueur "+getNombreJoueurs();
        }

        this.taille = 1/(4+(double)getNombreJoueurs())*2;
        this.indices = new ArrayList<>();
        System.out.println(this.taille);
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

    public Indice getDernierIndice(){ return indices.get(indices.size()-1); }

    public void donnerIndice(Indice i){ indices.add(i);}
    public void donnerIndices(ArrayList<Indice> i){ indices.addAll(i);}
    public ArrayList<Indice> getIndices(){return new ArrayList<Indice>(this.indices);}

    public Point getTaille(Point tailleCase){
        return new Point((int) Math.round(tailleCase.x*this.taille),(int) Math.round(tailleCase.y*this.taille));
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
