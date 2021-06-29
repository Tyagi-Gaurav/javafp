package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseTest {
    @Test
    void ReverseOfEmptyListShouldBeEmptyList() {
        assertThat(ListUtils.reverse(Collections.emptyList()))
                .isEqualTo(Collections.emptyList());
    }

    @Test
    void ShouldReverseANonEmptyList() {
        assertThat(ListUtils.reverse(List.of(1, 2, 3)))
                .isEqualTo(List.of(3, 2, 1));
    }

    //TODO Benchmark test on Reversing a really long list
}