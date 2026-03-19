package com.dk.observerdesignpattern;

public class Observer {
    private int price;
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    public void update(int price){
        this.price = price;
        displayLatestPrice();
    }

    public void displayLatestPrice(){
        System.out.println("Latest Price from Observer "+this.getName()+ " is:"+ price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
