package com.codewars.fizzbuzz;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergey Golitsyn
 * created on 09.12.2023
 */
public class ParallelFizzBuzz2 {
    private static final int LIMIT = 1_000_000;
    private static final int NUM_THREADS = 6;

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.AverageTime)
    public static void init4() {
        int chunkSize = LIMIT / NUM_THREADS;

        List<CompletableFuture<List<String>>> futures = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * chunkSize + 1;
            final int end = (i + 1) * chunkSize;
            CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
                return printFizzBuzzInRange(start, end);
            });
            futures.add(future);
        }

        List<String> results = futures.stream()
                .map(CompletableFuture::join) // Wait for each CompletableFuture to complete
                .collect(ArrayList::new, List::addAll, List::addAll);

        // Print the results
        System.out.println(results.size());
    }

    private static List<String> printFizzBuzzInRange(int start, int end) {
        List<String> threadResults = new ArrayList<>();
        for (int i = start; i <= end && i <= LIMIT; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            if (divisibleBy3 && divisibleBy5) {
                threadResults.add("FizzBuzz");
            } else if (divisibleBy3) {
                threadResults.add("Fizz");
            } else if (divisibleBy5) {
                threadResults.add("Buzz");
            }
        }
        return threadResults;
    }


}
