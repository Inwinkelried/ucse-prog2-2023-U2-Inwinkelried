package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class StreamBenchmark {
    @Param({"10000000"})
    private int size;
    private List<Integer> list;
    @Setup
    public void setup() {
        Random random = new Random();
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 50000));
        }
    }
    @Benchmark
    public void sequentialFilter(Blackhole bh) {
        List<Integer> result = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        bh.consume(result);
    }
    @Benchmark
    public void parallelFilter(Blackhole bh) {
        List<Integer> result = list.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        bh.consume(result);
    }
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}