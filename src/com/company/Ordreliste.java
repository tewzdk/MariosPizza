package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ordreliste {



    //init ordrearraylist (kan gøres her pga. copy by reference)
    private ArrayList<Ordre> ordreliste = new ArrayList<>();

    public Ordreliste(){ }

    public void print(){
        for (int i = 0; i < ordreliste.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + ordreliste.get(i));
        }

    }

    public void funktioner(){

        //print funktioner
        System.out.println("Hvilken funktion ønsker du at benytte?");
        System.out.println("1. Se ordrelisten");
        System.out.println("2. Tilføj ny ordre");
        System.out.println("3. Afslut ordre");
        System.out.println("4. Annuller ordre");
        System.out.println("5. Gå tilbage");

        //bool til at undersøge om brugeren angiver et korrekt svar.
        boolean korrektSvar = false;

        while(!korrektSvar) {
            //int til at sammenligne svar
            int svar = Main.intSvar();

            if (svar == 1) {
                System.out.println();
                print();
                korrektSvar = true;

            }
            else if (svar == 2){
                tilfoejOrdre();
                korrektSvar = true;
            }
            else if (svar == 3){
                //if-sætningen tjekker, om der eksisterer nogle ordre i listen.
                if(ordreliste.size() > 0){
                    afslutOrdre();
                    korrektSvar = true;
                }
                else{
                    System.out.println("Der er ingen ordrer at afslutte.");
                    System.out.println();
                    korrektSvar = true;
                }

            }
            else if (svar == 4){
                //if-sætningen tjekker, om der eksisterer nogle ordre i listen.
                if(ordreliste.size() > 0) {
                    annullerOrdre();
                    korrektSvar = true;
                }
                else{
                    System.out.println("Der er  ingen ordrer at annullere.");
                    System.out.println();
                    korrektSvar = true;
                }
            }
            else if (svar == 5){
                //bryder løkken og vender direkte tilbage til mainFunktioner
                korrektSvar = true;
            }
            else if(svar > 5) {
                System.out.println("Det indtastede valg (" + svar + ") eksisterer ikke.");
            }

        }

    }

    public void tilfoejOrdre(){
        //init menu
        Menu menu = new Menu();

        //init bool
        boolean korrektSvar = false;

        //find pizza
        System.out.println("Pizza #:");

        //init pizzaNummer variable
        int pizzaNummer = 0;

        //While-løkke til at sikre korrekt svar.
        while(!korrektSvar){
            pizzaNummer = Main.intSvar();

            if(pizzaNummer >= 1 && pizzaNummer <= menu.menuArrayList.size()){
                korrektSvar = true;
            }
            else if(pizzaNummer > menu.menuArrayList.size()){
                System.out.println("Pizza #" + pizzaNummer + " eksisterer ikke.");
            }
        }
        //meget uelegant måde at skabe pizzaen fra arraylisten, men den letteste løsning jeg kunne regne ud.
        Pizza pizza = new Pizza(menu.menuArrayList.get(pizzaNummer -1).getPizzaNavn(),
                menu.menuArrayList.get(pizzaNummer -1).getPizzaNummer(),
                menu.menuArrayList.get(pizzaNummer -1).getPizzaPris(),
                menu.menuArrayList.get(pizzaNummer -1).getPizzaBeskrivelse());

        //opret kunde.
        System.out.println("Kundens navn:");
        String kundensNavn = Main.in.next();
        System.out.println("Kundens telefonnummer:");
        String kundensTlfnummer = Main.in.next();
        Kunde kunde = new Kunde(kundensNavn, kundensTlfnummer);

        //Bestem afhentningstidspunkt via string => LocalTime (skal have en korrektsvarløkke!)
        System.out.println("Forventes færdig klokken:");
        String afhentningstidspunkt = Main.in.next();
        LocalTime localTime = LocalTime.parse(afhentningstidspunkt, DateTimeFormatter.ofPattern("HHmm"));

        //opret note.
        System.out.println("Indtast yderligere bemærkninger (Tryk ENTER, hvis der ikke er nogen):");
        String note = Main.in.next();

        //ændrer noten til "Ingen.", hvis der ikke indtastes noget.
        if(note.equalsIgnoreCase("")){
            note = "Ingen.";
        }

        //skaber objektet(Ordre) via den indsamlede data.
        Ordre nyOrdre = new Ordre(pizza, kunde, note, localTime);

        //tilføjer den nye ordre til arraylisten(ordreliste).
        ordreliste.add(nyOrdre);
        System.out.println("[Ordren er tilføjet]");

        //sortérer listen.
        ordreliste.sort((o1,o2) -> o1.getLocalTime().compareTo(o2.getLocalTime()));

        //just for zeh lookz...
        System.out.println();
    }

    public void afslutOrdre(){ //mangler at gemme ordre i arkiv.
        boolean korrektSvar = false;
        print();
        //if/else: Hvis der kun eksisterer én ordre, behøver brugeren ikke at træffe noget valg.
        if(ordreliste.size() > 1) {
            System.out.println("1. Afslut den øverste ordre fra køen");
            System.out.println("2. Afslut en anden ordre");
            while (!korrektSvar) {
                int svar = Main.intSvar();
                if (svar == 1) {
                    ordreliste.remove(0);
                    System.out.println("[Ordren er afsluttet og gemt]");
                    System.out.println();
                    korrektSvar = true;
                } else if (svar == 2) {
                    boolean korrektSvar2 = false;
                    System.out.println("Hvilket nummer i køen har ordren, du ønsker at afslutte?");
                    while (!korrektSvar2) {
                        int svar2 = Main.intSvar();
                        if (svar2 <= ordreliste.size() && svar2 > 0) {
                            ordreliste.remove(svar2 - 1);
                            System.out.println("[Ordren er afsluttet og gemt]");
                            System.out.println();
                            korrektSvar2 = true;
                        } else if (svar2 > ordreliste.size()) {
                            System.out.println("Den indtastede ordre: '" + svar2 + "' kan ikke afsluttes.");
                        }
                    }
                    korrektSvar = true;
                } else {
                    System.out.println("Det indtastede valg (" + svar + ") eksisterer ikke.");
                }
            }
        }
        else {
            ordreliste.remove(0);
            System.out.println("[Ordren er afsluttet og gemt]");
            System.out.println();
        }
    }

    public void annullerOrdre(){
        print();
        boolean korrektSvar = false;
        System.out.println("Hvilket nummer i køen har ordren, du ønsker at annullere?");
        System.out.println("Tast '0', hvis du ikke ønsker at annullere en ordre.");

        while(!korrektSvar){
            int svar = Main.intSvar();
            if(svar <= ordreliste.size() && svar > 0){
                ordreliste.remove(svar-1);
                System.out.println("[Ordren er annulleret]");
                System.out.println();
                korrektSvar = true;
            }
            else if(svar == 0){
                korrektSvar = true;
            }
            else{
                System.out.println("Den indtastede ordre: '" + svar + "' kan ikke annulleres");
            }
        }
    }


}
