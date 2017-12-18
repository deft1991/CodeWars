package com.codewars.level7;

/*This time no story, no theory. The examples below show you how to write function accum:

Examples:

Accumul.accum("abcd");    // "A-Bb-Ccc-Dddd"
Accumul.accum("RqaEzty"); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
Accumul.accum("cwAt");    // "C-Ww-Aaa-Tttt"
The parameter of accum is a string which includes only letters from a..z and A..Z.*/
public class Mumbling {
    public static String accum(String s) {
        // your code
        String rez = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = -1; j < i ; j++) {
                if (j == -1)
                    rez += String.valueOf(arr[i]).toUpperCase();
                else rez += String.valueOf(arr[i]).toLowerCase();
            }
            rez += "-";
        }
        return rez.substring(0, rez.length() - 1);
    }
}
