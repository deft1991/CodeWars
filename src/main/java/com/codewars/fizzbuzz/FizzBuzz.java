package com.codewars.fizzbuzz;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergey Golitsyn
 * created on 08.12.2023
 */
public class FizzBuzz {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    private static final int LIMIT = 1_000_000;

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.AverageTime)
    public void init0() {
        List<String> rez = new ArrayList<>();
        for (int i = 0; i < LIMIT; i++){
            if (i % 3 == 0 && i % 5 == 0){
                rez.add("FizzBuzz");
            } else if (i % 3 == 0){
                rez.add("Fizz");
            } else if (i % 5 == 0){
                rez.add("Buzz");
            }
        }
        System.out.println(rez.size());
    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Fork(value = 1, warmups = 2)
//    @BenchmarkMode(Mode.AverageTime)
//    public void init1() {
//        List<String> rez = new ArrayList<>();
//        for (int i = 0; i < LIMIT; i++){
//            StringBuilder sb = new StringBuilder();
//            if (i % 3 == 0){
//                sb.append("Fizz");
//            } else if (i % 5 == 0){
//                sb.append("Buzz");
//            }
//            if (!sb.isEmpty()){
//                rez.add(sb.toString());
//            }
//        }
//        System.out.println(rez.size());
//    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.AverageTime)
    public void init2() {
        List<String> rez = new ArrayList<>();
        int i = 1, fizz = 0, buzz = 0;
        while (i <= LIMIT){
            fizz++; buzz++;
            if (fizz == 3 && buzz == 5) {
                rez.add("FizzBuzz");
                fizz = buzz = 0;
            } else if (fizz == 3) {
                rez.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                rez.add("Buzz");
                buzz = 0;
            }
            i++;
        }

        System.out.println(rez.size());
    }
}
