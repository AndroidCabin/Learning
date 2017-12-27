package com.learning.util;

import java.util.List;
import java.util.stream.IntStream;

public final class Printer {

    public static void println(boolean val) {
        System.out.println(val);
    }

    public static void println(int val) {
        System.out.println(val);
    }

    public static void println(double val) {
        System.out.println(val);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void print(int[] array) {
        System.out.print('[');
        IntStream.of(array)
                .forEach((i) -> {
                    System.out.print(i);
                    System.out.print(',');
                });
        System.out.print(']');
    }

    public static <E> void print(List<E> list) {
        System.out.print('[');
        list.forEach((e) -> {
                    System.out.print(e);
                    if (list.indexOf(e) != list.size() -1) {
                        System.out.print(',');
                    }
                });
        System.out.print(']');
    }
}
