package Modele;

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

    @Override
    public String toString() {
        return " ["+this.biome+ " | "+this.elements.size()+ " ]";
    }
}
