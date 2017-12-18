package com.codewars.level7;


/*
* s = "abcd\nefgh\nijkl\nmnop"
*vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"
* hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"
* */
public class MovesInSquaredStrings {
    public static String vertMirror(String strng) {
        String[] arr = strng.split("\n");
        StringBuilder rez = new StringBuilder();
        for (String s : arr) {
            rez.append(new StringBuilder(s).reverse()).append("\n");
        }
        return rez.toString().substring(0,rez.toString().length()-1);
    }

    public static String horMirror(String strng) {
        String[] arr = strng.split("\n");
        StringBuilder rez = new StringBuilder();
        for (int i =  arr.length-1; i >= 0; i--) {
            rez.append(new StringBuilder(arr[i])).append("\n");
        }
        return rez.toString().substring(0,rez.toString().length()-1);
    }

    public static String oper(String s, String... operator) {
        // your code and complete ... before operator
        return null;
    }
}
