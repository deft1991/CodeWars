package com.codewars.leetcode.array;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 5/19/20
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide r = new ReplaceElementsWithGreatestElementOnRightSide();
        int[] ints = {17, 18, 5, 4, 6, 1};
        r.replaceElements(ints);
        System.out.println(Arrays.toString(ints));
    }

    public int[] replaceElements(int[] arr) {
        int idxLastEl = arr.length - 1;
        int max = arr[idxLastEl];

        for (int i = idxLastEl - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;

            if (tmp > max){
                max = tmp;
            }
        }
        arr[idxLastEl] = -1;
        return arr;
    }

}
