package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 13.02.2021
 * <p>
 * Given an array equations of strings that represent relationships between variables,
 * each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".
 * Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 * <p>
 * Example 1:
 * <p>
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1,
 * then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * Example 2:
 * <p>
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 * <p>
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 * <p>
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 * <p>
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 */
public class SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations s = new SatisfiabilityOfEqualityEquations();

        System.out.println(s.equationsPossible(new String[]{"a==b","b!=a"})); // false
        System.out.println(s.equationsPossible(new String[]{"b==a","a==b"})); // true
        System.out.println(s.equationsPossible(new String[]{"a==b","b==c","a==c"})); // true
        System.out.println(s.equationsPossible(new String[]{"a==b","b!=c","c==a"})); // false
        System.out.println(s.equationsPossible(new String[]{"c==c","b==d","x!=z"})); // true

    }


    public boolean equationsPossible(String[] equations) {

        DSU dsu = new DSU(26); // alphabet

        // first loop for '==' union
        for (String current : equations) {
            if (current.startsWith("==", 1)) {
                dsu.union(current.charAt(0) - 'a', current.charAt(3) - 'a');
            }
        }

        // second loop for check un
        for (String current : equations) {
            if (current.startsWith("!=", 1)) {
                if (dsu.isConnected(current.charAt(0) - 'a', current.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;

    }

    class DSU {
        int[] parent;

        DSU(int N) {
            parent = new int[N];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            if (!isConnected(i, j)) {
                int rootI = root(i);
                int rootJ = root(j);
                parent[rootJ] = rootI;
            }
        }

        private boolean isConnected(int i, int j) {
            return root(i) == root(j);
        }

        private int root(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
