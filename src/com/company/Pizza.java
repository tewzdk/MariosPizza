package com.company;

public class Pizza {
    private String pizzaNavn;
    public String getPizzaNavn() {
        return pizzaNavn;
    }

    private int pizzaNummer;
    public int getPizzaNummer() {
        return pizzaNummer;
    }

    private int pizzaPris;
    public int getPizzaPris() {
        return pizzaPris;
    }

    private String pizzaBeskrivelse;
    public String getPizzaBeskrivelse() {
        return pizzaBeskrivelse;
    }

    //overload
    public Pizza() {}

    public Pizza(String pizzaNavn, int pizzaNummer, int pizzaPris, String pizzaBeskrivelse) {
        this.pizzaNavn = pizzaNavn;
        this.pizzaNummer = pizzaNummer;
        this.pizzaPris = pizzaPris;
        this.pizzaBeskrivelse = pizzaBeskrivelse;
    }

    //override og formatering
    @Override
    public String toString(){
        return("#" + getPizzaNummer() + " " + getPizzaNavn()
                + " (" + getPizzaBeskrivelse() + ") " + getPizzaPris() + ",- ");
    }
}