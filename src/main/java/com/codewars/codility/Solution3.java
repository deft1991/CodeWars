package com.codewars.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 04.09.2023
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.solution(new long[][]{
                {7,9},
                {1,3},
                {8,15},
                {6,9},
                {2,4}
        })));
    }

    long[] solution(long[][] chunks) {
        List<Long> receivedBytesList = new ArrayList<>();
        long totalReceivedBytes = 0;

        for (long[] chunk : chunks) {
            long leftByte = chunk[0];
            long rightByte = chunk[1];
            long chunkSize = rightByte - leftByte + 1;

            if (totalReceivedBytes < rightByte) {
                // Overlapping or new chunk, add the new bytes to totalReceivedBytes
                chunkSize -= (rightByte - totalReceivedBytes);
                totalReceivedBytes = rightByte;
            }

            receivedBytesList.add(totalReceivedBytes);
            totalReceivedBytes = Math.max(totalReceivedBytes, chunkSize);
        }

        long[] result = new long[receivedBytesList.size()];
        for (int i = 0; i < receivedBytesList.size(); i++) {
            result[i] = receivedBytesList.get(i);
        }

        return result;
    }
}
