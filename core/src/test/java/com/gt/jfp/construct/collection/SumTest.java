package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SumTest {
    @ParameterizedTest
    @NullAndEmptySource
    void SumOfEmptyListShouldBeZero(List input) {
        assertThat(ListUtils.sum(input))
                .isEqualTo(0.0);
    }

    @Test
    void ShouldComputeSumOfNonEmptyList() {
        assertThat(ListUtils.sum(List.of(1, 2, 3)))
                .isEqualTo(6.0);
    }

    @Test
    void ShouldComputeSumOfNonEmptyDoubleList() {
        assertThat(ListUtils.sum(List.of(1.1, 2.7, 3.18)))
                .isEqualTo(6.98);
    }
}