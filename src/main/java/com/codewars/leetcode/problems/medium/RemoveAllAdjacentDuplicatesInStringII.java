package com.codewars.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 * <p>
 * Given a string s, a k duplicate removal consists of choosing k adjacent
 * and equal letters from s and removing them causing the left and the
 * right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.
 * <p>
 * It is guaranteed that the answer is unique.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII ra = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(ra.removeDuplicates("abcd", 2));
        System.out.println(ra.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(ra.removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(ra.removeDuplicates("dtpdtaaaaaaaaappppppppppppppppppppaaaaaaaaaaxxxxxxxxxxxxxxsssssssssjjjjjjjjjjjjjjjjjjjjxxxxxxxxxxxxxxxxxxxxsssssssjjjjjjjjjjjjjjjjjjjjssssxxxxxxatdwvvpctpggggggggggggggggggggajagglaaaaaaaaaaaaaaaaaaaa", 20));
//        System.out.println(ra.removeDuplicates("ggggggggggggggggggggajagglaaaaaaaaaaaaaaaaaaaa", 20));
    }

    // dtpdttdwvvpctpajaggl
    public String removeDuplicates(String s, int k) {
        Deque<Token> deque = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (deque.peek() == null || deque.peek().data != c) {
                deque.push(new Token(c, 1));
            } else if (deque.peek().data == c) {
                deque.peek().count++;
            }
            if (deque.peek().count == k) {
                deque.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {

            Token pop = deque.pop();
            for (int i = 0; i < pop.count; i++) {
                sb.insert(0, pop.data);
            }

        }
        return sb.toString();
    }

    class Token {
        Character data;
        int count;

        Token(char data, int count) {
            this.data = data;
            this.count = count;
        }
    }
}
