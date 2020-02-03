package com.codewars.courcera.week1;

import java.util.Arrays;
/*
 * Created by sgolitsyn on 2/2/20
 *
 * Union-find with specific canonical element.
 * Add a method 𝚏𝚒𝚗𝚍() to the union-find data type
 * so that 𝚏𝚒𝚗𝚍(𝚒) returns the largest element in the connected component containing ii.
 * The operations, 𝚞𝚗𝚒𝚘𝚗(), 𝚌𝚘𝚗𝚗𝚎𝚌𝚝𝚎𝚍(), and 𝚏𝚒𝚗𝚍() should all take logarithmic time or better.
 * For example, if one of the connected components is
 * {1,2,6,9},
 * then the 𝚏𝚒𝚗𝚍() method should return 9 for each of the four elements in the connected components.
 */
public class UnionFind2 {

    int[] arr;

    UnionFind2(int countElems) {
        this.arr = new int[countElems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    private void union(int p, int q) {
        int highestP = highest(p);
        int highestQ = highest(q);

        if (highestP != highestQ) {
            if (highestP > highestQ) {

                arr[q] = highestP;
            } else {
                arr[p] = highestQ;
            }
        }
    }

    private int highest(int p) {
        while (arr[p] != p) {
            arr[p] = arr[arr[p]];
            p = arr[p];
        }
        return p;
    }

    private boolean isConnected(int p, int q){
        return highest(p) == highest(q);
    }

    private int find(int i){
        return highest(i);
    }

    public static void main(String[] args) {
        UnionFind2 unionFind2 = new UnionFind2(100);
        unionFind2.union(1, 2);
        unionFind2.union(6, 2);
        unionFind2.union(6, 9);
        System.out.println(Arrays.toString(unionFind2.arr));
        System.out.println(unionFind2.find(1));
        System.out.println(unionFind2.find(2));
    }
}
