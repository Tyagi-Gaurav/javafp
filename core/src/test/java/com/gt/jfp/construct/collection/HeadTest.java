package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static com.gt.jfp.construct.collection.ListUtils.headOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeadTest {
    @ParameterizedTest
    @NullAndEmptySource
    void headOfEmptyListShouldThrowException(List actual) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> headOf(actual));
    }

    @Test
    void headOfNonEmptyListShouldReturnFirstElement() {
        //given
        List<Integer> input = List.of(28, 1, 2, 3, 5);

        //when
        assertThat(headOf(input)).isEqualTo(28);
    }
}