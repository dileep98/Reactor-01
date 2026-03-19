package com.dk.observerdesignpattern;

public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer = new Observer("Dileep");
        Observer observer1 = new Observer("Kumar");
        Observer observer2 = new Observer("Anil");
        Observer observer3 = new Observer("Raju");
        subject.add(observer);
        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);
//        subject.unregister(observer);

        subject.setPrice(2000);
        subject.setPrice(4000);
        subject.unregister(observer);
        subject.setPrice(1500);
    }

}
