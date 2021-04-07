package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 06.04.2021
 */
public class FindTownJudge {

    public static void main(String[] args) {
        FindTownJudge f = new FindTownJudge();

        System.out.println(f.findJudge(2, new int[][]{{1, 2}})); // 2
        System.out.println(f.findJudge(3, new int[][]{{1, 3}, {2, 3}})); // 3
        System.out.println(f.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}})); // -1
        System.out.println(f.findJudge(3, new int[][]{{1, 2}, {2, 3}})); // -1
        System.out.println(f.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}})); // 3
    }

    public int findJudge(int N, int[][] trust) {
        int[] arr = new int[N];

        for (int[] citizens : trust) {
            arr[citizens[0] - 1] --;
            arr[citizens[1] - 1] ++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == N - 1 ) {
                return i + 1;
            }
        }
        return -1;
    }
}
