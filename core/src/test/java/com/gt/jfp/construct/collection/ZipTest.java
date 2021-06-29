package com.gt.jfp.construct.collection;

import com.gt.jfp.construct.domain.Tuple;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ZipTest {
        @Test
        void ZipOfEmptyListsShouldBeEmptyList() {
            assertThat(ListUtils.zip(Collections.emptyList(), Collections.emptyList()))
                    .isEmpty();
        }

        @Test
        void ShouldReturnEmptyListIfOneOfTheListsIsEmpty() {
            assertThat(ListUtils.zip(Collections.emptyList(), List.of(1, 2, 3)))
                    .isEmpty();

            assertThat(ListUtils.zip(List.of(1, 2, 3), Collections.emptyList()))
                    .isEmpty();
        }

        @Test
        void ShouldZipListsOfSameType() {
            assertThat(ListUtils.zip(List.of(4, 5, 6), List.of(1, 2, 3)))
                    .isEqualTo(List.of(
                        Tuple.of(4, 1),
                        Tuple.of(5, 2),
                        Tuple.of(6, 3)
                    ));
        }

        @Test
        void ShouldZipListsOfDifferentType() {
            assertThat(ListUtils.zip(List.of("4", "5", "6"), List.of(1, 2, 3)))
                    .isEqualTo(List.of(
                            Tuple.of("4", 1),
                            Tuple.of("5", 2),
                            Tuple.of("6", 3)
                    ));
        }

        @Test
        void ShouldZipListsOfDifferentTypeAmdSize() {
            assertThat(ListUtils.zip(List.of("4", "5"), List.of(1, 2, 3)))
                    .isEqualTo(List.of(
                            Tuple.of("4", 1),
                            Tuple.of("5", 2)
                    ));
        }
    }