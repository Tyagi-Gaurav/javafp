package com.gt.jfp.construct.collection;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.Duration.ofMillis;
import static org.assertj.core.api.Assertions.assertThat;

class FoldlTest {
    @ParameterizedTest
    @NullAndEmptySource
    void FoldlOfEmptyListShouldBeSameAsAccumulator(List input) {
        assertThat(ListUtils.foldl(input, 7, Integer::sum))
                .isEqualTo(7);
    }

    @Test
    void FoldlShouldSumOfList() {
        assertThat(ListUtils.foldl(List.of(1, 2, 3, 4, 5), 0, Integer::sum))
                .isEqualTo(15);
    }

    @Test
    void FoldlShouldCheckElementExistence() {
        assertThat(ListUtils.foldl(List.of(1, 4, 4, 4, 5), false, (a, b) -> a || b == 4))
                .isTrue();
    }

    /*
    Benchmark is 4ms +/- 1ms, but a single shot cold start takes slightly
    longer.
     */
    @Test
    void shouldFoldlARandomLargeListWithinSpecifiedTime() {
        org.junit.jupiter.api.Assertions.assertTimeout
                (ofMillis(25), () -> ListUtils
                        .foldl(getListOfSize(50), 0, Integer::sum));
    }

    private List<Integer> getListOfSize(int size) {
        return IntStream.generate(RandomUtils::nextInt)
                .limit(size)
                .boxed().collect(Collectors.toList());
    }
}