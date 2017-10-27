package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<Pizza> menuArrayList = new ArrayList<>();

    public Menu () {
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
    
}

