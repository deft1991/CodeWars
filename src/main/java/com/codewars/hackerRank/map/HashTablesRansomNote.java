package com.codewars.hackerRank.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/21/19
 *
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class HashTablesRansomNote {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineWords = new HashMap<>();

        for (String s : magazine) {
            magazineWords.merge(s, 1, Integer::sum);
        }

        for (String s : note) {
            magazineWords.merge(s, -1, (old, newV) -> old - 1);
        }

        boolean isEnought = false;
        for (Integer value : magazineWords.values()) {
            if (value < 0){
                if (isEnought){
                    System.out.println("No");
                    return;
                }
                isEnought = true;
            }
        }

        if (isEnought){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
