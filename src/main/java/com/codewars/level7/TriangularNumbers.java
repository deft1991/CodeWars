package com.codewars.level7;

import java.math.BigInteger;

public class TriangularNumbers {

    public static BigInteger numberOfDots(BigInteger n) {
        // find number of dots needed
        BigInteger one = new BigInteger("1");
        return n.compareTo(new BigInteger("0")) <= 0 ? new BigInteger("0")
                : n.multiply(n.add(one)).divide(new BigInteger("2"));
    }

    public static int triangular(int n) {
//        int rez = 0;
//        while (n >= 1){
//            rez += n--;
//        }
//        return rez;
        return (n <= 0) ? 0 : n * (n + 1) / 2;

    }

    public static void main(String[] args) {
        System.out.println(numberOfDots(new BigInteger("5")));;
//        System.out.println(triangular(3));
    }
}
