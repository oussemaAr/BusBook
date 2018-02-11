package dev.foursquad.busbook.model;

public class Ville {

    public int id;
    public String nom;

    public Ville() {
    }

    public Ville(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
