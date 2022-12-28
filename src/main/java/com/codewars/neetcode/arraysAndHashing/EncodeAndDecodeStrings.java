package com.codewars.neetcode.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 06.12.2022
 */
public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        EncodeAndDecodeStrings e = new EncodeAndDecodeStrings();
        System.out.println(e.encode(List.of("word")));
        System.out.println(Arrays.toString(e.decode("4#word").toArray()));
        System.out.println(e.encode(List.of("word", "leet")));
        System.out.println(Arrays.toString(e.decode("4#word4#leet").toArray()));
        System.out.println(e.encode(List.of("word", "leet", "code")));
        System.out.println(Arrays.toString(e.decode("4#word4#leet4#code").toArray()));
    }

    /**
     * Add Num+# + Word
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String word : strs){
            sb.append(word.length());
            sb.append("#");
            sb.append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> rez = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            String substring = str.substring(i);
            int indexOf = substring.indexOf("#");
            int dig = Integer.parseInt(str.substring(i, i+ indexOf));
            i+= indexOf + 1;
            int cur = 0;
            StringBuilder sb = new StringBuilder();
            while (cur < dig){
                sb.append(str.charAt(i));
                i++;
                cur++;
            }
            rez.add(sb.toString());
            i--;
        }

        return rez;
    }
}
