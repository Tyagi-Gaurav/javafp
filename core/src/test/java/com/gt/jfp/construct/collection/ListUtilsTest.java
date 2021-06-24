package com.gt.jfp.construct.collection;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Collections;
import java.util.List;

import static com.gt.jfp.construct.collection.ListUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ListUtilsTest {

    @Nested
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

    @Nested
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

    @Nested
    class InitTest {
        @Test
        void InitOfEmptyListShouldThrowException() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> InitOf(Collections.emptyList()));
        }

        @Test
        void InitOfNonEmptyListShouldReturnAllButLastElement() {
            assertThat(InitOf(List.of(28, 1, 2, 3, 5))).isEqualTo(List.of(28, 1, 2, 3));
        }

        @Test
        void InitOfNonEmptyListWithSingleElementShouldReturnEmptyList() {
            assertThat(InitOf(List.of(28))).isEqualTo(Collections.emptyList());
        }
    }

    @Nested
    class ReverseTest {
        @Test
        void ReverseOfEmptyListShouldBeEmptyList() {
            assertThat(ListUtils.Reverse(Collections.emptyList()))
                    .isEqualTo(Collections.emptyList());
        }

        @Test
        void ShouldReverseANonEmptyList() {
            assertThat(ListUtils.Reverse(List.of(1, 2, 3)))
                    .isEqualTo(List.of(3, 2, 1));
        }

        //TODO Benchmark test on Reversing a really long list
    }

    @Nested
    class TakeTest {
        @ParameterizedTest
        @NullAndEmptySource
        void TakeOfEmptyListShouldBeEmptyList(List input) {
            assertThat(ListUtils.Take(1, input))
                    .isEqualTo(Collections.emptyList());
        }

        @Test
        void TakingLessElementsFromListShouldReturnNewList() {
            assertThat(ListUtils.Take(3, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(List.of(1, 2, 3));
        }

        @Test
        void TakingMoreElementsFromListShouldReturnListWithOriginalItems() {
            assertThat(ListUtils.Take(7, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(List.of(1, 2, 3, 4, 5));
        }
    }

    @Nested
    class DropTest {
        @ParameterizedTest
        @NullAndEmptySource
        void DropOfEmptyListShouldBeEmptyList(List input) {
            assertThat(ListUtils.Drop(1, input))
                    .isEqualTo(Collections.emptyList());
        }

        @Test
        void DroppingLessElementsFromListShouldReturnNewList() {
            assertThat(ListUtils.Drop(3, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(List.of(4, 5));
        }

        @Test
        void DroppingMoreElementsFromListShouldReturnEmptyList() {
            assertThat(ListUtils.Drop(7, List.of(1, 2, 3, 4, 5)))
                    .isEqualTo(Collections.emptyList());
        }
    }

    @Nested
    class SumTest {
        @ParameterizedTest
        @NullAndEmptySource
        void SumOfEmptyListShouldBeZero(List input) {
            assertThat(ListUtils.Sum(input))
                    .isEqualTo(0.0);
        }

        @Test
        void ShouldComputeSumOfNonEmptyList() {
            assertThat(ListUtils.Sum(List.of(1, 2, 3)))
                    .isEqualTo(6.0);
        }

        @Test
        void ShouldComputeSumOfNonEmptyDoubleList() {
            assertThat(ListUtils.Sum(List.of(1.1, 2.7, 3.18)))
                    .isEqualTo(6.98);
        }
    }
}