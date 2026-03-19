package com.dk.observerdesignpattern;

public class Client {

    public static void main(String[] args) {
        Gold goldSubject = new Gold();

        GoldTrackerApp observer = new GoldTrackerApp("Dileep", goldSubject);
        GoldTrackerApp observer1 = new GoldTrackerApp("Kumar", goldSubject);
        GoldTrackerApp observer2 = new GoldTrackerApp("Anil", goldSubject);
        GoldTrackerApp observer3 = new GoldTrackerApp("Raju", goldSubject);
//        goldSubject.add(observer);
//        goldSubject.add(observer1);
//        goldSubject.add(observer2);
//        goldSubject.add(observer3);
//        subject.unregister(observer);

        goldSubject.setPrice(2000);
        goldSubject.setPrice(4000);
        goldSubject.remove(observer);
        goldSubject.setPrice(1500);
    }

}
