package com.gt.bm.list.foldl;

import org.apache.commons.lang3.RandomUtils;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class FoldlExecutionPlan {

    @Param({ "100"})
    public int iterations;

    private List<Integer> input;
    private Integer accumulator;
    private BiFunction<Integer, Integer, Integer> func;

    @Setup(Level.Invocation)
    public void setup() {
        int size = RandomUtils.nextInt(20, 100);

        input = IntStream.generate(RandomUtils::nextInt)
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
        accumulator = 0;
        func = Integer::sum;
    }

    public List<Integer> getInput() {
        return input;
    }

    public Integer getAccumulator() {
        return accumulator;
    }

    public BiFunction<Integer, Integer, Integer> getFunc() {
        return func;
    }
}
