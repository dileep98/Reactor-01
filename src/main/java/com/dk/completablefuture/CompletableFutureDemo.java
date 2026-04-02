package com.dk.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    public String getName() {

        System.out.println("getName() executed by : "+ Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Hello World";
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("main() executed by : "+ Thread.currentThread().getName());


        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
//        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
//            @Override
//            public String get() {
//                return completableFutureDemo.getName();
//            }
//        });
//
//        String value = stringCompletableFuture.join(); // still blocking
//        System.out.println(value);

        CompletableFuture.supplyAsync(completableFutureDemo::getName)
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);

        System.out.println("Done...");

        Thread.sleep(3000);


        
    }
}
