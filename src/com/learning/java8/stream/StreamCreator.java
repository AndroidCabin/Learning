package com.learning.java8.stream;

import com.learning.util.Printer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
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
        try {
            Stream<String> lines = Files.lines(Paths.get(".gitignore"), Charset.forName("utf-8"))
                    .flatMap(line -> Arrays.stream(line.split(" ")));
            lines.forEach(word -> Printer.println(word));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inflate() {
        Stream.iterate(new int[]{0, 1},  t -> new int[] {t[1], t[0] + t[1]})
                .map(t -> t[0])
                .limit(20)
                .forEach(Printer::println);
    }

    private static void inflate2() {
        Stream.generate(Math::random)
                .limit(20)
                .forEach(Printer::println);
    }

    private static void inflate3() {
        IntSupplier supplier = new IntSupplier() {
            private int pre = 0;
            private int cur = 1;

            @Override
            public int getAsInt() {
                int oldPre = pre;
                int oldCur = cur;
                this.pre = cur;
                this.cur = oldPre + oldCur;
                return oldPre;
            }
        };
        IntStream.generate(supplier)
                .limit(20)
                .forEach(Printer::println);
    }

    public static void main(String[] args) {
//        value();
//        array();
//        file();
        inflate3();
    }
}
