package com.dk.reactivetest03;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class ReactiveTest03 {
    public static void main(String[] args) {
        Flux<String> wordFlux = Flux.just("Dileep", "Hello", "World", "Anil","Dileep", "Hello", "World", "Anil","Dileep", "Hello", "World", "Anil","Dileep", "Hello", "World", "Anil");
        wordFlux.subscribe(new WordSubscriber());
        Flux.just(wordFlux, wordFlux).subscribe(System.out::println);

    }
}
// we can implement only the required methods when we extend BaseSubscriber class
class WordSubscriber extends BaseSubscriber<String> {

    Subscription subscription;

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscription Successful");
//        subscription.request(Long.MAX_VALUE); // to get all data
        subscription.request(1);
    }

    @Override
    protected void hookOnNext(String value) {
//        if(value.equals("World")) { // mot recommended
//            cancel();
//        }
        System.out.println(value);
        // Back pressuring
        subscription.request(1);
    }


    @Override
    protected void hookOnComplete() {
        System.out.println("Completed.............");
    }
}
