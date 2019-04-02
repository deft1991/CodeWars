package com.codewars.hackerRank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/2/2019
 */
public class CompareTriplets {
  // Complete the compareTriplets function below.
  private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int one = 0, two = 0;

    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) > b.get(i)) {
        one++;
      } else if (a.get(i) < b.get(i)) {
        two++;
      }
    }
    return Arrays.asList(one, two);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bufferedWriter =
    //        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> b =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = compareTriplets(a, b);

    //    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");
    System.out.println(result);
    bufferedReader.close();
    //    bufferedWriter.close();
  }
}
