package com.codewars.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 29.03.2024
 */
public class StringCombinations {

    public static void main(String[] args) {
        StringCombinations s = new StringCombinations();
        System.out.println(Arrays.toString(s.combination("123").toArray()));
    }

    public List<String> combination(String s) {
        List<String> rez = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        combination(s, sb, 0, rez);
        return rez;
    }

    private void combination(String s, StringBuilder sb, int from, List<String> rez) {

        for (int i = from; i < s.length(); i++) {
            sb.append(s.charAt(i));
            rez.add(new String(sb));

            combination(s, sb, i+1, rez);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
