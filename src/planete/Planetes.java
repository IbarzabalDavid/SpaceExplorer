package planete;
import vaisseau.Vaisseau;

public class Planetes {
    private String nom;
    private int gaz;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getGaz() {
        return gaz;
    }

    public void setGaz(int gaz) {
        this.gaz = gaz;
    }
    public void explorer(Vaisseau vaisseau){
        vaisseau.setFuel(vaisseau.getFuel()-this.gaz);
    }
}
