package com.gt.jfp.construct.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtils {

    private ListUtils() {}

    /**
     *
     * @param input
     * @return First element of the input
     * @throws IllegalArgumentException if the input is empty or null
     */
    public static <T> T headOf(List<T> input) {
        if (Objects.isNull(input) || input.isEmpty())
            throw new IllegalArgumentException();

        return input.get(0);
    }

    /**
     *
     * @param input
     * @return Everything after the first element of the input
     * @throws IllegalArgumentException if the input is empty or null
     */
    public static <T> List<T> tailOf(List<T> input) {
        if (Objects.isNull(input) || input.isEmpty())
            throw new IllegalArgumentException();

        if (input.size() == 1)
            return Collections.emptyList();
        else {
            return IntStream.rangeClosed(1, input.size() - 1)
                    .mapToObj(input::get)
                    .collect(Collectors.toList());
        }
    }

    /**
     * Return everything but the last element of the input
     *
     * @param input
     * @return Everything but the last element of the list
     * @throws IllegalArgumentException if the input is empty or null
     */
    public static <T> List<T> InitOf(List<T> input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (input.size() == 1)
            return Collections.emptyList();
        else {
            return IntStream.range(0, input.size() - 1)
                    .mapToObj(input::get)
                    .collect(Collectors.toList());
        }
    }

    /**
     * Reverses a list
     *
     * @param input
     * @param <T>
     * @return
     */
    public static <T> List<T> Reverse(List<T> input) {
        if (input.isEmpty())
            return Collections.emptyList();
        else {
            List<T> output = new ArrayList<>(Reverse(tailOf(input)));
            output.add(headOf(input));
            return output;
        }
    }

    /**
     * Return the first <code>count</code> elements from the list
     *
     * @param count
     * @param input
     * @param <T>
     * @return
     */
    public static <T> List<T> Take(int count, List<T> input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        return input.stream().limit(Math.min(count, input.size()))
                .collect(Collectors.toList());
    }

    /**
     * Return the elements of list after dropping the first
     * <code>count</code> elements from the list.
     *
     * @param count
     * @param input
     * @param <T>
     * @return
     */
    public static <T> List<T> Drop(int count, List<T> input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        return input.stream().skip(Math.min(count, input.size()))
                .collect(Collectors.toList());
    }

    /**
     * Return the sum of all the elements of a list
     *
     * @param input
     * @param <T>
     * @return
     */
    public static <T extends Number> double Sum(List<T> input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return input.stream().mapToDouble(Number::doubleValue).sum();
    }
}
