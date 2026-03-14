package com.dk.streamtest;

import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Hello", "WOrld", "Fun", "Coding");
        System.out.println(stringStream); // prints nothing because streams are lazy and needs to be consumed
        stringStream
                .forEach(System.out::println);// foreach is pulling the data

        // Observe the outputs for the below

        // foreach asks data to peek() then to peek() then to stream()
        Stream.of(1,2,3,4,5,6,7,8,9)
                .peek(no-> System.out.print("\nA"+no)) // returns stream because peek is a intermediate operation
                .peek(no-> System.out.print("B"+no)) // return stream
                .forEach(no-> System.out.print("C"+no)); // consumes stream doesn't return anything
        System.out.println("\n**************************************");
//        foreach() -> peek() -> limit() -> peek() -> stream()
        Stream.of(1,2,3,4,5,6,7,8,9)
                .peek(no-> System.out.print("\nA"+no)) // returns stream because peek is an intermediate operation
                .limit(4) // This is a short-circuiting stateful intermediate operation.
                .peek(no-> System.out.print("B"+no)) // return stream
                .forEach(no-> System.out.print("C"+no)); // consumes stream doesn't return anything
        System.out.println("\n**************************************");
        //        foreach() -> peek() -> skip() -> peek() -> stream()
        Stream.of(1,2,3,4,5,6,7,8,9)
                .peek(no-> System.out.print("\nA"+no)) // returns stream because peek is a intermediate operation
                .skip(5) // This is a stateful intermediate operation. not a short-circuiting operation
                .peek(no-> System.out.print("B"+no)) // return stream
                .forEach(no-> System.out.print("C"+no)); // consumes stream doesn't return anything
    }
}
