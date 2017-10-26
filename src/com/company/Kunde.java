package com.company;

public class Kunde {
    private String navn;
    public String getNavn() {
        return navn;
    }

    private String tlfnummer;
    public String getTlfnummer(){return tlfnummer;}

    //overload
    public Kunde(){}

    public Kunde(String navn, String tlfnummer){
        this.navn = navn;
        this.tlfnummer = tlfnummer;
    }
    @Override
    public String toString(){
        return("Kunde: " + getNavn() + " (" + getTlfnummer() + ")");
    }
}
