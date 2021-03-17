package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 13.03.2021
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        List<List<Integer>> lists = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        System.out.println();
//        lists = fourSum.fourSum(new int[]{}, 0);
//        System.out.println();
//
//        lists = fourSum.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
//        System.out.println();

        List<List<Integer>> lists2 = fourSum.fourSum(new int[]{-4,-3,-2,-1,0,0,1,2,3,4}, 0);
        System.out.println();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> rez = new ArrayList<>();
        Set<Rez> tmpList = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            int lessHi = hi - 1;

            while (lo < lessHi && lo < hi) {


                int sum = nums[i] + nums[lo] + nums[hi] + nums[lessHi];

                if (sum == target) {
                    tmpList.add(new Rez(nums[i], nums[lo], nums[hi], nums[lessHi]));
                    lo++;
                } else if (sum > target) {
                    innerFind(nums, target, tmpList, i, lo, hi, lessHi);
                    hi--;
                    lessHi--;

                } else {
                    innerFind(nums, target, tmpList, i, lo, hi, lessHi);
                    lo++;
                }
            }
        }
        for (Rez r : tmpList) {
            rez.add(List.of(r.a, r.b, r.c, r.d));
        }
        return rez;
    }

    private void innerFind(int[] nums, int target, Set<Rez> tmpList, int i, int lo, int hi, int lessHi) {
        int tmpLo = lo;
        int tmpHi = lessHi;

        while (tmpLo < tmpHi) {
            int tmpSum2 = nums[i] + nums[tmpLo] + nums[tmpHi] + nums[hi];

            if (tmpSum2 == target) {
                tmpList.add(new Rez(nums[i], nums[tmpLo], nums[tmpHi], nums[hi]));
                tmpLo++;
            } else if (tmpSum2 > target) {
                tmpHi--;
            } else {
                tmpLo++;
            }
        }
    }

    // вспомогательный класс для хранения индексов
    static class Rez {
        int a, b, c, d;

        public Rez(int a, int b, int c, int d) {
            int[] ints = {a, b, c, d};
            Arrays.sort(ints);
            this.a = ints[0];
            this.b = ints[1];
            this.c = ints[2];
            this.d = ints[3];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rez rez = (Rez) o;
            return a == rez.a && b == rez.b && c == rez.c && d == rez.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }
}
