package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ordrearkiv {

    int ordrearkivListe[] = new int[50];

    public Ordrearkiv() {
    }

    public void funktioner(){
        print();
    }

    public void print(){
        for (int i = 0; i < ordrearkivListe.length; i++) {
            System.out.println(ordrearkivListe[i]);
        }
    }

    public void hentData() {
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
            System.out.println("[Data er gemt]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
