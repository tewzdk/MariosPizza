package com.company;

import java.util.ArrayList;

public class Menu {
    public ArrayList<Pizza> menuArrayList = new ArrayList<>();

    public Menu (){
        //på længere sigt, skal vi måske læse fra dokument... i stedet for at hardcode det.
        menuArrayList.add(new Pizza("Vesuvio",1,57,
                "tomatsauce, ost, skinke og oregano"));

        menuArrayList.add(new Pizza("Amerikaner",2,53,
                "tomatsauce, ost, oksefars og oregano"));

        menuArrayList.add(new Pizza("Cacciatore",3,57,
                "tomatsauce, ost, pepperoni og oregano"));

        menuArrayList.add(new Pizza("Carbona",4,63,
                "tomatsauce, ost, kødsovs, spaghetti, cocktailpølser og oregano"));

        menuArrayList.add(new Pizza("Dennis",5,65,
                "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano"));

        menuArrayList.add(new Pizza("Bertil",6,57,
                "tomatsauce, ost, bacon og oregano"));

        menuArrayList.add(new Pizza("Silvia",7,61,
                "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano"));

        menuArrayList.add(new Pizza("Victoria",8,61,
                "tomatsauce, ost, skinke, ananas, champignon, løg og oregano"));

        menuArrayList.add(new Pizza("Toronfo",9,61,
                "tomatsauce, ost, skinke, bacon, kebab, chili og oregano"));

        menuArrayList.add(new Pizza("Capricciosa",10,61,
                "tomatsauce, ost, skinke, champignon og oregano"));

        menuArrayList.add(new Pizza("Hawai",11,61,
                "tomatsauce, ost, skinke, ananas og oregano"));

        menuArrayList.add(new Pizza("Le Blissola",12,61,
                "tomatsauce, ost, skinke, rejer og oregano"));

        menuArrayList.add(new Pizza("Venezia",13,61,
                "tomatsauce, ost, skinke, bacon og oregano"));

        menuArrayList.add(new Pizza("Cacciatore",14,61,
                "tomatsauce, ost, pepperoni, bacon, løg og oregano"));

    }

    public void print(){
        for (int i = 0; i < menuArrayList.size(); i++) {
            System.out.println(menuArrayList.get(i));

        }
    }

}
