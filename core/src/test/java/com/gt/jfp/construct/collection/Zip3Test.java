package com.gt.jfp.construct.collection;

import com.gt.jfp.construct.domain.Triple;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Zip3Test {
    @Test
    void Zip3OfEmptyListsShouldBeEmptyList() {
        assertThat(ListUtils.zip3(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()))
                .isEmpty();
    }

    @Test
    void ShouldReturnEmptyListIfOneOfTheListsIsEmpty() {
        assertThat(ListUtils.zip3(Collections.emptyList(), List.of(1, 2, 3),
                Collections.emptyList()))
                .isEmpty();

        assertThat(ListUtils.zip3(List.of(1, 2, 3), Collections.emptyList(),
                Collections.emptyList()))
                .isEmpty();

        assertThat(ListUtils.zip3(Collections.emptyList(), Collections.emptyList(),
                List.of(1, 2, 3)))
                .isEmpty();
    }

    @Test
    void ShouldZipListsOfSameType() {
        assertThat(ListUtils.zip3(List.of(4, 5, 6), List.of(1, 2, 3),
                List.of(9, 10, 11)))
                .isEqualTo(List.of(
                        Triple.of(4, 1, 9),
                        Triple.of(5, 2, 10),
                        Triple.of(6, 3, 11)
                ));
    }

    @Test
    void ShouldZipListsOfDifferentType() {
        assertThat(ListUtils.zip3(List.of(4, 5, 6), List.of("1", "2", "3"),
                List.of(9, 10, 11)))
                .isEqualTo(List.of(
                        Triple.of(4, "1", 9),
                        Triple.of(5, "2", 10),
                        Triple.of(6, "3", 11)
                ));
    }

    @Test
    void ShouldZipListsOfDifferentTypeAndSize() {
        assertThat(ListUtils.zip3(List.of(4, 5), List.of("1", "2", "3"),
                List.of(9, 10, 11)))
                .isEqualTo(List.of(
                        Triple.of(4, "1", 9),
                        Triple.of(5, "2", 10)
                ));
    }
}