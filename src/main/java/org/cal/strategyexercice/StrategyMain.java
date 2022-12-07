package org.cal.strategyexercice;

import java.util.ArrayList;
import java.util.List;

public class StrategyMain {
    
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(new HeureuseHumeur()));
        personnes.add(new Personne(new MalheureuseHumeur()));
        personnes.add(new Personne(new TristeHumeur()));

        personnes.forEach(Personne::printHumeur);
        
        for (Personne personne : personnes) {
            if (personne.getHumeur().equals("Malheureuse")) {
                System.out.println("J'ai besoin d'un MacBook Pro pour être une personne heureuse!");
            } else if (personne.getHumeur().equals("Heureuse")) {
                System.out.println("J'ai un MacBook Pro, j'ai tout ce qu'il me faut  pour être une personne heureuse!");
            } else if (personne.getHumeur().equals("Triste")) {
                System.out.println("Je fais parti des gens qui n'auront jamais de MacBook Pro");
            }
        }
    }
}
