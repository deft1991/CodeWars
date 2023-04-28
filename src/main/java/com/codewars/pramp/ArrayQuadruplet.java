package com.codewars.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 28.04.2023
 */
public class ArrayQuadruplet {

    public static void main(String[] args) {
        int[] rez = findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 20);
        System.out.println(Arrays.toString(rez));
    }

    static int[] findArrayQuadruplet(int[] arr, int s) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] rez = new int[4];

        for (int num : arr) {
            map.put(num, num);
        }

        Arrays.sort(arr);

        int startPointer = 0;

        while (startPointer <= arr.length - 4) {
            int secondPointer = startPointer + 1;
            while (secondPointer <= arr.length - 3) {
                int thirdPointer = secondPointer + 1;
                int fourthPointer = arr.length - 1;
                while (thirdPointer < fourthPointer) {
                    int first = arr[startPointer];
                    int second = arr[secondPointer];
                    int third = arr[thirdPointer];
                    int fourth = arr[fourthPointer];

                    int sum = first + second + third + fourth;

                    if (sum == s) {
                        rez[0] = first;
                        rez[1] = second;
                        rez[2] = third;
                        rez[3] = fourth;
                        return rez;
                    } else if (sum > s) {
                        fourthPointer--;
                    } else {
                        thirdPointer++;
                    }
                }
                secondPointer++;
            }
            startPointer++;
        }
        return rez;
    }
}
