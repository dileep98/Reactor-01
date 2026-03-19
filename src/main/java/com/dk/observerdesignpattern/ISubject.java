package com.dk.observerdesignpattern;


public interface ISubject {

    public void add(IObserver observer);

    public void remove(IObserver observer);

    public void notifyAllObservers();
}
