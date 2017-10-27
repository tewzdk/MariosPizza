package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<Pizza> menuArrayList = new ArrayList<>();

    public Menu () {
    }

    public void funktioner(Ordrearkiv ordrearkiv){
        System.out.println("Hvilken funktion ønsker du at benytte?");
        System.out.println("1. Se menukort");
        System.out.println("2. Tilføj ny pizza til menukortet");
        System.out.println("3. Redigér pizza på menukortet");
        System.out.println("4. Fjern pizza fra menukortet");
        System.out.println("5. Gå tilbage");

        boolean korrektSvar = false;

        while(!korrektSvar){
            int svar = Main.intSvar();
            if(svar == 1){
                print();
                korrektSvar = true;
            }
            else if(svar == 2){
                tilføjNyPizza();
                korrektSvar = true;
            }
            else if(svar == 3){
                redigerPizza(ordrearkiv);
                korrektSvar = true;
            }
            else if(svar == 4){
                fjernPizza(ordrearkiv);
                korrektSvar = true;
            }
            else if(svar == 5){
                korrektSvar = true;
            }
            else{
                System.out.println("Det indtastede valg (" + svar + ") eksisterer ikke.");
            }
        }
    }

    public void tilføjNyPizza(){
        int pizzaNummer = menuArrayList.size() + 1;
        System.out.println("Hvad skal pizzaen hedde?");
        String pizzaNavn = Main.in.next();
        System.out.println("Hvad skal pizzaen koste?");
        int pizzaPris = Main.intSvar();
        System.out.println("Hvad skal pizzaen indeholde?");
        String pizzaBeskrivelse = Main.in.next();
        Pizza pizza = new Pizza(pizzaNavn, pizzaNummer, pizzaPris, pizzaBeskrivelse);
        menuArrayList.add(pizza);
        gemMenu();
        System.out.println("[En ny pizza er oprettet og gemt]");
    }

    public void redigerPizza(Ordrearkiv ordrearkiv){
        //init bools
        boolean korrektSvar = false;
        boolean korrektSvar2 = false;

        print();
        System.out.println();
        System.out.println("Hvilken pizza ønsker du at redigere? (Tast nummeret på pizzaen)");
        System.out.println("Tast '0', hvis du ikke ønsker at redigere en ordre.");

        while(!korrektSvar) {
            int pizzaNummer = Main.intSvar();
            if(pizzaNummer > 0 && pizzaNummer <= menuArrayList.size() + 1){
                System.out.println();
                System.out.println("Du har valgt:");
                System.out.println(menuArrayList.get(pizzaNummer-1));
                System.out.println();
                System.out.println("Hvad ønsker du at ændre?");
                System.out.println("1. Navn");
                System.out.println("2. Beskrivelse");
                System.out.println("3. Pris");
                System.out.println("4. Gå tilbage");
                while(!korrektSvar2){
                    int svar = Main.intSvar();
                    if(svar == 1){
                        System.out.println("Indtast nyt navn:");
                        menuArrayList.get(pizzaNummer-1).setPizzaNavn(Main.in.next());
                        System.out.println("[Navnet er ændret til "
                                + menuArrayList.get(pizzaNummer-1).getPizzaNavn() + "]");
                        gemMenu();
                        System.out.println();
                        if (ordrearkiv.ordrearkivListe[pizzaNummer -1] != 0){
                            checkOmPizzaDataReboot(pizzaNummer, ordrearkiv);
                        }
                        korrektSvar2 = true;


                    }
                    else if(svar == 2){
                        System.out.println("Indtast ny beskrivelse:");
                        menuArrayList.get(pizzaNummer-1).setPizzaBeskrivelse(Main.in.next());
                        System.out.println("[Beskrivelsen er ændret til: "
                                + menuArrayList.get(pizzaNummer-1).getPizzaBeskrivelse() + "]");
                        gemMenu();
                        System.out.println();
                        if (ordrearkiv.ordrearkivListe[pizzaNummer -1] != 0){
                            checkOmPizzaDataReboot(pizzaNummer, ordrearkiv);
                        }
                        korrektSvar2 = true;
                    }
                    else if(svar == 3){
                        System.out.println("Indtast ny pris:");
                        menuArrayList.get(pizzaNummer-1).setPizzaPris(Main.intSvar());
                        System.out.println("[Prisen er ændret til "
                                + menuArrayList.get(pizzaNummer-1).getPizzaPris() + ",-]");
                        gemMenu();
                        System.out.println();
                        if (ordrearkiv.ordrearkivListe[pizzaNummer -1] != 0){
                            checkOmPizzaDataReboot(pizzaNummer, ordrearkiv);
                        }
                        korrektSvar2 = true;

                    }
                    else if(svar == 4){
                        korrektSvar2 = true;
                    }
                    else {
                        System.out.println("Det indtastede valg (" + svar + ") eksisterer ikke.");
                    }
                }
                korrektSvar = true;
            }
            else{
                System.out.println("Det indtastede valg (" + pizzaNummer + ") eksisterer ikke.");
            }
        }
    }

    public void fjernPizza(Ordrearkiv ordrearkiv){
        boolean korrektSvar = false;
        boolean korrektSvar2 = false;

        print();
        System.out.println("Hvilken pizza ønsker du at fjerne? (Tast nummeret på pizzaen)");
        System.out.println("Tast '0', hvis du ikke ønsker at redigere en ordre.");

        while(!korrektSvar){
            int pizzaNummer = Main.intSvar();
            if(pizzaNummer > 0 && pizzaNummer <= menuArrayList.size() + 1) {
                System.out.println("Er du sikker på, at du vil fjerne:");
                System.out.println(menuArrayList.get(pizzaNummer - 1));
                System.out.println("Tast 'JA' hvis du ønsker at forsætte.");
                System.out.println("Tast 'NEJ' hvis du vil gå tilbage.");

                while(!korrektSvar2) {
                    String svar = Main.in.next();
                    if (svar.equalsIgnoreCase("JA")) {

                        for (int i = 0; i < menuArrayList.size(); i++) {
                            if(menuArrayList.get(i).getPizzaNummer() > (pizzaNummer)){
                                menuArrayList.get(i).setPizzaNummer(i);
                            }
                        }
                        for (int i = 0; i < ordrearkiv.ordrearkivListe.length - 1; i++) {
                            if(i >= pizzaNummer){
                            ordrearkiv.ordrearkivListe[i] = ordrearkiv.ordrearkivListe[i+1];
                            }
                        }

                        menuArrayList.remove(pizzaNummer-1);
                        gemMenu();
                        System.out.println("[Pizzaen blev fjernet fra menukortet]");
                        korrektSvar2 = true;
                    }
                    else if(svar.equalsIgnoreCase("NEJ")){
                        korrektSvar2 = true;
                    }
                    else{
                        System.out.println("(" + svar + ") er ikke en mulighed.");
                    }
                }
                korrektSvar = true;
            }
            else if(pizzaNummer == 0) {
                korrektSvar = true;
            }
            else{
                System.out.println("Det indtastede valg (" + pizzaNummer + ") eksisterer ikke.");
            }
        }
    }

    public void gemMenu(){
        try {
            PrintWriter outputStream = new PrintWriter(new File("menu.txt"));
            for (int i = 0; i < menuArrayList.size(); i++) {
                outputStream.println(
                        menuArrayList.get(i).getPizzaNummer() + ";" +
                        menuArrayList.get(i).getPizzaNavn() + ";" +
                        menuArrayList.get(i).getPizzaBeskrivelse() + ";" +
                        menuArrayList.get(i).getPizzaPris() + ";"
                );
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void laesMenu(){
        //System.out.println(new File("."));
        Scanner scanner = null; //Der laves en scanner med en delimiter på semikolon, dvs. at den stopper nuværende scanner hver gang den rammer en semikolon
        try {
            scanner = new Scanner(new File("menu.txt")).useDelimiter(";");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String pizzaNavn;
        int pizzaNummer;
        int pizzaPris;
        String pizzaBeskrivelse;

        while(scanner.hasNext()){ //Denne scanner går igennem txt-filen, og lægger hver scannet del ind som variabel
            pizzaNummer = scanner.nextInt();
            pizzaNavn = scanner.next();
            pizzaBeskrivelse = scanner.next();
            pizzaPris = scanner.nextInt();
            menuArrayList.add(new Pizza(pizzaNavn, pizzaNummer, pizzaPris, pizzaBeskrivelse)); //TIl sidst lægges alle de indscannede variable ind som objekter i en arrayliste
            scanner.nextLine(); //Scanneren fungerer som en cursor, og skal dirigeres til næste linje efter hver menu er indlæst.
        }
        scanner.close();
    }

    public void print(){
        for (int i = 0; i < menuArrayList.size(); i++) {
            System.out.println(menuArrayList.get(i));

        }
    }

    public void checkOmPizzaDataReboot(int pizzaNummer, Ordrearkiv ordrearkiv){
        boolean korrektSvar3 = false;
        if(ordrearkiv.ordrearkivListe[pizzaNummer-1] > 0){
            System.out.println("Ønsker du at genstarte statistiken for denne pizza?");
            System.out.println("1. Ja");
            System.out.println("2. Nej");
            while(!korrektSvar3){
                int svar2 = Main.intSvar();
                if(svar2 == 1){
                    ordrearkiv.ordrearkivListe[pizzaNummer-1] = 0;
                    korrektSvar3 = true;
                }
                else if(svar2 == 2){
                    korrektSvar3 = true;
                }
                else{
                    System.out.println("Det indtastede valg (" + svar2 + ") eksisterer ikke.");
                }
            }
        }
    }
    
}

