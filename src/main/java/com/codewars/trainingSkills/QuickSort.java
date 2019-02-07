package com.codewars.trainingSkills;


import static org.apache.commons.lang3.ArrayUtils.swap;

import java.util.Arrays;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/7/2019
 */
public class QuickSort {

  private static int[] arr = new int[] {1, 48, 15, 7, 18, 12, 45, 1, 87, 32};

  public static void main(String[] args) {
    quickSort(0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private static void quickSort(int left, int right) {
    System.out.println("quickSort с параметрами : left = " + left + " right = " + right);
    if (right - left <= 0) {
      System.out.println("строка 20 : left = " + left + " right = " + right);
      return;
    } else {
      System.out.println("строка 23 : left = " + left + " right = " + right);
      int pivot = arr[right];
      System.out.println("строка 25 : pivot = " + pivot);
      int partition = partitionInt(left, right, pivot);
      System.out.println("строка 27 : partition = " + partition);
      quickSort(left, partition - 1);
      quickSort(partition + 1, right);
    }
  }

  private static int partitionInt(int left, int right, int pivot) {
    System.out.println("В partitionInt : left = " + left + " : right = " + right + ". pivot = " + pivot);
    int leftPtr = left - 1;
    int rightPtr = right;
    while (true) {
      while (arr[++leftPtr] < pivot) {
        System.out.println(" arr[++leftPtr] < pivot : " + arr[leftPtr] + " < " + pivot);
      }
      System.out.println("В partitionInt !!!! : arr[++leftPtr] >= pivot : " + arr[leftPtr] + " >= " + pivot);
      while (rightPtr > 0 && arr[--rightPtr] > pivot) {
        System.out.println("right > 0 && arr[--right] > pivot : " + arr[rightPtr] + " < " + pivot);
      }
      System.out.println("В partitionInt !!!! : arr[--rightPtr] <= pivot : " + arr[rightPtr] + " <= " + pivot);
      if (leftPtr >= rightPtr) {
        break;
      } else {
        System.out.println(
            "Перед свапом на 164 строке. свапаем индексы " + leftPtr + " : " + rightPtr);
        System.out.println(
            "Перед свапом на 164 строке. свапаем " + arr[leftPtr] + " : " + arr[rightPtr]);
        swap(arr, leftPtr, rightPtr);
      }
    }
    System.out.println("Перед свапом на 168 строке. свапаем индексы " + leftPtr + " : " + right);
    System.out.println("Перед свапом на 168 строке. свапаем  " + arr[leftPtr] + " : " + arr[right]);
    swap(arr, leftPtr, right);
    return leftPtr;
  }
}
