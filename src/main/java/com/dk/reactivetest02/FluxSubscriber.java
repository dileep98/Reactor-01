package com.dk.reactivetest02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FluxSubscriber implements Subscriber {
    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("Inside onSubscribe()");
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("Inside onNext()");
        if(o.equals("Hello")) throw new RuntimeException("Runtime Exception");
        System.out.println(o);

    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Inside onError()");

    }

    @Override
    public void onComplete() {
        System.out.println("Inside onComplete()");

    }
}
