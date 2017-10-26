package com.company;

import java.time.LocalTime;

public class Ordre {
    private String note;

    private LocalTime localTime;
    public LocalTime getLocalTime() {
        return localTime;
    }

    private Pizza pizza = new Pizza();
    private Kunde kunde = new Kunde();

    public Ordre(Pizza pizza, Kunde kunde, String note, LocalTime localTime){
        this.pizza = pizza;
        this.kunde = kunde;
        this.localTime = localTime;
        this.note = note;
    }
    //Indeholder Pizza & Kunde, Bestillingstidspunkt, laver Afhentningstidspunkt, note

    //override og formatering.
    @Override
    public String toString() {
        return (pizza + "\n" + kunde +
                "\nBemærkninger: " + note + "\n" + "Afhentningstidspunkt: " + localTime + "\n");
    }
}
