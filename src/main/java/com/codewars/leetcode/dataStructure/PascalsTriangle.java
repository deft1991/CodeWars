package com.codewars.leetcode.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 03.04.2022
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        p.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        rez.add(a);
        if (numRows == 1){
            return rez;
        }

        for(int i = 1; i < numRows; i++){


            List<Integer> prev = rez.get(i-1);
            List<Integer> tmp = new ArrayList<>(prev.size() + 1);
            for(int j = 0; j < prev.size() + 1; j++){
                if(j == 0) {
                    tmp.add(prev.get(j));
                } else if (j == prev.size()){
                    tmp.add(prev.get(j-1));
                } else {
                    tmp.add(prev.get(j) + prev.get(j-1));
                }
            }
            rez.add(tmp);
        }
        return rez;
    }
}
