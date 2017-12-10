package com.codewars.level8;

import java.util.Arrays;

/*Given an array of 3 integers a, b and c, determine if they form a pythagorean triple.

A pythagorean triple is formed when:

c2 = a2 + b2

where c is the largest value of a, b, c.

For example: a = 3, b = 4, c = 5 forms a pythagorean triple, because 52 = 32 + 42

Return Values

1 if a, b and c form a pythagorean triple
0 if a, b and c do not form a pythagorean triple*/
public class PythagoreanTriple {
    public int pythagoreanTriple(int[] triple) {
        Arrays.sort(triple);
        int max = triple[triple.length-1];
        int summ = (int) (Math.pow(triple[0],2) + Math.pow(triple[1],2));
        if (summ == Math.pow(max,2))
            return 1;
        return 0;

    }
}
