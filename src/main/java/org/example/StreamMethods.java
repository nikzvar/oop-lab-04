package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class StreamMethods {
    private StreamMethods() {
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static List<String> uppercaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(value -> "_new_" + value.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    public static List<Integer> squaresOfUnique(List<Integer> numbers) {
        Map<Integer, Long> frequencies = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return numbers.stream()
                .filter(number -> frequencies.get(number) == 1L)
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public static <T> T lastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((previous, current) -> current)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));
    }

    public static int sumEven(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public static Map<Character, String> toMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(value -> value.charAt(0), value -> value.substring(1)));
    }
}
