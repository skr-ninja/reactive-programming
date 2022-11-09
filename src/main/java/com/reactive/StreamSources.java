package com.reactive;

import java.util.stream.Stream;

/**
 * @author Sunil Kumar Rathour
 */
public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(1, "Sunil", "Rathour"),
                new User(2, "Radhe", "Shyam"),
                new User(2, "Mohan", "Satle"),
                new User(4, "Rohan", "Goyal"),
                new User(5, "Peetam", "Jadon"),
                new User(6, "Shyam", "Bhargav")
        );
    }
}
