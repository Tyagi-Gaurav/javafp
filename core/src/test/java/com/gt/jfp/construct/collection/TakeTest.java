package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TakeTest {
        @ParameterizedTest
        @NullAndEmptySource
        void TakeOfEmptyListShouldBeEmptyList(List input) {
            assertThat(ListUtils.take(1, input))
                    .isEqualTo(Collections.emptyList());
        }

        @Test
        void TakingLessElementsFromListShouldReturnNewList() {
            assertThat(ListUtils.take(3, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(List.of(1, 2, 3));
        }

        @Test
        void TakingMoreElementsFromListShouldReturnListWithOriginalItems() {
            assertThat(ListUtils.take(7, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(List.of(1, 2, 3, 4, 5));
        }
    }