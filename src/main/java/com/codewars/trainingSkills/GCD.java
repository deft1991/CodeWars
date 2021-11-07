package com.codewars.trainingSkills;

/**
 * @author Sergey Golitsyn
 * created on 24.05.2021
 */
public class GCD {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.sum("20/100+20/100"));
    }

    public String sum(String s) {
        String[] split = s.split("\\+");

        String[] first = split[0].split("/");
        String[] second = split[1].split("/");

        int a = Integer.parseInt(first[0].trim());
        int b = Integer.parseInt(first[1].trim());
        int c = Integer.parseInt(second[0].trim());
        int d = Integer.parseInt(second[1].trim());

        int x = a * d + c * b;
        int y = b * d;

        int gcd = GCD(x, y);
        x /= gcd;
        y /= gcd;
        return x + "/" + y;
    }

    private int GCD(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else if (isEven(a) && isEven(b)) {
            return 2 * GCD(a >> 1, b >> 1);
        } else if (isEven(a) && isOdd(b)) {
            return GCD(a >> 1, b);
        } else if (isOdd(a) && isEven(b)) {
            return GCD(a, b >> 1);
        } else if (isOdd(a) && isOdd(b)) {
            if (a > b) {
                return GCD((a - b) >> 1, b);
            } else {
                return GCD(a, (b - a) >> 1);
            }
        }
        return 0;
    }

    private boolean isEven(int number) {
        return (number & 1) == 0;
    }

    private boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
