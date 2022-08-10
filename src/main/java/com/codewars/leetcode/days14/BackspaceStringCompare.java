package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 12.03.2022
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(b.backspaceCompare("ab##", "c#d#")); // true
        System.out.println(b.backspaceCompare("a#c", "b")); // false
        ;
    }

    public boolean backspaceCompare(String s, String t) {

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();


        createStr(a, sCh, 0);
        createStr(b, tCh, 0);
        return a.compareTo(b) == 0;
    }

    private void createStr(StringBuilder a, char[] sCh, int counter) {
        for (int i = sCh.length - 1; i >= 0; i--) {
            if (sCh[i] == '#') {
                counter++;
            } else {
                if (counter > 0) {
                    counter--;
                } else {
                    a.append(sCh[i]);
                }
            }
        }
    }
}
