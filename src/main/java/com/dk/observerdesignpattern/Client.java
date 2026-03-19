package com.dk.observerdesignpattern;

public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer = new Observer("Dileep");
        Observer observer1 = new Observer("Kumar");
        subject.add(observer);
        subject.add(observer1);

        subject.setPrice(2000);
        subject.setPrice(4000);
    }

}
