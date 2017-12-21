package com.codewars.level7;

public class Dinglemouse {

    public static String nameTheShape(final char[][] card) {
        // Your code here
        char[] thirdLine = card[2];
        for (int i = 1; i < thirdLine.length - 1; i++) {
            String tmp = String.valueOf(thirdLine[i]);
            if (!tmp.equals(" ")) {
                return "diamond";
            }
        }
        char[] fourthLine = card[3];
        int count = 0;
        for (int i = 1; i < fourthLine.length - 1; i++) {
            String tmp = String.valueOf(fourthLine[i]);
            if (!tmp.equals(" ")) {
                count++;
            }
        }
        if (count == 5)
            return "circle";
        if (count == 11)
            return "square";
        return null;
    }
}
