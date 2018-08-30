package objet;

import vaisseau.Vaisseau;

public class Objet {
    private int pv;
    private int gaz;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public int getGaz() {
        return gaz;
    }



    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setGaz(int gaz) {
        this.gaz = gaz;
    }

    public void utiliser(Vaisseau vaisseau){
        System.out.println("Vous utilisez le "+this.getNom());
        vaisseau.setPv(vaisseau.getPv()+this.getPv());
        if (vaisseau.getPv()>100)
            vaisseau.setPv(100);
        vaisseau.setFuel(vaisseau.getFuel()+this.getGaz());
        if (vaisseau.getFuel()>1500)
            vaisseau.setFuel(1500);


    }


}
