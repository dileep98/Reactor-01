package com.dk.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Gold implements ISubject{

    private int price = 1000;

    List<IObserver> observers = new ArrayList<>();


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        System.out.println("Price changed to : "+ price);
        this.price = price;
        notifyAllObservers();
    }

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(){
        for(IObserver observer : observers){
            observer.update(price);
        }
    }
}
