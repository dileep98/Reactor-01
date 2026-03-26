package com.dk.reactiveprogramming_02;

import com.dk.reactiveprogramming_02.publisher.PublisherImpl;
import com.dk.reactiveprogramming_02.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class App {
    public static void main(String[] args) {
        Publisher publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
//        subscriber.getSubscription().request(Long.MAX_VALUE);

        subscriber.getSubscription().request(2);
        subscriber.getSubscription().request(2);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }


}
