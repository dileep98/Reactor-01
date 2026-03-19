package com.dk.observerdesignpattern;

public class GoldTrackerApp implements IObserver {
    private int price;
    private String name;
    private Gold gold;

    public GoldTrackerApp(String name, Gold gold) {
        this.name = name;
        this.gold = gold;
        this.gold.add(this);
    }

    @Override
    public void update(int price){
        this.price = price;
        displayLatestPrice();
    }

    private void displayLatestPrice(){
        System.out.println("Latest Price from Observer "+this.getName()+ " is:"+ price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
