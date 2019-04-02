package com.codewars.hackerRank;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/2/2019
 */
public class SimpleArraySum {
  /*
   * Complete the simpleArraySum function below.
   */
  static int simpleArraySum(int[] ar) {
    /*
     * Write your code here.
     */
    AtomicInteger count = new AtomicInteger();
    IntStream.of(ar).forEach(count::addAndGet);
    return count.get();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    //    BufferedWriter bufferedWriter =
    //        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arCount = Integer.parseInt(scanner.nextLine().trim());

    int[] ar = new int[arCount];

    String[] arItems = scanner.nextLine().split(" ");

    for (int arItr = 0; arItr < arCount; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr].trim());
      ar[arItr] = arItem;
    }

    int result = simpleArraySum(ar);
    System.out.println(result);
    //    bufferedWriter.write(String.valueOf(result));
    //    bufferedWriter.newLine();
    //
    //    bufferedWriter.close();
  }
}
