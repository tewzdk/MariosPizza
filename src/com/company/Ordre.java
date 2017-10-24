package com.company;

import java.time.LocalTime;

public class Ordre {
    private String note;
    public String getNote() {
        return note;
    }
    public int afhentningstidspunkt; //vent lige lidt.



    public Ordre(Menu menu, Kunde kunde, String note, LocalTime afhentningstidspunkt){
        this.note = note;
        //this.afhentningstidspunkt = localtimeshizzle;
    }
    //Indeholder Pizza & Kunde, Bestillingstidspunkt, laver Afhentningstidspunkt, note
}
