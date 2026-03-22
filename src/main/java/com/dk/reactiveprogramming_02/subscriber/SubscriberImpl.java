package com.dk.reactiveprogramming_02.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberImpl implements Subscriber<String> {


    private Subscription subscription;


    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscription Successful..");
        this.subscription = subscription;
//        subscription.request(10);
    }

    @Override
    public void onNext(String data) {
        System.out.println("onNext() Called");
        System.out.println("Data Received: "+ data);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {
        System.out.println("onComplete() called");
    }

    public Subscription getSubscription() {
        return subscription;
    }
}
