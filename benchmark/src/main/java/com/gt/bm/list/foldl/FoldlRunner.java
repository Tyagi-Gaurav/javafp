package com.gt.bm.list.foldl;

import com.gt.jfp.construct.collection.ListUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class FoldlRunner {

    @Benchmark
    @Fork(value = 1, warmups = 1) //Run 1 warmup forks and after the run discard results before real run.
    @BenchmarkMode(Mode.Throughput)
    public void benchFoldlThroughput(FoldlExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            ListUtils.foldl(plan.getInput(), plan.getAccumulator(), plan.getFunc());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void benchFoldlAverageTime(FoldlExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            ListUtils.foldl(plan.getInput(), plan.getAccumulator(), plan.getFunc());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void benchFoldlSingleShotTime(FoldlExecutionPlan plan) {
        for (int i = plan.iterations; i > 0; i--) {
            ListUtils.foldl(plan.getInput(), plan.getAccumulator(), plan.getFunc());
        }
    }
}
