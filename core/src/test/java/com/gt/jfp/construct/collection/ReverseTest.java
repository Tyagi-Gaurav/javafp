package com.gt.jfp.construct.collection;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.Duration.ofMillis;
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

    /*
    Benchmark is 4ms +/- 1ms, but a single shot cold start takes slightly
    longer.
     */
    @Test
    void shouldReverseARandomLargeListWithinSpecifiedTime() {
        org.junit.jupiter.api.Assertions.assertTimeout
                (ofMillis(25), () -> ListUtils.reverse(getListOfSize(50)));
    }

    private List<Integer> getListOfSize(int size) {
        return IntStream.generate(RandomUtils::nextInt)
                .limit(size)
                .boxed().collect(Collectors.toList());
    }
}