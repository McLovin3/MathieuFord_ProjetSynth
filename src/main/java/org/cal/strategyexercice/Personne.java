package org.cal.strategyexercice;

public class Personne {
    private final Humeur humeur;

    public Personne(Humeur humeur) {
        this.humeur = humeur;
    }

    public String getHumeur() {
        return humeur.getHumeur();
    }

    @Override
    public String toString() {
        return "Personne [humeur=" + getHumeur() + "]";
    }

    public void printHumeur() {
        System.out.println(getHumeur());
    }

}
