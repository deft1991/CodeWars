package com.codewars.trainingSkills;

import java.util.Arrays;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/27/2019 Реализовать алгоритм проверяющий уникальность символов в строке. При выполнении
 *     задания нельзя использовать дополнительные структуры данных
 */
public class StringFirstTask {
  public static void main(String[] args) {
    //
  }

  /**
   * Сортируем последовательност символов и проверяем совпадение
   * @param arr - строка преобразованная в массив символов
   * @return уникальность
   */
  private boolean checkUnique(char[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == arr[i+1]){
        return false;
      }
    }
    return true;
  }

  /**
   * Если кодировка в ascii то символов 256
   * @param arr
   * @return
   */
  private boolean checkUniqueFromBook(char [] arr){
    boolean [] alphabet = new boolean[256];
    for (char c : arr){
      if (alphabet[c]){
        return false;
      } else{
        alphabet[c] = true;
      }
    }
    return true;
  }
}
