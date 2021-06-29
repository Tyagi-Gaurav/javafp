package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static com.gt.jfp.construct.collection.ListUtils.tailOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class TailTest {
    @ParameterizedTest
    @NullAndEmptySource
    void tailOfEmptyListShouldThrowException(List input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> tailOf(input));
    }

    @Test
    void tailOfNonEmptyListShouldReturnEverythingAfterTheFirstElement() {
        assertThat(tailOf(List.of(1, 2, 4, 28))).isEqualTo(List.of(2, 4, 28));
    }
}