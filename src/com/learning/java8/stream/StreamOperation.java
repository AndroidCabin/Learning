package com.learning.java8.stream;

import com.learning.util.TextUtils;
import com.learning.util.Printer;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Stream
 *
 * @author  Ivan on 2017-12-19 23:44.
 * @version v0.1
 * @since   v1.0
 */

class StreamOperation {

    public static void map() {
        List<String> upperCaseList = Stream.of("talk", "is", "cheap", ",", "show", "me", "the", "code")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        Printer.print(upperCaseList);
    }

    public static void flatMap() {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7};
        String[] days = {"Mon", "Tue", "Wen", "Thur", "Fri", "Sat", "Sun"};

        List<Pair<Integer, String>> list = Stream.of(integers)
                .flatMap(i -> Stream.of(days).map(j -> new Pair<>(i, j)))
                .collect(Collectors.toList());
        Printer.print(list);
    }


    public static void flatMap2() {
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] array2 = {2, 3, 5, 7, 11};
        List<Integer[]> list = Stream
                .of(array1)
                .flatMap(a1 -> Stream.of(array2).filter(a1::equals).map(a2 -> new Integer[]{a1, a2}))
                .collect(Collectors.toList());
        Printer.print(list);
    }

    public static void filter() {
        List<String> digitList = Stream.of("a1c", "123", "1q2qw", "0.5")
                .filter(string -> TextUtils.isDigitsOnly(string))
                .collect(Collectors.toList());
        Printer.print(digitList);
    }

    public static void distinct() {
        List<Integer> distinctList = Stream.of(1, 1, 2, 2, 3, 3, 3, 4)
                .distinct()
                .collect(Collectors.toList());
        Printer.print(distinctList);
    }

    public static void limit() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .limit(3)
                .collect(Collectors.toList());
        Printer.print(list);
    }

    public static void skip() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .skip(3)
                .collect(Collectors.toList());
        Printer.print(list);
    }

    public static void reduce() {
        int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element);
        Printer.println(sum);
    }

    public static void anyMatch() {
        boolean hasNullElements = Stream.of("Java", "Python", "C#", null, "Ruby", "Go", "Object C")
                .anyMatch(Objects::isNull);
        Printer.println(hasNullElements);
    }

    public static void findAny() {
        Optional<Integer> optional = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .findAny();
        Printer.println(optional.get());
    }

    public static void findAnySingleThread() {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Printer.println(array.stream().findAny().get());
        Printer.println(array.stream().findAny().get());
        Printer.println(array.stream().findAny().get());
        Printer.println(array.stream().findAny().get());
    }

    public static void findAnyMultiThread() {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        new Thread(() -> Printer.println(array.parallelStream().findAny().get())).start();
        new Thread(() -> Printer.println(array.parallelStream().findAny().get())).start();
        new Thread(() -> Printer.println(array.parallelStream().findAny().get())).start();
        new Thread(() -> Printer.println(array.parallelStream().findAny().get())).start();
    }

    public static void findAnyParallelStream() {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Printer.println(array.parallelStream().findAny().get());
        Printer.println(array.parallelStream().findAny().get());
        Printer.println(array.parallelStream().findAny().get());
        Printer.println(array.parallelStream().findAny().get());
    }

    public static void range() {
        IntStream intStream = IntStream.range(1, 10);
        int[] array = intStream.toArray();
        Printer.print(array);
    }

    public static void rangeClosed() {
        IntStream intStream = IntStream.rangeClosed(1, 10);
        int[] array = intStream.toArray();
        Printer.print(array);
    }

    public static void main(String[] args) {
//        StreamOperation.flatMap();
//        StreamOperation.map();
//        StreamOperation.filter();
//        StreamOperation.distinct();
//        StreamOperation.limit();
//        StreamOperation.skip();
//        StreamOperation.anyMatch();
//        StreamOperation.findAny();
//        StreamOperation.findAnyParallelStream();
//        StreamOperation.range();
        StreamOperation.rangeClosed();
    }
}
