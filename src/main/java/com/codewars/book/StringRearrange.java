package com.codewars.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 29.03.2024
 */
public class StringRearrange {

    public static void main(String[] args) {
        StringRearrange s = new StringRearrange();
        System.out.println(Arrays.toString(s.rearrange("hat").toArray()));
    }

    public List<String> rearrange(String s){
        List<String> rez = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[s.length()];

        rearrange(s, sb, visited, rez);
        return rez;
    }

    private void rearrange(String s, StringBuilder sb, boolean[] visited, List<String> rez){
        if (sb.length() == s.length()){
            rez.add(new String(sb));
        }
        for (int i = 0; i < s.length(); i++){
            if (!visited[i]){
                sb.append(s.charAt(i));
                visited[i] = true;

                rearrange(s, sb, visited, rez);

                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }
}
