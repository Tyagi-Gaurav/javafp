package com.gt.jfp.construct.collection;

import com.gt.jfp.construct.domain.Triple;
import com.gt.jfp.construct.domain.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtils {

    private ListUtils() {
    }

    /**
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
    public static <T> List<T> initOf(List<T> input) {
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
    public static <T> List<T> reverse(List<T> input) {
        if (input.isEmpty())
            return Collections.emptyList();
        else {
            List<T> output = new ArrayList<>(reverse(tailOf(input)));
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
    public static <T> List<T> take(int count, List<T> input) {
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
    public static <T> List<T> drop(int count, List<T> input) {
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
    public static <T extends Number> double sum(List<T> input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return input.stream().mapToDouble(Number::doubleValue).sum();
    }

    /**
     * zips together 2 lists to return a list of tuples.
     *
     * @param aList
     * @param bList
     * @param <A>
     * @param <B>
     * @return List<Tuple>
     */
    public static <A, B> List<Tuple<A, B>> zip(List<A> aList, List<B> bList) {
        return IntStream.range(0, Math.min(aList.size(), bList.size()))
                .mapToObj(i -> Tuple.of(aList.get(i), bList.get(i)))
                .collect(Collectors.toList());
    }

    /**
     * Zips together 3 lists
     *
     * @param aList
     * @param bList
     * @param cList
     * @param <A>
     * @param <B>
     * @param <C>
     * @return List<Triple>
     */
    public static <A, B, C> List<Triple<A, B, C>> zip3(List<A> aList,
                                                       List<B> bList,
                                                       List<C> cList) {
        List<Tuple<A, B>> zippedList = zip(aList, bList);

        return IntStream.range(0, Math.min(zippedList.size(), cList.size()))
                .mapToObj(i -> Triple.of(zippedList.get(i).getFirst(),
                        zippedList.get(i).getSecond(), cList.get(i)))
                .collect(Collectors.toList());
    }

    public static <T, R> R foldl(List<T> input, R initial, BiFunction<R, T, R> func) {
        if (input == null || input.isEmpty())
            return initial;

        return foldl(tailOf(input), func.apply(initial, headOf(input)), func);
    }
}
