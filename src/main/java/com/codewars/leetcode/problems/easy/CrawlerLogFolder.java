package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 19.04.2021
 */
public class CrawlerLogFolder {

    public static void main(String[] args) {
        CrawlerLogFolder c = new CrawlerLogFolder();

        System.out.println(c.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }

    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();

        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!log.equals("./")) {
                stack.push(log);
            }
        }

        return stack.size();
    }
}
