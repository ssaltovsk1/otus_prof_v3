package test;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparisonMethods {

    public static void comparison(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(expected + " != " + actual + "\n");
        } else {
            System.out.println("Тест на сравнение int прошел");
        }
    }

    public static void comparison(String expected, String actual) {
        if (!(expected.equals(actual))) {
            throw new AssertionError((expected + " != " + actual + "\n"));
        } else {
            System.out.println("Тест на сравнение String прошел");
        }
    }

    public static void comparison(Object expected, Object actual) {

        if (!(expected.equals(actual))) {
            throw new AssertionError((expected + " != " + actual + "\n"));
        } else {
            System.out.println("Тест на сравнение Object прошел");
        }
    }
}
