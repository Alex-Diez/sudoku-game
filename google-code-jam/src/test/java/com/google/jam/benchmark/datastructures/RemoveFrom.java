package com.google.jam.benchmark.datastructures;

import java.util.concurrent.TimeUnit;

import com.google.jam.benchmark.datastructures.states.ArrayQueueState;
import com.google.jam.benchmark.datastructures.states.DataState;
import com.google.jam.benchmark.datastructures.states.FairArrayBlockingQueueState;
import com.google.jam.benchmark.datastructures.states.LastIndexLinkedBlockingQueueState;
import com.google.jam.benchmark.datastructures.states.LinkedBlockingQueueState;
import com.google.jam.benchmark.datastructures.states.LinkedQueueState;
import com.google.jam.benchmark.datastructures.states.UnfairArrayBlockingQueueState;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import static com.google.jam.benchmark.datastructures.QueuesBenchmarks.CPU_TOKENS;

public class RemoveFrom {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void ArrayQueue(final ArrayQueueState arrayQueueState)
            throws Exception {
        Blackhole.consumeCPU(CPU_TOKENS);
        arrayQueueState.getLargeQueue().remove();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void LinkedQueue(final LinkedQueueState linkedQueueState)
            throws Exception {
        Blackhole.consumeCPU(CPU_TOKENS);
        linkedQueueState.getLargeQueue().remove();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void FairArrayBlockingQueue(
            final FairArrayBlockingQueueState fairArrayBlockingQueueState,
            final DataState dataState)
            throws Exception {
        Blackhole.consumeCPU(CPU_TOKENS);
        fairArrayBlockingQueueState.getLargeQueue().remove();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void UnfairArrayBlockingQueue(
            final UnfairArrayBlockingQueueState unfairArrayBlockingQueueState,
            final DataState dataState)
            throws Exception {
        Blackhole.consumeCPU(CPU_TOKENS);
        unfairArrayBlockingQueueState.getLargeQueue().remove();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void LinkedBlockingQueue(
            final LinkedBlockingQueueState linkedBlockingQueueState,
            final DataState dataState)
            throws Exception {
        Blackhole.consumeCPU(CPU_TOKENS);
        linkedBlockingQueueState.getLargeQueue().remove();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void LastIndexLinkedBlockingQueue(
            final LastIndexLinkedBlockingQueueState lastIndexLinkedBlockingQueueState,
            final DataState dataState)
            throws Exception {
        Blackhole.consumeCPU(CPU_TOKENS);
        lastIndexLinkedBlockingQueueState.getLargeQueue().remove();
    }
}
