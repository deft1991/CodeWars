package com.codewars.GRIND75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 15.09.2023
 */
public class S {

    public static void main(String[] args) {
        S s = new S();
        s.getSpamEmails(List.of("Let it go", "The right thing to do"), List.of("to", "do", "right", "go", "let"));
    }

    public static List<String> getSpamEmails(List<String> subjects, List<String> spam_words) {
        // Write your code here
        Set<String> spam = new HashSet<>();
        for(String s : spam_words){
            spam.add(s);
        }
        List<String> rez = new ArrayList<>();
        for(String s : subjects){
            Set<String> spamCount = new HashSet<>();
            String[] words = s.split(" ");
            for(String w : words){

                if(spam.contains(w)){
                    spamCount.add(w);
                }
            }
            if(spamCount.size() >= 2){
                rez.add("spam");
            } else {
                rez.add("not_spam");
            }
        }
        return rez;
    }

}
