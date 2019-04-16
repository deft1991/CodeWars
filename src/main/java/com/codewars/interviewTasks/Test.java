package com.codewars.interviewTasks;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/3/2019
 */
public class Test {

  public static int getLastMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    int minPrev = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        int tmp = min;
        min = arr[i];
        if (min < minPrev) {
          minPrev = tmp;
        }
      }else if (arr[i] < minPrev){
        minPrev = arr[i];
      }
    }
    return minPrev;
  }

  public static void main(String[] args) {
    int[] ints = {7, 8, 1, 5, 4, 2, 6, 9, 2, 5, 4 };

    System.out.println(getLastMin(ints));

    //
  }
}
