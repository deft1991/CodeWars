package com.codewars.interviewTasks;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 08.02.2021
 */
public class FindIntervalsPart2 {

    public static void main(String[] args) {
        System.out.println(format(List.of(1, 2, 3, 4, 6, 7, 9)));
        System.out.println(format(List.of(1, 3, 5, 7, 9)));
        System.out.println(format(List.of(1, 2, 3, 7, 8, 9)));

    }

    private static String format(List<Integer> sample) {
        StringBuilder sb = new StringBuilder();

        Integer end = null;
        Integer next = null;
        Integer current = null;

        if (sample.isEmpty()) {
            return "";
        }
        Integer start = sample.get(0);
        for (int i = 0; i <= sample.size() - 2; i++) {
            current = sample.get(i);
            next = sample.get(i + 1);
            if (next - current != 1) {
                if (sb.length() != 0){
                    sb.append(",");
                }
                sb.append(start);
                if (end != null) {
                    sb.append("-");
                    sb.append(current);
                }
                start = next;
                end = null;
            } else {
                end = current;
            }
        }

        if (sb.length() != 0){
            sb.append(",");
        }
        if (next - current == 1){

            sb.append(start);
            sb.append("-");
            sb.append(next);
        } else {
            sb.append(start);
        }
        return sb.toString();
    }
}
