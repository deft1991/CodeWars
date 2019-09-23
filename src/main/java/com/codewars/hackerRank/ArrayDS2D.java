package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayDS2D {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxCount = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length - 2; j++) {
            for (int i = 0; i < arr[0].length - 2; i++) {
                int count =
                        arr[j][i] + arr[j][i + 1] + arr[j][i + 2] + arr[j + 1][i + 1] + arr[j + 2][i] + arr[j + 2][i + 1] + arr[j
                                + 2][i + 2];
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        splitStr();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH.txt"));

        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private static void splitStr() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        for (int j = 0; j < words.length; j++) {
            String[] arr = words[j].split("");
            String odd = "";
            StringBuilder even = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    even.append(arr[i]);
                } else {
                    odd += arr[i];
                }
            }
            System.out.println(odd + " " + even);
        }
    }
}
