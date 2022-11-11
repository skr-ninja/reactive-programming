package com.reactive;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // First Way
         ReactiveSources.intNumberMono().subscribe(number->System.out.println(number));

         // Second Way
         ReactiveSources.intNumberMono().subscribe(
                 number->System.out.println(number),
                 err->System.out.println(err.getMessage())
                 );

         // Third Way

        ReactiveSources.intNumberMono().subscribe(
                number->System.out.println(number),
                err->System.out.println(err.getMessage()),
        ()->System.out.println("Complete")
        );
        // Get the value from the Mono into an integer variable
       Integer integer= ReactiveSources.intNumberMono().block();

       User user=ReactiveSources.userMono().block();
        //Optional<Integer> integer1= ReactiveSources.intNumberMono().blockOptional();

        System.out.println("Press a key to end");
        System.in.read();
    }

}