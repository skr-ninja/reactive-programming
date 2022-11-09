package com.reactive;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e));

        //  Multiple Subscribe
        Flux<Integer> stream = ReactiveSources.intNumbersFlux();
        stream.subscribe(e -> System.out.println("First Stream: " + e));
        stream.subscribe(e -> System.out.println("Second Stream: " + e));
        stream.subscribe(e -> System.out.println("Third Stream: " + e));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");

        System.in.read();
    }

}