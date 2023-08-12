package com.codewars.GRIND75;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2023
 */
public class KClosestPointsOrigin {

    public static void main(String[] args) {
        KClosestPointsOrigin k = new KClosestPointsOrigin();
        int[][] ints = k.kClosest(new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        }, 2);

        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        Heap h = new Heap(k);

        for (int[] point : points) {
            h.add(new Point(point[0], point[1]));
        }

        int[][] rez = new int[k][2];

        for (int i = k - 1; i >= 0; i--) {
            Point p = h.getMax();
            rez[i][0] = p.x;
            rez[i][1] = p.y;
        }
        return rez;
    }

    class Heap {
        Point[] arr;
        int maxSize;
        int curSize;

        Heap(int maxSize) {
            this.maxSize = maxSize + 1;
            arr = new Point[maxSize + 1];
            curSize = 1;
        }

        public Point getMax() {
            Point max = arr[1];
            swap(1, --curSize);
            sink();
            return max;
        }

        public void add(Point p) {
            if (curSize < maxSize) {
                this.arr[curSize++] = p;
                this.swim();
            } else {
                // add closest point
                if (this.peek().distance > p.distance) {
                    this.arr[1] = p;
                    this.sink();
                }
            }
        }

        public void swim() {
            int cur = curSize - 1;
            while (cur > 1 && arr[cur].distance > arr[cur / 2].distance) {
                swap(cur, cur / 2);
                cur = cur / 2;
            }
        }

        public void sink() {
            int cur = 1;
            while (cur * 2 < curSize) {
                int idx = cur * 2;
                if (idx + 1 < curSize && arr[idx].distance < arr[idx + 1].distance) {
                    idx++;
                }
                if (arr[cur].distance < arr[idx].distance) {
                    swap(cur, idx);
                }
                cur = idx;
            }
        }

        public void swap(int i, int j) {
            Point tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public Point peek() {
            return arr[1];
        }
    }

    class Point {
        double distance;
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            double xRez = Math.pow(-x, 2);
            double yRez = Math.pow(-y, 2);
            distance = Math.abs(Math.sqrt(xRez + yRez));
        }
    }
}
