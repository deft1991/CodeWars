package com.codewars.GRIND75;

/**
 * @author Sergey Golitsyn
 * created on 24.07.2023
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();

//        System.out.println(b.backspaceCompare("ab##", "a#c#"));
        System.out.println(b.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String s, String t) {
        String sbS = prepareString(s);
        String sbT = prepareString(t);
        return sbS.equals(sbT);
    }

    private static String prepareString(String s) {
        StringBuilder rez = new StringBuilder();

        for(Character ch : s.toCharArray()){
            if('#' == ch && rez.length() > 0){
                rez = rez.deleteCharAt(rez.length()-1);
            } else if('#' != ch) {
                rez.append(ch);
            }
        }
        return rez.toString();
    }
}
