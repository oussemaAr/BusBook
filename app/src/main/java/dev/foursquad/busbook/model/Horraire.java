package dev.foursquad.busbook.model;

public class Horraire {

    public int id;
    public int destination;
    public String allerDepart;
    public String allerArriver;
    public String retourDepart;
    public String retourArrive;

    public Horraire() {
    }

    public Horraire(int destination, String allerDepart, String allerArriver, String retourDepart, String retourArrive) {
        this.destination = destination;
        this.allerDepart = allerDepart;
        this.allerArriver = allerArriver;
        this.retourDepart = retourDepart;
        this.retourArrive = retourArrive;
    }
}
