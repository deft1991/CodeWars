package com.codewars.fizzbuzz;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergey Golitsyn
 * created on 09.12.2023
 */
public class ParallelFizzBuzz {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    private static final int LIMIT = 1_000_000;
    private static final int NUM_THREADS = 4;


    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.AverageTime)
    public void init3() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        CountDownLatch latch = new CountDownLatch(NUM_THREADS);

        int chunkSize = LIMIT / NUM_THREADS;

        List<String> results = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * chunkSize + 1;
            final int end = (i + 1) * chunkSize;
            executorService.submit(() -> {
                List<String> threadResults = printFizzBuzzInRange(start, end);
                results.addAll(threadResults);
                latch.countDown();
            });
        }

        try {
            latch.await(); // Wait for all threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

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
