package com.dk.reactiveprogramming_02.subscriber;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriptionImpl implements Subscription {
    private Subscriber subscriber;

    private Faker faker = Faker.instance();

    private final int MAX_DATA = 10;
    private int count = 0;
    private boolean isSubscribed = false;

    public SubscriptionImpl(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        if(isSubscribed) {
            return;
        }
        System.out.println("Subscriber has requested "+n+ " data.");
        for(int i = 0; i<n && count<MAX_DATA; i++){
            subscriber.onNext(faker.name().firstName());
            count++;
        }
        if(count == MAX_DATA) {
            System.out.println("Publisher has emitted all data");
            subscriber.onComplete();
        }
    }

    @Override
    public void cancel() {
        isSubscribed = true;
        System.out.println("Subscriber has cancelled the subscription");
    }


}
