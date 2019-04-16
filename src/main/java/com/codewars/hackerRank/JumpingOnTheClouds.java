package com.codewars.hackerRank;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/16/2019
 */
public class JumpingOnTheClouds {

  // Complete the jumpingOnClouds function below.
  static int jumpingOnClouds(int[] c) {
    int counter = 0;
    for (int i = 0; i < c.length-1; ) {
      if (i + 2 <= c.length -1 && c[i + 2] == 0) {
        counter++;
        i += 2;
      } else {
        counter++;
        i++;
      }
    }
    return counter;
  }
}
