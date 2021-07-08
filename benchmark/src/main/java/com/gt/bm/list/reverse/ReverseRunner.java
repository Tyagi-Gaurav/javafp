package com.gt.bm.list.reverse;

import com.gt.jfp.construct.collection.ListUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ReverseRunner {

    @Benchmark
    @Fork(value = 1, warmups = 1) //Run 1 warmup forks and after the run discard results before real run.
    @BenchmarkMode(Mode.Throughput)
    public void benchReverseThroughput(ReverseExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            ListUtils.reverse(plan.getInput());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void benchReverse(ReverseExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            ListUtils.reverse(plan.getInput());
        }
    }

}
