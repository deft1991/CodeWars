package com.codewars.courcera.week1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/*
 * Created by sgolitsyn on 2/2/20
 */
public class Percolation {


    private WeightedQuickUnionUF uf;
    private int size;
    private int width;
    private int[] open;

    public Percolation(int N) {
        this.size = N * N;
        this.width = N;
        this.open = new int[size];
        this.uf = new WeightedQuickUnionUF(size + 2);
    }

    private void checkBounds(int i, int j) {
        if (i < 0 || i > width) {
            throw new IllegalArgumentException("checkBounds exception");
        }
        if (j < 0 || j > width) {
            throw new IllegalArgumentException("checkBounds exception");
        }
    }

    private int ijTo1D(int i, int j) {
        checkBounds(i, j);
        return width * i + j;
    }

    public void open(int i, int j) {
        checkBounds(i, j);
        int num = ijTo1D(i, j);
        open[num] = 1;
        connectToOpenNeighbors(i, j);
    }

    public boolean isOpen(int i, int j) {
        checkBounds(i, j);
        int num = ijTo1D(i, j);
        return open[num] == 1;
    }

    private boolean isOpen(int el) {
        return open[el] == 1;
    }

    private void connectToOpenNeighbors(int i, int j) {
        checkBounds(i, j);
        int current = ijTo1D(i, j);
        int top;
        int bottom;
        int left;
        int right;

        if (j == width - 1) {
            right = j;
            left = j - 1;
        } else if (j == 0) {
            right = j + 1;
            left = j;
        } else {
            right = j + 1;
            left = j - 1;
        }

        if (i == 0) {
            top = i;
            bottom = i + 1;

        } else if (i == (width - 1)) {
            top = i - 1;
            bottom = i;
        } else {
            top = i - 1;
            bottom = i + 1;
        }

        int topEl = ijTo1D(top, j);
        int bottomEl = ijTo1D(bottom, j);
        int leftEl = ijTo1D(i, left);
        int rightEl = ijTo1D(i, right);

        if (i == 0) {
            uf.union(topEl, size);
            uf.union(current, size);

        } else if (i == (width - 1)) {
            uf.union(bottom, size + 1);
            uf.union(current, size + 1);
        }
        connectIfOpen(topEl, current);
        connectIfOpen(bottomEl, current);
        connectIfOpen(leftEl, current);
        connectIfOpen(rightEl, current);
    }

    private void connectIfOpen(int el, int index) {
        if (isOpen(el)) {
            uf.union(el, index);
        }
    }

    public boolean percolates() {
        return uf.connected(size, size + 1);
    }

    public int numberOfOpenSites() {
        int count = 0;
        for (int i : open) {
            if (i == 1) {
                count++;
            }
        }
        return count;
    }

    public boolean isFull(int i, int j) {
        checkBounds(i, j);
        return uf.connected(size, ijTo1D(i, j));
    }

    // x x x --> x 0 x --> x 0 x -- > x 0 x
    // x x x     x x x     x 0 x      x 0 0
    // x x x     x x x     x x x      x x 0

    public static void main(String[] args) {
        Percolation perc = new Percolation(3);
        perc.open(0, 1);
        perc.open(1, 1);
        perc.open(1, 2);
        perc.open(2, 2);
        boolean c = perc.isFull(1, 1);
        //boolean c1 = perc.uf.connected(perc.ijTo1D(1, 1), perc.ijTo1D(2, 1));
        //boolean c2 = perc.percolates();
        StdOut.println(c);
        //StdOut.println(c1);
        //StdOut.println(c2);
    }
}
