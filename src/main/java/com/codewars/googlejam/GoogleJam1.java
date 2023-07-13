package com.codewars.googlejam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 15.04.2023
 *
 * Problem
 * Alan just had his first cryptography class in school today. He decided to apply what he learned and come up with his own cipher. He will map each English letter from A to Z to a decimal digit 0
 *  through 9
 * . He will then try to encode each word to a string consisting of decimal digits by replacing each letter in the word with its mapped digit.
 *
 * In his excitement, Alan failed to notice that there are 26
 *  letters in the English alphabet and only 10
 *  decimal digits. As a result, there might be collisions, that is, pairs of different words whose encoding is the same.
 *
 * Given a list of N
 *  words that Alan wants to encode and the mapping that he uses, can you find out if there would be any collisions between words on the list?
 *
 * Input
 * The first line of the input gives the number of test cases, T
 * . T
 *  test cases follow.
 * The first line of each test case contains 26
 *  decimal digits (integers between 0
 *  and 9
 * , inclusve) DA,DB,…,DZ
 * , representing the mapping that Alan uses. A letter α
 *  is mapped to digit Dα
 * .
 * The second line of each test case contains N
 * , the number of words Alan will encode.
 * The i
 * -th of the last N
 *  lines contains a string Si
 * , representing the i
 * -th word Alan will encode.
 * Output
 * For each test case, output one line containing Case #x
 * : y
 * , where x
 *  is the test case number (starting from 1) and y
 *  is either YES, if there is at least one pair of different words from the list whose encoding coincides, and NO otherwise.
 *
 * Limits
 * Time limit: 20 seconds.
 * Memory limit: 2 GB.
 * 1≤T≤100
 * .
 * 0≤Dα≤9
 * , for all α
 * .
 * 1≤
 *  the length of Si≤10
 * , for all i
 * .
 * Each character of Si
 *  is an uppercase English letter A through Z, for all i
 * .
 * Si≠Sj
 * , for all i≠j
 * .
 *
 * Test Set 1 (Visible Verdict)
 * 1≤N≤100
 * .
 * Test Set 2 (Visible Verdict)
 * 1≤N≤6×104
 * .
 * Sample
 * Sample Input
 * save_alt
 * content_copy
 * 2
 * 0 1 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3
 * 4
 * ABC
 * BC
 * BCD
 * CDE
 * 0 1 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3
 * 3
 * CDE
 * DEF
 * EFG
 * Sample Output
 * save_alt
 * content_copy
 * Case #1: NO
 * Case #2: YES
 * In Sample Case #1, the mapping for A is 0
 * , for B is 1
 * , for C is 2
 * , for D is 3
 * , and for E is 3
 * . With this mapping, ABC is encoded as 012
 * , BC is encoded as 12
 * , BCD as 123
 * , and CDE as 233
 * . Since all of these encodings are distinct, there are no collisions.
 *
 * In Sample Case #2, the mapping for C is 2
 * , for D is 3
 * , for E is 3
 * , for F is 3
 * , and for G is 3
 * . With this mapping, CDE is encoded as 233
 * , DEF as 333
 * , and EFG as 333
 * . Since the encoding for DEF and EFG is the same, there is a collision.
 */
public class GoogleJam1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int[] map = new int[26];
            for (int j = 0; j < 26; j++) {
                map[j] = sc.nextInt();
            }
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int j = 0; j < n; j++) {
                words[j] = sc.next();
            }
            boolean hasCollision = checkCollisions(map, words);
            System.out.println("Case #" + i + ": " + (hasCollision ? "YES" : "NO"));
        }
        sc.close();
    }

    private static boolean checkCollisions(int[] map, String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(map[word.charAt(i) - 'A']);
            }
            if (!set.add(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}
