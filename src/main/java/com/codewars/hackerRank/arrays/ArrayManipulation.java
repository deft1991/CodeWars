package com.codewars.hackerRank.arrays;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/19/19
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each of the array element between two given indices, inclusive.
 * Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros n = 10 . Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  k between the indices a and b inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is 10 after all operations are performed.
 */
public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    static long arrayManipulationSlow(int n, int[][] queries) {
        long arr[] = new long[n];
        long max = 0;
        for (int i = 0; i < queries.length; i++) {
            int[] row = queries[i];

            for (int a = row[0] - 1; a <= row[1] - 1; a++) {
                arr[a] += row[2];
                if (max < arr[a]) {
                    max = arr[a];
                }
            }
        }
        return max;
    }

    static long arrayManipulation(int n, int[][] queries) {
        long[] rez = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int[] row = queries[i];
            int from = row[0];
            int to = row[1];
            int count = row[2];

            rez[from - 1] += count;

            if (to < n) {
                rez[to] -= count;
            }
        }

        long max = 0;
        long tmp = 0;
        for (long l : rez) {
            tmp += l;
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        scanner.close();
    }
}
