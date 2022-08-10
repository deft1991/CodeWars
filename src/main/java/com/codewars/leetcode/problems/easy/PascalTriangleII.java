package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 25.07.2022
 */
public class PascalTriangleII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRow(3).toArray()));
    }

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            return List.of(1);
        }
        if(rowIndex == 1){
            return List.of(1, 1);
        }

        List<List<Integer>> triangle = new ArrayList();
        triangle.add(List.of(1));
        triangle.add(List.of(1, 1));

        for(int i = 2; i <= rowIndex; i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            List<Integer> prevList = triangle.get(i - 1);
            for (int j = 1; j < prevList.size(); j++){

                int a = prevList.get(j - 1) +  prevList.get(j);
                tmp.add(a);
            }
            tmp.add(1);
            triangle.add(tmp);
        }
        return triangle.get(rowIndex);
    }
}
