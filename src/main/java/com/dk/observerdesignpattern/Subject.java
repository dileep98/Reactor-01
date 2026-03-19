package com.dk.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private int price = 1000;

    List<Observer> observers = new ArrayList<>();




    public void add(Observer observer){
        observers.add(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        notifyAllObservers();
    }

    private void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update(price);
        }
    }
}
