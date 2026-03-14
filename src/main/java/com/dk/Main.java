package com.dk;

import reactor.core.publisher.Flux;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        StreamUtils.wordStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Flux<Integer> fluxOfNumbers = Flux.just(1, 2, 3, 4, 5);
        fluxOfNumbers.subscribe(System.out::println); // unlike stream, flux can be subscribed more than once
        fluxOfNumbers.subscribe(System.out::println);

        // Pushing the data (pub sub)
        System.out.println(ReactiveStreamUtils.wordsStreamReactive()); // prints nothing
        ReactiveStreamUtils.wordsStreamReactive() // pushing (publisher)
                .subscribe(System.out::println); // the subscriber subscribes to the publisher(Flux)


        Scanner sc = new Scanner(System.in);
        System.out.println("Press any key to exit the program");
        sc.nextLine();

    }
}