import objet.*;
import planete.*;
import vaisseau.Vaisseau;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static Scanner sc= new Scanner (System.in);
    public static void main(String[] args) {
        Vaisseau vaisseau=new Vaisseau();
        Objet[] tabO= {new Bidon(),new CapeInvisible(),new MartinLeMecano(),new Nitro(), new Plaster()};
        ArrayList<Objet> inventaire=new ArrayList<>();

        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("--------SPACE EXPLORER---------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("Le but est de se déplacer sur le plus de planète le plossible sans manquer de gaz ou briser son vaisseau.");
        System.out.println("");

        switch (choisirMenu()){
            case 1:
                System.out.println("Quantité de carburant : "+vaisseau.getFuel()+" Litres");
                System.out.println("Points de vie : "+vaisseau.getPv());
                System.out.println("Inventaire : ");
                for (int i=0; i<inventaire.size();i++ ){
                    System.out.println("            -"+inventaire.get(i).getNom());
                }

                break;
            case 2:
                Planetes plan=getplanet();
                System.out.println("Vous visité la planète : "+plan.getNom());
                System.out.println("Vous dépensez "+plan.getGaz()+" litres de gaz");
                System.out.println("Vous découvrez : "+REFAIRE);
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }
    public static int choisirMenu(){
        int choix=0;
        boolean ok=false;
        while (!ok){
            System.out.println("Vous êtes au menu principale. Que voulez-vous faire!?");
            System.out.println("1- Examiner le vaisseau");
            System.out.println("2- Explorer une planète");
            System.out.println("3- Utiliser un objet dans l'inventaire");
            System.out.println("4- Revenir en arrière");
            try{
                choix=sc.nextInt();
            }catch (Exception ex){
                sc.nextLine();
                choix=0;
            }
            if (choix>0 && choix<5){
                ok=true;
            }
            else {
                System.out.println("Rentrez une réponse valide");
            }
        }
        return choix;

    }
    public static Planetes getplanet(){
        Planetes[] tabP={new Abogadu(), new Boumba(), new Coccin(), new Dodoum(), new Epilep()};
        int random=0;
        random=  (int)(Math.random()*5)+1;
        return tabP[random];
    }
}

