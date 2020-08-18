package com.codewars.leetcode.topInterviewQuestions.easy;

/*
 * Created by sgolitsyn on 8/17/20
 *
 The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30,
* generate the nth term of the count-and-say sequence.
* You can do so recursively,
* in other words from the previous member read off the digits,
* counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: 4
Output: "1211"
Explanation:
For n = 3 the term was "21" in which we have two groups "2" and "1",
"2" can be read as "12" which means frequency = 1 and value = 2,
the same way "1" is read as "11",
so the answer is the concatenation of "12" and "11" which is "1211".
   Hide Hint #1
The following are the terms from n=1 to n=10 of the count-and-say sequence:
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
10.     13211311123113112211

 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();

        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuilder rez = new StringBuilder();
        String current = "1";
        while (n > 1) {

            int count = 1;
            for (int i = 0; i < current.length(); i++) {
                if (i + 1 < current.length() && current.charAt(i) == current.charAt(i + 1)) {
                    count++;
                } else {
                    rez.append(count).append(current.charAt(i));
                    count = 1;
                }

            }
            if (count > 1) {
                rez.append(count).append(current.charAt(current.length() - 1));
            }
            current = rez.toString();
            rez.setLength(0);
            n--;
        }
        return current;
    }
}
