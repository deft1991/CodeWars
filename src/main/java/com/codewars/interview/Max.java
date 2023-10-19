package com.codewars.interview;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 12.10.2023
 */
public class Max {

    public static void main(String[] args) {
        Max m = new Max();
        System.out.println(m.intervals(List.of(1, 2, 3, 5, 6, 9)));
        System.out.println(m.intervals(List.of()));
        System.out.println(m.intervals(List.of(9)));
        System.out.println(m.intervals(List.of(2,8)));
    }

    /**
     * Return intervals in given sorted numbers sequence.
     *
     * [1, 2, 3, 5, 6, 9] => "1-3,5-6,9"
     * [] => ""
     * [9] => "9"
     * [2, 8] => "2,8"
     */
    String intervals(List<Integer> sortedNumbers) {
        if (sortedNumbers == null || sortedNumbers.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = 0;
        for (int i = 1; i < sortedNumbers.size(); i++){
            if(sortedNumbers.get(i) - sortedNumbers.get(end) > 1){
                sb.append(sortedNumbers.get(start));
                if (start != end){
                    sb.append("-");
                    sb.append(sortedNumbers.get(end));

                }
                sb.append(",");
                start = i;
                end = i;
            } else {
                end ++;
            }
        }
        sb.append(sortedNumbers.get(start));
        if (start != end){
            sb.append("-");
            sb.append(sortedNumbers.get(end));

        }

        return sb.toString();
    }
}
