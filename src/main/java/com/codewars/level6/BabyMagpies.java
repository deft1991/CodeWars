package com.codewars.level6;

/*
* In the example above kprimes_step(2, 2, 0, 50)
* will return [[4, 6], [33, 35]]
* which are the pairs of 2-primes between 2 and 50 with a 2 steps.
* */
public class BabyMagpies {

    private static int getCount(final String bird1, final String bird2) {
        String[] first = bird1.trim().split("");
        String[] second = bird2.trim().split("");
        int count = 0;
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equalsIgnoreCase(second[i])) {
                count++;
            }
        }
        return count;
    }

    public static boolean child(final String bird1, final String bird2) {
        if (bird1.length() ==1 &&(!bird1.equals(bird2)))
            return true;
        int count = getCount(bird1, bird2);
        return count > 1 && count <= 2;
    }


    public static boolean grandchild(final String bird1, final String bird2) {
        // Your code here
        if (bird1.length() == 1) {
            if (bird1 != bird2) {
                return false;
            }
        }
        if (bird1 == bird2) {
            return true;
        }
        int count = getCount(bird1, bird2);
        return count >= 0 && count <= 4;
    }
}
