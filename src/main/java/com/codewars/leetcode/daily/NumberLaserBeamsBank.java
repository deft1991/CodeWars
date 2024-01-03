package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 03.01.2024
 */
public class NumberLaserBeamsBank {

    public static void main(String[] args) {
        NumberLaserBeamsBank n = new NumberLaserBeamsBank();
        System.out.println(n.numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(n.numberOfBeams(new String[]{"000", "111", "000"}));
    }

    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int rez = 0;

        for (String s : bank){
            int calc = calc(s);
            if (calc == 0){
                continue;
            }
            rez += calc * prev;
            prev = calc;
        }

        return rez;
    }

    private int calc(String s) {
        int rez = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                rez++;
            }
        }
        return rez;
    }

}
