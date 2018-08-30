package vaisseau;

import objet.Objet;

import java.util.ArrayList;

public class Vaisseau {
    private int fuel=1500;
    private int pv=100;
    private ArrayList<Objet> inventaire=new ArrayList();

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<Objet> inventaire) {
        this.inventaire = inventaire;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
