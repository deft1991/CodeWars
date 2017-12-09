package com.codewars.level8;

import java.math.BigDecimal;

/*
*In this simple assignment you are given a number and have to make it negative. But maybe the number is already negative?
*/
public class ReturnNegative {
    public static int makeNegative(int x) {
//        return x < 0 ? x : new BigDecimal(x).negate().intValue();
        return x < 0 ? x : -x;
    }
}
