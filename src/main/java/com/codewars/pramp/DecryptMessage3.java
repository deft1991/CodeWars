package com.codewars.pramp;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 28.06.2023
 */
public class DecryptMessage3 {

    public static void main(String[] args) {
        DecryptMessage3 d = new DecryptMessage3();
        System.out.println(d.encrypt("crime")); // dnotq
        System.out.println(d.decrypt("dnotq")); // crime
    }

    public String decrypt(String word) {
        StringBuilder rez = new StringBuilder();

        int substr = 1;
        int cur;
        for(int i = 0; i < word.length(); i++){
            cur = word.charAt(i);
            cur -= substr;

            while (cur < 'a'){
                cur += 26;
            }
            rez.append((char)cur);
            substr = word.charAt(i);
        }
        return rez.toString();
    }

    public String encrypt(String word) {
        char[] chars = word.toCharArray();

        int add = 1;
        for(int i = 0; i < chars.length; i++){
             chars[i] += add;
             add = chars[i];
        }

        for(int i = 0; i < chars.length; i++){
            while (chars[i] > 'z'){
                chars[i]-=26;
            }
        }

        return String.valueOf(chars);
    }
}
