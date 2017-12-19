package com.codewars.level7;

/*Help!
THB has gone missing, and we need you to find him!
You will be given a string, and must return a string including only the t's, h's,
and b's from the original string. Include both uppercase and lowercase.
Remember, you should return an empty string if you are given an empty string or a null string.
Good luck!*/
public class THB {
    public static String testing(String initial) {
        //Don't goof it up!
        if (initial == null) return "";
//        String rez = "";
//        for (char x : initial.toCharArray()) {
//            if (String.valueOf(x).equalsIgnoreCase("t")
//                    || String.valueOf(x).equalsIgnoreCase("h")
//                    || String.valueOf(x).equalsIgnoreCase("b"))
//                rez += x;
//        }
        return initial.replaceAll("[^TBHtbh]", "1");
    }
}
