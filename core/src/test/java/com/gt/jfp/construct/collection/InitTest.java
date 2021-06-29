package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.gt.jfp.construct.collection.ListUtils.initOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InitTest {
    @Test
    void InitOfEmptyListShouldThrowException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> initOf(Collections.emptyList()));
    }

    @Test
    void InitOfNonEmptyListShouldReturnAllButLastElement() {
        assertThat(initOf(List.of(28, 1, 2, 3, 5))).isEqualTo(List.of(28, 1, 2, 3));
    }

    @Test
    void InitOfNonEmptyListWithSingleElementShouldReturnEmptyList() {
        assertThat(initOf(List.of(28))).isEqualTo(Collections.emptyList());
    }
}