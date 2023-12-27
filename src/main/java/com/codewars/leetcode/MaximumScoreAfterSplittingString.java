package com.codewars.leetcode;

/**
 * @author Sergey Golitsyn
 * created on 22.12.2023
 */
public class MaximumScoreAfterSplittingString {

    public static void main(String[] args) {
        MaximumScoreAfterSplittingString m = new MaximumScoreAfterSplittingString();

        System.out.println(m.maxScore("011101"));
    }

    public int maxScore(String s) {
        int leftScore = 0;
        int rightScore = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                rightScore++;
            }
        }

        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '0'){
                leftScore++;
            } else {
                rightScore--;
            }
            max = Math.max(max, leftScore + rightScore);
        }
        return max;
    }
}
