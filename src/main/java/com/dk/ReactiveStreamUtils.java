package com.dk;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class ReactiveStreamUtils {

    public static Flux<String> wordsStreamReactive(){
        return Flux.just("Fun", "Java", "Learning", "Hello")
                .delayElements(Duration.ofMillis(2000));
    }
}
