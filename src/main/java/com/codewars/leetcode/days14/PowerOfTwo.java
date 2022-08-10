package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 25.02.2022
 */
public class PowerOfTwo {

    /*
    11111111111111111111111111110101
    00000000000000000000000000001011
     */
    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(2));
        System.out.println(p.isPowerOfTwo(3));
        System.out.println(p.isPowerOfTwo(4));

    }

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

    public int hammingWeight(int n) {
        int count = 0;

        while(n > 0){
            if ((n & 1) == 1 ){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int reverseBits(int n){
        int mask = 1;
        int rez = 0;

        for (int i = 0; i < 32; i++){
            rez = rez*2 + (n & mask);
            n >>>= 1;
        }
        return rez;
    }
}
