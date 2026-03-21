package com.dk.reactivetest02;

import reactor.core.publisher.Flux;

public class ReactiveTest02 {


    static Flux wordFlux(int type) {

//        return switch (type) {
//            case 1 -> Flux.just("Dileep", "Hello", "World", "Kumar").log();
//            case 2 -> Flux.empty().log();
//            case 3 -> Flux.error(new RuntimeException("Some Error Occurred")).log();
//            default -> Flux.just("Default", "None", "Words");
//        };

        return Flux.just("Dileep", "Hello", "World", "Kumar")
                .map( word -> {
//                    if(word.equals("Hello")){
//                        throw new RuntimeException("An Exception occurred from the publisher");
//                    }
                    return word;
                }).log();

    }


    public static void main(String[] args) {

        wordFlux(1).subscribe(word -> System.out.println(word),
                ex -> System.out.println("An Error Occurred"), // error function
                () -> System.out.println("Completed")); // onComplete() consumer called when everything is completed

    }



}
