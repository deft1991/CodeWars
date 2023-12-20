package com.codewars.leetcode.daily;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 19.12.2023
 */
public class ImageSmoother {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.sort(list);
        ImageSmoother i = new ImageSmoother();
        int[][] ints = i.imageSmoother(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });

        for (int[] n : ints){
            System.out.println(Arrays.toString(n));
        }


    }

    public int[][] imageSmoother(int[][] img) {
        int[][] rez = new int[img.length][img[0].length];

        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                int count = 0;
                int el = 0;
                if(i - 1 >= 0){
                    int row = i - 1;
                    if(j - 1 >= 0){
                        count += img[row][j-1];
                        el++;
                    }
                    count += img[row][j];
                    el++;
                    if(j + 1 < img[0].length){
                        count += img[row][j+1];
                        el++;
                    }
                }
                if(j - 1 >= 0){
                    count += img[i][j-1];
                    el++;
                }
                count += img[i][j];
                el++;
                if(j + 1 < img[0].length){
                    count += img[i][j+1];
                    el++;
                }
                if(i + 1 < img.length){
                    int row = i + 1;
                    if(j - 1 >= 0){
                        count += img[row][j-1];
                        el++;
                    }
                    count += img[row][j];
                    el++;
                    if(j + 1 < img[0].length){
                        count += img[row][j+1];
                        el++;
                    }
                }

                rez[i][j] = count/el;
            }
        }
        return rez;
    }
}
