package com.learning.java8.stream;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * how to create a Stream
 *
 * @author  Ivan on 2017-12-23 18:22.
 * @version v0.1
 * @since   v1.0
 */

class StreamCreator {

    private static void value() {
        Stream<String> stringStream = Stream.of("Apple", "MicroSoft", "Google", "Facebook", "Amazon");
        Stream<String> emptyStream = Stream.empty();
    }

    private static void array() {
        String[] stringArray = {"Apple", "MicroSoft", "Google", "Facebook", "Amazon"};
        int[] intArray = {0, 1, 1, 2, 3, 5, 8, 13, 21};

        Stream<String> stringStream = Arrays.stream(stringArray);
        IntStream intStream = Arrays.stream(intArray);
        Stream<Integer> integerStream = Arrays.stream(intArray).boxed();
    }

    private static void collection() {
        String[] stringArray = {"Apple", "MicroSoft", "Google", "Facebook", "Amazon"};
        List<String> list = Arrays.asList(stringArray);
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
    }

    private static void file() {
//        Stream<String> lines = Files.lines("a");
    }

    public static void main(String[] args) {
        value();
        array();
    }
}
