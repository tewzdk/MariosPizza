package com.company;

public class Pizza {
    private String pizzaNavn;
    private int pizzaNummer;
    private int pizzaPris;

    public Pizza(String pizzaNavn, int pizzaNummer, int pizzaPris) {
        this.pizzaNavn = pizzaNavn;
        this.pizzaNummer = pizzaNummer;
        this.pizzaPris = pizzaPris;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public int getPizzaPris() {
        return pizzaPris;
    }
}