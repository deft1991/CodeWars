package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 13.08.2022
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'a', 'b'}, 'a')); // b
        System.out.println(nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'b')); // c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')); // f
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // f
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); // f
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length;

        while (start < end){
            int mid = start + (end - start)/2;

            if (letters[mid] > target){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
