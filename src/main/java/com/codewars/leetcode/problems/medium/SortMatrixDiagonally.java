package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 05.06.2021
 * <p>
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row
 * or leftmost column and going in the bottom-right direction until reaching the matrix's end.
 * For example,
 * the matrix diagonal starting from mat[2][0],
 * where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 * <p>
 * Given an m x n matrix mat of integers,
 * sort each matrix diagonal in ascending order and return the resulting matrix.
 */
public class SortMatrixDiagonally {

    public static void main(String[] args) {
        SortMatrixDiagonally smd = new SortMatrixDiagonally();

        System.out.println(Arrays.toString(smd.diagonalSort(new int[][]{
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        })));

//        System.out.println(Arrays.toString(smd.diagonalSort(new int[][]{
//                {11,25,66,1,69,7},
//                {23,55,17,45,15,52},
//                {75,31,36,44,58,8},
//                {22,27,33,25,68,4},
//                {84,28,14,11,5,50}
//        })));
    }

    /**
     * Elements on Base diagonal have same i-j
     */
    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, MinHeap> diagonalMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                diagonalMap.putIfAbsent(i - j, new MinHeap());
                diagonalMap.get(i - j).push(mat[i][j]);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = diagonalMap.get(i - j).pop();
            }
        }
        return mat;
    }

    static class MaxHeap {
        List<Integer> heap;
        int lastElIdx;

        MaxHeap() {
            heap = new ArrayList<>();
            lastElIdx = -1;
        }

        void push(int value) {
            heap.add(value);
            lastElIdx++;
            this.swim();
        }

        private void swim() {
            int lastElIdxTmp = lastElIdx;
            if (lastElIdxTmp > 0) {
                while (heap.get(lastElIdxTmp) > heap.get(lastElIdxTmp / 2)) {
                    swap(lastElIdxTmp, lastElIdxTmp / 2);

                    lastElIdxTmp = lastElIdxTmp / 2;
                }
            }
        }

        private void swap(int lastElIdx, int parentIdx) {
            int tmp = heap.get(lastElIdx);
            heap.set(lastElIdx, heap.get(parentIdx));
            heap.set(parentIdx, tmp);
        }

        int pop() {
            int value = heap.get(0);
            heap.set(0, heap.get(lastElIdx));
            heap.remove(lastElIdx--);
            this.sink(0);
            return value;
        }

        private void sink(int idx) {
            while (2 * idx <= lastElIdx) {
                int greaterElIdx = 2 * idx;
                int rightIdx = 2 * idx + 1;
                if (rightIdx <= lastElIdx && heap.get(greaterElIdx) < heap.get(rightIdx)) {
                    greaterElIdx = rightIdx;
                }
                if (heap.get(idx) >= heap.get(greaterElIdx)) {
                    break;
                }
                swap(greaterElIdx, idx);
                idx = greaterElIdx;
            }
        }
    }

    static class MinHeap {
        List<Integer> heap;
        int lastIdx;

        MinHeap() {
            heap = new ArrayList<>();
            lastIdx = -1;
        }

        void push(int value) {
            heap.add(value);
            lastIdx++;
            swim();
        }

        private void swim() {
            int tmpLastIdx = lastIdx;

            while (heap.get(tmpLastIdx) < heap.get(tmpLastIdx / 2)) {
                swap(tmpLastIdx, tmpLastIdx / 2);
                tmpLastIdx = tmpLastIdx / 2;
            }
        }

        private void swap(int firstIdx, int secondIdx) {
            int tmp = heap.get(firstIdx);
            heap.set(firstIdx, heap.get(secondIdx));
            heap.set(secondIdx, tmp);
        }

        int pop() {
            int tmp = heap.get(0);
            heap.set(0, heap.get(lastIdx));
            lastIdx--;
            sink(0);
            return tmp;
        }

        private void sink(int idx) {
            while (2 * idx <= lastIdx) {
                int lessIdx = 2 * idx;

                if (lessIdx < lastIdx && heap.get(lessIdx) > heap.get(lessIdx + 1)) {
                    lessIdx++;
                }

                if (heap.get(idx) <= heap.get(lessIdx)) {
                    break;
                }
                swap(idx, lessIdx);
                idx = lessIdx;
            }
        }

    }
}
