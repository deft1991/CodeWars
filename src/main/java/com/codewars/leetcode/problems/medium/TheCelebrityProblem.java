package com.codewars.leetcode.problems.medium;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 19.10.2022
 */
public class TheCelebrityProblem {

    public static int findCelebrity(boolean[][] matrix) {

        int n = matrix.length;
        int celebrity = -1;

        /*
         * Check one by one
         * whether the person is a celebrity or not.
         */
        for (int i = 0; i < n; i++) {
            boolean knowsAnyone = false;
            boolean everyoneKnows = true;

            /*
             * Check whether person with id 'i'
             *  knows any other person.
             */
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    knowsAnyone = true;
                    break;
                }
            }

            /*
             * Check whether person with id 'i'
             * is known to all the other person.
             */
            for (int j = 0; j < n; j++) {
                if (i != j && !matrix[j][i]) {
                    everyoneKnows = false;
                    break;
                }
            }

            if (!knowsAnyone && everyoneKnows) {
                celebrity = i;
                break;
            }
        }

        return celebrity;
    }

    // Finds the potential celebrity, else returns -1
    public int findTheCelebrity(boolean[][] matrix) {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        int celeb;

        /*
         * Step 1 :Push everybody
         * onto stack
         */
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            /*
             * pop two persons, out of which we
             * will eliminate the one who is not a
             * celebrity
             */
            int first = stack.pop();
            int second = stack.pop();

            /*
             * Push the one who is our potential celebrity
             * and eliminate the other
             */
            if (matrix[first][second]) {
                stack.push(second);
            } else{
                stack.push(first);
            }
        }

        /*
         * if stack becomes empty then there's no celeb so return -1
         */
        if (stack.empty()){
            return -1;
        }

        celeb = stack.pop();

        /*
         * Check whether the last element of stack is celebrity or not
         */
        for (int i = 0; i < n; i++) {
            /*
             * in case celeb knows any person 'i'
             *  or 'i' does not know the celeb
             * then return -1, where i != celeb
             */
            if (i != celeb && (matrix[celeb][i] || !matrix[i][celeb]))
                return -1;
        }
        return celeb;
    }

}
