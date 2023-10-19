package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 05.09.2023
 */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();
        System.out.println(m.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int used = k;
        int rez = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                continue;
            }
            used--;

            if (used == 0) {
                int tmp = right - left + 1;
                rez = Math.max(rez, tmp);

                if(nums[left] == 0){
                    left++;
                    used++;
                }

                while (nums[left] != 0) {
                    left++;
                }
                used++;
            }
        }
        return rez;
    }
}
