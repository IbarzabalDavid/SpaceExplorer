import objet.*;
import planete.*;
import vaisseau.Vaisseau;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner sc= new Scanner (System.in);
    public static void main(String[] args) {
        Vaisseau vaisseau=new Vaisseau();
        Objet[] tabO= {new Bidon(),new CapeInvisible(),new MartinLeMecano(),new Nitro(), new Plaster()};
        boolean end=false;
        Stack<Planetes> undo=new Stack<>();


        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("--------SPACE EXPLORER---------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("Le but est de se déplacer sur le plus de planète le plossible sans manquer de gaz ou briser son vaisseau.");
        System.out.println("");

        while (!end){
            switch (choisirMenu()){
                case 1:
                    System.out.println("Quantité de carburant : "+vaisseau.getFuel()+" Litres");
                    System.out.println("Points de vie : "+vaisseau.getPv());
                    System.out.println("Inventaire : ");
                    for (int i=0; i<vaisseau.getInventaire().size();i++ ){
                        System.out.println("            -"+vaisseau.getInventaire().get(i).getNom());
                    }

                    break;
                case 2:
                    if ((int)(Math.random()*3)==0){
                        int lost=(int)(Math.random()*21+10);
                        System.out.println("Les Pirates de l'espace vous attaquent!!!");
                        System.out.println("Vous perdez "+lost+" PV");
                        vaisseau.setPv(vaisseau.getPv()-lost);
                    }
                    Planetes plan=getplanet();
                    undo.add(plan);
                    plan.explorer(vaisseau);

                    break;
                case 3:
                    System.out.println("Inventaire:");
                    for (int i=0; i<vaisseau.getInventaire().size();i++ ){
                        System.out.println((i+1)+"-"+vaisseau.getInventaire().get(i).getNom());
                    }
                    System.out.println("");
                    System.out.println("Que voulez-vous utilié? (écrivez 0 si vous voulez rien faire)");
                    boolean reset=false;
                    int choix=0;
                    while (!reset){
                        choix=number();
                        if (choix<=vaisseau.getInventaire().size()){
                            reset=true;
                        }
                    }
                    if (choix!=0){
                        vaisseau.getInventaire().get(choix-1).utiliser(vaisseau);
                        vaisseau.getInventaire().remove(choix-1);
                    }
                    else
                        System.out.println("Vous n'utilisez rien.");

                    break;
                case 4:
                    if (undo.size()==0){
                        System.out.println("Vous êtes a la premiere planete, vous ne pouvez plus reculez.");
                    }
                    else
                    {
                        System.out.println("Vous êtes revenu à la planete avant!!!");
                        vaisseau.setFuel(vaisseau.getFuel()+undo.pop().getGaz());
                        vaisseau.getInventaire().remove(vaisseau.getInventaire().size()-1);

                    }
                    break;
            }

            if(vaisseau.getFuel()<=0){
                vaisseau.setFuel(0);
                System.out.println("Vous n'avez plus de gaz");
                end=true;
            }
            else if (vaisseau.getPv()<=0){
                vaisseau.setPv(0);
                System.out.println("Vous n'avez plus de PV");
                end=true;
            }
        }
        Stack<Planetes> trajet= new Stack<>();
        int times=undo.size();
        for (int i=0; i<times;i++){
            trajet.add(undo.pop());
        }
        System.out.print("Trajet :  Terre");
        for (int i=0; i<times;i++){
            System.out.print("  -->  "+trajet.pop().getNom());
        }


    }
    public static int choisirMenu(){
        int choix=0;
        boolean ok=false;
        while (!ok){
            System.out.println("---------------------------------------------------------");
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
        random=  (int)(Math.random()*5);
        return tabP[random];
    }
    public static int number(){
        int choix=0;
        boolean ok=false;
        while (!ok){
            ok=true;
            try{
                choix=sc.nextInt();
            }catch (Exception ex){
                sc.nextLine();
                System.out.println("Rentre un chiffre dumbass");
                ok=false;
            }
            if (choix<0)
                ok=false;
        }
        return choix;
    }
}

