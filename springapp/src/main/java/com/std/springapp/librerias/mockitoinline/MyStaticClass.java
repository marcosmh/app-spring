package com.std.springapp.librerias.mockitoinline;

public class MyStaticClass {

    public static String helloWorld(String name) {
        return String.format("Welcome %s", name);
    }

    public static Integer otherFunction() {
        return 20;
    }
}
