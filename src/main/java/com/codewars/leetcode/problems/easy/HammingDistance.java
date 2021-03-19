package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 10.03.2021
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,4)); // 2
        System.out.println(hd.hammingDistance(93, 73)); // 2
        System.out.println(hd.hammingDistance(14, 2)); // 2

    }

    public int hammingDistance(int x, int y) {
        int rez = 0;

        String binaryString = Integer.toBinaryString(x ^ y);

        for (int i = 0; i < binaryString.length(); i++){
            if (binaryString.charAt(i) == '1'){
                rez ++;
            }
        }

        return rez;
    }
}
