package com.codewars.fizzbuzz;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author Sergey Golitsyn
 * created on 09.12.2023
 */
public class ParallelFizzBuzz3 {
    private static final int LIMIT = 1_000_000;

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.AverageTime)
    public static void init5() {
        List<String> results = IntStream.rangeClosed(1, LIMIT)
                .parallel()
                .mapToObj(ParallelFizzBuzz3::printFizzBuzz)
                .filter(s -> !s.isEmpty())
                .toList();

        // Print the results
        System.out.println(results.size());
    }

    private static String printFizzBuzz(int num) {
        boolean divisibleBy3 = num % 3 == 0;
        boolean divisibleBy5 = num % 5 == 0;

        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        } else if (divisibleBy3) {
            return "Fizz";
        } else if (divisibleBy5) {
            return "Buzz";
        } else {
            return "";
        }
    }
}
