package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/26/2019 John works at a clothing store. He has a large pile of socks that he must pair
 *     by color for sale. Given an array of integers representing the color of each sock, determine
 *     how many pairs of socks with matching colors there are.
 *     <p>For example, there are socks with colors . There is one pair of color and one of color .
 *     There are three odd socks left, one of each color. The number of pairs is .
 *     <p>Function Description
 *     <p>Complete the sockMerchant function in the editor below. It must return an integer
 *     representing the number of matching pairs of socks that are available.
 *     <p>sockMerchant has the following parameter(s):
 *     <p>n: the number of socks in the pile ar: the colors of each sock Input Format
 *     <p>The first line contains an integer , the number of socks represented in . The second line
 *     contains space-separated integers describing the colors of the socks in the pile.
 *     <p>Constraints
 *     <p>where Output Format
 *     <p>Return the total number of matching pairs of socks that John can sell.
 *     <p>Sample Input
 *     <p>9 10 20 20 10 10 30 50 10 20 Sample Output
 *     <p>3
 */
public class SockMerchant {

  // Complete the sockMerchant function below.
  private static int sockMerchant(int n, int[] ar) {
    Arrays.sort(ar);
    int pairs = 0;
    Integer tmp;
    for (int i = 0; i < ar.length-1;) {
      tmp = ar[i];
      int poll = ar[i + 1];
      if (tmp.equals(poll)) {
        pairs++;
        i += 2;
      } else {
        i++;
      }
    }
    return pairs;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
