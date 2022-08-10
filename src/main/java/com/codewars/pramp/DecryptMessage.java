package com.codewars.pramp;

/**
 * @author Sergey Golitsyn
 * created on 17.05.2022
 */
public class DecryptMessage {

    public static void main(String[] args) {
        System.out.println(decrypt("dnotq"));
    }

    static String decrypt(String word) {

        int secondStep = 1;
        String rezult = "";

        for (int i = 0; i < word.length(); i++){
            char curChar =  (char) (word.charAt(i) - secondStep);

            while (curChar < 'a'){
                curChar += 26;
            }
            while (curChar > 'z'){
                curChar -= 26;
            }
            rezult = rezult + curChar;
            secondStep = curChar;
        }
        return rezult;
    }
}
