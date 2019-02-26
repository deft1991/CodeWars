package com.codewars.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/13/2019
 */
public class ExecutorsTest {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      executorService.submit(
          () -> System.out.println("Hi from thread = " + Thread.currentThread().getName()));
    }

    ScheduledExecutorService scheduledExecutorService =
        Executors.newSingleThreadScheduledExecutor();
    scheduledExecutorService.scheduleAtFixedRate(
        () -> System.out.println("thread = " + Thread.currentThread().getName()),
        0,
        5,
        TimeUnit.SECONDS);
  }
}
