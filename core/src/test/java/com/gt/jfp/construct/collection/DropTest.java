package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DropTest {
        @ParameterizedTest
        @NullAndEmptySource
        void DropOfEmptyListShouldBeEmptyList(List input) {
            assertThat(ListUtils.drop(1, input))
                    .isEqualTo(Collections.emptyList());
        }

        @Test
        void DroppingLessElementsFromListShouldReturnNewList() {
            assertThat(ListUtils.drop(3, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(List.of(4, 5));
        }

        @Test
        void DroppingMoreElementsFromListShouldReturnEmptyList() {
            assertThat(ListUtils.drop(7, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(Collections.emptyList());
        }
    }