package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //init scanner
    public static Scanner in = new Scanner(System.in).useDelimiter("\\n");

    //bool til at afslutte programmet.
    private static boolean programmetAfsluttes = false;

    public static void main(String[] args) {
        //init instances af classes
        Ordreliste ordreliste = new Ordreliste();
        Ordrearkiv ordrearkiv = new Ordrearkiv();
        Menu menu = new Menu();

        //indlæs databaser
        ordrearkiv.laesData();
        menu.laesMenu();

        //kør program
        while(!programmetAfsluttes){
            mainFunktioner(ordreliste, ordrearkiv, menu);
        }
    }

    public static void mainFunktioner(Ordreliste ordreliste, Ordrearkiv ordrearkiv, Menu menu) {
        //print mainMenu
        System.out.println("Hvad ønsker du at gøre?");
        System.out.println("1. Administrer ordre");
        System.out.println("2. Administrer menukort");
        System.out.println("3. Se data & statistik");
        System.out.println("4. Luk programmet");

        //bool til at undersøge om brugeren angiver et korrekt svar.
        boolean korrektSvar = false;

        while(!korrektSvar) {
            //int til at sammenligne svar
            int svar = intSvar();

            if (svar == 1) {
                //print ordrelisteMenu
                ordreliste.funktioner(ordrearkiv, menu);
                korrektSvar = true;

            } else if (svar == 2) {
                //print menukortMenu
                menu.funktioner(ordrearkiv);
                System.out.println();
                korrektSvar = true;

            } else if (svar == 3) {
                //print ordrearkivMenu
                ordrearkiv.funktioner(menu);
                korrektSvar = true;

            } else if (svar == 4) {
                afslutProgram();
                korrektSvar = true;

            } else if (svar == 0 || svar > 4){
                System.out.println("Det indtastede valg (" + svar + ") eksisterer ikke.");
            }
        }
    }

    public static int intSvar(){ //undgår exceptions, når brugeren indtaster forkert værdi
        int intSvar = -1;
        int n = 0;
        for(int x=0;x<=n;x++) {
            try {
                intSvar = in.nextInt();
            } catch (InputMismatchException exception) {

                System.out.println("Indtast et nummer.");
                in.nextLine();
            }
        }
        return intSvar;
    }

    public static void afslutProgram(){
        System.out.println();
        System.out.println("[Programmet afsluttes]");
        in.close();
        programmetAfsluttes = true;
    }
}
