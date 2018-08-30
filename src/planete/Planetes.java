package planete;
import objet.Objet;
import vaisseau.Vaisseau;

public class Planetes {
    private String nom;
    private int gaz;
    private Objet obj;

    public Objet getObj() {
        return obj;
    }

    public void setObj(Objet obj) {
        this.obj = obj;
    }

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

        System.out.println("Vous visité la planète : "+this.getNom());
        System.out.println("Vous dépensez "+this.getGaz()+" litres de gaz");
        System.out.println("Vous découvrez : "+ this.getObj().getNom());
        vaisseau.getInventaire().add(this.getObj());
        vaisseau.setFuel(vaisseau.getFuel()-this.getGaz());
    }
}
