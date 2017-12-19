package com.learning.java8.lambda;

import com.learning.java8.Utils;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class LambdaTest {

    public void test() {

        //1
        Runnable runnable = () -> Utils.println("Hello Java 8!");

        //2
        Predicate<String> predicate = (s) -> s == null || "".equals(s);

        //3
        Runnable runnable1 = () -> {
          String user = System.getProperty("user.name");
          Utils.println("Hello " + user);
        };

        //4
        BiPredicate<Object, String> intFunction = (arg1, arg2) -> arg1.equals(arg2);

        //5
        BiFunction<String, String, Boolean> biFunction = (String arg1, String arg2) -> arg1.equals(arg2);

        Comparator.comparing(String::length);
    }

}
