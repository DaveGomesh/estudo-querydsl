package com.estudo.QueryDSL.utils;

import java.util.Collection;

public class Printter {

    public static void print(Object object){
        System.out.println("\n=====================================");
        System.out.println(object);
        System.out.println("=====================================\n");
    }

    public static void printList(Collection<?> list){
        System.out.println("\n=====================================");
        list.forEach(System.out::println);
        System.out.println("=====================================\n");
    }

    public static void printList(Iterable<?> list){
        System.out.println("\n=====================================");
        list.forEach(System.out::println);
        System.out.println("=====================================\n");
    }
}
