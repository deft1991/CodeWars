package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Created by sgolitsyn on 1/18/20
 */
public class Contacts {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        Map<String, Integer> map = new HashMap<>();
        List<Integer> rezList = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            if (queries[i][0].equalsIgnoreCase("add")) {
                String s = queries[i][1];
                char[] e = s.toCharArray();
                for (int j = 0; j < e.length; j++) {
                    map.put(s.substring(0,j+1), map.getOrDefault(s.substring(0,j+1), 0) + 1);
                }
            } else if (queries[i][0].equalsIgnoreCase("find")) {
                    count = map.getOrDefault(queries[i][1], 0);
                rezList.add(count);
            }
        }
        return rezList.stream().mapToInt(Integer::new).toArray();
    }
}
