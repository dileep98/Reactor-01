package com.dk.reactivetest01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ReactiveTest {

    public static void main(String[] args) {
        Flux<String> nameFlux = Flux.just("Hello", "World", "Test", "Dileep", "Anil");//.log();
//        nameFlux.subscribe(System.out::println);
        nameFlux.subscribe(new MySubscriber());
//        nameFlux.subscribe();

    }
}

class MySubscriber implements Subscriber<String>{

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
        System.out.println();
    }

    @Override
    public void onNext(String data) {
        System.out.println("onNext() called");
        System.out.println("Data Received: "+ data);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError() called");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete() called");
    }
}
