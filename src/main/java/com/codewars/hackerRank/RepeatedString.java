package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int length = s.length();
        long total = n/length;
        long remainder = n%length;
        int countAinBase = getCountAinString(s);
        long totalCountA = countAinBase * total;
        String substring = s.substring(0, Math.toIntExact(remainder));
        int remainderA = getCountAinString(substring);
        return totalCountA + remainderA;
    }

    private static int getCountAinString(String s) {
        int indexOfA = 0;
        int countAinBase = 0;
        while (true){
             indexOfA = s.indexOf("a", indexOfA);
            if (-1 != indexOfA){
                countAinBase ++;
                indexOfA++;
            } else{
                break;
            }
        }
        return countAinBase;
    }

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
