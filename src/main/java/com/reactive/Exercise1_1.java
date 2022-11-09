package com.reactive;

import java.util.stream.IntStream;

public class Exercise1_1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Method 1");
        IntStream.range(0,10).forEach(x->System.out.println(x));
        // Using method references
        IntStream.range(0,10).forEach(System.out::println);

        System.out.println("Method 2");

        System.out.println("Using Range Closed");

        IntStream.rangeClosed(0,10).forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print the number less than 5");
        IntStream.range(1,10).filter(x->x<5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        IntStream.range(1,10).forEach(x->{
            if(x==6){
                System.out.println(x);
            }
            else{
                System.out.println("-1");
            }
        });

        // Print first names of all users in userStream
        System.out.println("Print ALL FIRST NAMES  Using Method References");
        // Using Method References
        StreamSources.userStream().map(User::getFirstName).forEach(System.out::println);
        // Using Lambda
        System.out.println("Print ALL FIRST NAMES  Using Lambda ");
        StreamSources.userStream().map(user->user.getFirstName()).forEach(System.out::println);


        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

    }
}
