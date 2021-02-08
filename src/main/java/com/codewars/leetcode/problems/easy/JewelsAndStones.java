package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 06.02.2021
 *
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have.
 * Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= jewels.length, stones.length <= 50
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        char[] split = jewels.toCharArray();
        char[] arr = new char[58];
        for (char c : split) {
            arr[c - 'A'] = 1;
        }

        char[] charsStones = stones.toCharArray();
        int countJew = 0;

        for (char c : charsStones) {
            if (arr[c - 'A'] != 0) {
                countJew++;
            }
        }
        return countJew;
    }
}
