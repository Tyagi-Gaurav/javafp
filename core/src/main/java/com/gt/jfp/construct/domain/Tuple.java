package com.gt.jfp.construct.domain;

import java.util.Objects;

public class Tuple<A, B> {
    A first;
    B second;

    public Tuple(A first, B b) {
        this.first = first;
        this.second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public static <A, B> Tuple of(A a, B b) {
        return new Tuple(a, b);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(first, tuple.first) && Objects.equals(second, tuple.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
