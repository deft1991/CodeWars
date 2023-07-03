package com.codewars.pramp;

/**
 * @author Sergey Golitsyn
 * created on 25.01.2023
 */
public class DecryptMessage2 {

    public static void main(String[] args) {
        DecryptMessage2 d = new DecryptMessage2();
        String encrypt = d.encrypt("crime");
        System.out.println(encrypt);
        System.out.println(d.decrypt(encrypt));
    }


    public String encrypt(String word) {
        char[] chars = word.toCharArray();

        int add = 1;

        for (int i = 0; i < chars.length; i++) {
            chars[i] += add;
            add = chars[i];
        }
        for (int i = 0; i < chars.length; i++){
            while (chars[i] > 'z'){
                chars[i] -= 26;
            }
        }
        return String.valueOf(chars);
    }

    public String decrypt(String word) {

        int substruct = 1;
        int newLetterAscii;
        final StringBuilder decryption = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            newLetterAscii = word.charAt(i);
            newLetterAscii -= substruct;

            while (newLetterAscii < (int) ('a')) {
                newLetterAscii += 26;
            }
            decryption.append((char) newLetterAscii);
            substruct += newLetterAscii;
        }

        return decryption.toString();

    }
}
