package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ordrearkiv {
    final int ORDREARKIV_ARRAY_STØRRELSE = 101; //Så er der plads til 100 pizzaer.
    int ordrearkivListe[] = new int[ORDREARKIV_ARRAY_STØRRELSE];

    public Ordrearkiv() {
    }

    public void funktioner(Menu menu){
        //print arkivMenu
        System.out.println("Hvilken funktion ønsker du at benytte?");
        System.out.println("1. Vis alle solgte pizzaer");
        System.out.println("2. Vis mest solgte pizza(er)");
        System.out.println("3. Vis samlet omsætning");
        System.out.println("4. Ryd databasen");
        System.out.println("5. Gå tilbage");

        boolean korrektSvar = false;

        while(!korrektSvar){
            int svar = Main.intSvar();
            if(svar == 1){
                alleSolgtePizzaer(menu);
                korrektSvar = true;
            }
            else if(svar == 2){
                mestSolgtePizza(menu);
                korrektSvar = true;
            }
            else if(svar == 3){
                samletOmsætning(menu);
                korrektSvar = true;
            }
            else if(svar == 4){
                rensData();
                korrektSvar = true;
            }
            else if(svar == 5){
                korrektSvar = true;
            }
            else if(svar == 0 || svar > 5){
                System.out.println("Det indtastede valg (" + svar + ") eksisterer ikke.");
            }
        }
    }

    public void alleSolgtePizzaer(Menu menu){
        boolean derErSolgtePizzaer = false;
        for (int i = 0; i < menu.menuArrayList.size(); i++) {
            if(ordrearkivListe[i]>0){
                derErSolgtePizzaer = true;
            }
        }
        if(derErSolgtePizzaer) {
            System.out.println("Der er blevet solgt:");
        }
        else{
            System.out.println("Der er ikke blevet solgt nogen pizzaer siden ordrearkivet blev initialiseret.");
        }
        for (int i = 0; i < menu.menuArrayList.size(); i++) {
            if(ordrearkivListe[i] > 0) {
                System.out.println(ordrearkivListe[i] + " " + menu.menuArrayList.get(i).getPizzaNavn());
            }
        }
        System.out.println();
    }

    public void mestSolgtePizza(Menu menu){

        int antalMestSolgtePizza = -1;

        for (int i = 0; i < menu.menuArrayList.size(); i++) {
            if(ordrearkivListe[i]>antalMestSolgtePizza) {
                antalMestSolgtePizza = ordrearkivListe[i];
            }

        }
        for (int i = 0; i < menu.menuArrayList.size(); i++) {
            if(antalMestSolgtePizza == ordrearkivListe[i] && ordrearkivListe[i] > 0){
                System.out.println(menu.menuArrayList.get(i));
            }
        }
        if(antalMestSolgtePizza == 0){
            System.out.println("Der er ikke blevet solgt nogen pizzaer siden ordrearkivet blev initialiseret.");
        }
        System.out.println();
    }

    public void samletOmsætning(Menu menu){
        int samletOmsætning = 0;
        for (int i = 0; i < menu.menuArrayList.size(); i++) {
            samletOmsætning = menu.menuArrayList.get(i).getPizzaPris() * ordrearkivListe[i] + samletOmsætning;
        }
        System.out.println("Der er solgt pizzaer for " + samletOmsætning + " kr,-");
        System.out.println();
    }

    public void rensData(){
        System.out.println("Er du sikker på, at du vil slette databasen? (Tast: JA)");
        System.out.println("Har du ombestemt dig? (Tast: NEJ)");
        boolean korrektSvar = false;
        String svar;

        while(!korrektSvar) {
            svar = Main.in.next();
            if (svar.equalsIgnoreCase("JA")) {
                for (int i = 0; i < ordrearkivListe.length; i++) {
                    ordrearkivListe[i] = 0;
                }
                gemData();
                korrektSvar = true;
            }
            else if(svar.equalsIgnoreCase("NEJ")){
                korrektSvar = true;
            }
            else{
                System.out.println("(" + svar + ") er ikke en mulighed.");
                System.out.println("Tast JA for at slette / Tast NEJ for at gå tilbage.");
            }
        }
    }

    public void laesData() {
        Scanner arkivScanner = null;
        try {
            arkivScanner = new Scanner(new File("ordrearkiv.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < ordrearkivListe.length; i++) {
            ordrearkivListe[i] = arkivScanner.nextInt();
        }
    }

    public void gemData() {
        try {
            PrintWriter outputStream = new PrintWriter(new File("ordrearkiv.txt"));
            for (int i = 0; i < ordrearkivListe.length; i++) {
                outputStream.println(ordrearkivListe[i]);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for (int i = 0; i < ordrearkivListe.length; i++) {
            System.out.println(ordrearkivListe[i]);
        }
    }
}
