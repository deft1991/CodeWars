package com.codewars.pramp;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 13.07.2023
 */
public class DiffBetweenTwoStrings {

    public static void main(String[] args) {
        DiffBetweenTwoStrings d = new DiffBetweenTwoStrings();
        System.out.println(Arrays.toString(d.diffBetweenTwoStrings("ABCDEFG", "ABDFFGH")));
    }


    /*


     */
    public String[] diffBetweenTwoStrings(String source, String target) {
        // your code goes here
        List<String> rez = new ArrayList<>();





        String[] rezArray = new String[rez.size()];

        for (int i = 0; i < rez.size(); i++) {
            rezArray[i] = rez.get(i);
        }
        return rezArray;
    }
}
