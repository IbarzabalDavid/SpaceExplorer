package objet;

public abstract class Objet {
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


}
