package Modele;

import java.util.ArrayList;

public class Case {
    Biome biome;
    ArrayList<Element> elements;

    public Case(Biome biome, ArrayList<Element> elements){
        this.biome = biome;
        this.elements = elements;
    }

    @Override
    public String toString() {
        String r =  " ["+this.biome+ " | ";
        for (Element e : this.elements){
            r = r + e;
        }
        r = r+ " ]";
        return r;
    }
}
