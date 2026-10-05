package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Среднее: " + StreamMethods.average(List.of(1, 2, 3, 4)));
        System.out.println("Строки: " + StreamMethods.uppercaseWithPrefix(List.of("hello", "мир")));
        System.out.println("Квадраты уникальных: " + StreamMethods.squaresOfUnique(List.of(2, 3, 2, 4, 5, 5)));
        System.out.println("Последний элемент: " + StreamMethods.lastElement(List.of("a", "b", "c")));
        System.out.println("Сумма чётных: " + StreamMethods.sumEven(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Map: " + StreamMethods.toMap(List.of("apple", "banana", "cherry")));
    }
}
