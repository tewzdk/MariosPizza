package com.company;

import java.util.ArrayList;

public class Ordrearkiv {

    private ArrayList<Ordrelinje> ordrearkivArrayList = new ArrayList<>();

    public void funktioner(){
        print();
    }
    public void print(){
        for (int i = 0; i < ordrearkivArrayList.size(); i++) {
            System.out.println(ordrearkivArrayList.get(i));
        }
    }
    public void tilfoejAfsluttetOrdre(Ordrelinje ordrelinje){
        ordrearkivArrayList.add(ordrelinje);
    }
    public void gemData(){
    }
}
