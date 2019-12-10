package Modele;

import Modele.Types.Biome;
import Modele.Types.Element;

import java.util.ArrayList;

public class Case {
    private Biome biome;
    private ArrayList<Element> elements;

    public Case(Biome biome, ArrayList<Element> elements){
        this.biome = biome;
        this.elements = elements;
    }

    public Biome getBiome(){
        return biome;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return " ["+this.biome+ " | "+this.elements.size()+ " ]";
    }

    public String toFullString(){
        boolean contains = false;
        String s = this.getClass() + " <"+this.hashCode()+">\nBiome : [ "+biome+" ] \nElements {";
        for(Element e : elements){
            s = s + " "+e+", ";
            contains=true;
        }
        if(contains)
            s = s.substring(0,s.length()-2);
        s = s + " }";
        return s;
    }
}
