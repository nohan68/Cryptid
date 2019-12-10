package Modele;

import Modele.Types.Biome;
import Modele.Types.Element;
import Modele.Types.TypePiece;

import java.util.ArrayList;

public class Case {
    private Biome biome;
    private ArrayList<Element> elements;
    private ArrayList<Piece> pieces;

    public Case(Biome biome, ArrayList<Element> elements){
        this.biome = biome;
        this.elements = elements;
        this.pieces = new ArrayList<>();
    }

    public Biome getBiome(){
        return biome;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public ArrayList<Piece> getPieces(){
        return pieces;
    }

    public void addPiece(Piece p){
        pieces.add(p);
    }

    @Override
    public String toString() {
        return " ["+this.biome+ " | "+this.elements.size()+ " ]";
    }

    public String toFullString(){
        boolean containsElement = false;
        boolean containsPiece   = false;
        String s = this.getClass() + " <"+this.hashCode()+">\nBiome : [ "+biome+" ] \nElements {";
        for(Element e : elements){
            s = s + " "+e+", ";
            containsElement=true;
        }
        if(containsElement)
            s = s.substring(0,s.length()-2);
        s = s + " }\nPieces : {";

        for(Piece piece : this.pieces){
            s = s + " "+ piece +", ";
            containsPiece=true;
        }
        if(containsPiece)
            s = s.substring(0,s.length()-2);
        s = s + " }";
        return s;
    }
}
