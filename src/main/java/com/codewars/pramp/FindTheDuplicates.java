package com.codewars.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 27.01.2023
 */
public class FindTheDuplicates {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(FindTheDuplicates.findDuplicates(new int[]{1,2,3,5,6,7}, new int[]{3,6,7,8,20})));
    }
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here
        List<Integer> rez = new ArrayList<>();
        int[] shortArr;
        int[] longArr;

        if(arr1.length > arr2.length){
            longArr = arr1;
            shortArr = arr2;
        } else {
            longArr = arr2;
            shortArr = arr1;
        }

        for(int curValue : shortArr){

            boolean isPersists = binarySearch(longArr, curValue);
            if(isPersists){
                rez.add(curValue);
            }
        }

        return rez.stream().mapToInt(i -> i).toArray();

    }

    /**
     [1,2,3,4,5,6,7,8]
     ^
     curValue = 7

     mid = 0 + 7/2 = 3
     mid = 4 + (7-4)/2 = 5

     start = 6
     end = 7

     mid = 6 + (7-6)/2 = 6

     */
    private static boolean binarySearch(int[] longArr, int curValue){
        int start = 0;
        int end = longArr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(longArr[mid] == curValue){
                return true;
            }
            if(longArr[mid] > curValue){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }


}
