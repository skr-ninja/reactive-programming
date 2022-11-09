package com.reactive;

import java.util.stream.IntStream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);
        StreamSources.intNumbersStream().forEach(s -> System.out.println(s));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number -> number < 5).forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5

        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2).forEach(number -> System.out.println(number));

        System.out.println("Print Sequence the second and third numbers in intNumbersStream that's greater than 5");

        IntStream
                .range(1, 10)
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1

        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        Integer value = StreamSources
                .intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);

        System.out.println(value);


        // Print first names of all users in userStream

        StreamSources
                .userStream()
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream

        System.out.println("Print first names in userStream for users that have IDs from number stream");

        // First method
        StreamSources
                .intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id)).
                map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));


        // Second method

        System.out.println("Second method");

        StreamSources
                .userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));


        System.out.println("Third method");

        // Step 1
        var s1 = StreamSources.intNumbersStream();
        // Step 2
        var s2 = s1.flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id));
        // Step 3
        var s3 = s2.map(user -> user.getFirstName());

        s3.forEach(userName -> System.out.println(userName));


    }

}