package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 13.02.2021
 * <p>
 * Given a list accounts, each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts.
 * Two accounts definitely belong to the same person
 * if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially,
 * but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts,
 * return the accounts in the following format: the first element of each account is the name,
 * and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [
 * ["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 * ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */
public class AccountsMerge {

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();

//        List<List<String>> a = new ArrayList<>();
//        List<String> b = new ArrayList<>();
//        b.add("John");
//        b.add("johnsmith@mail.com");
//        b.add("john00@mail.com");
//        a.add(b);
//
//        List<String> c = new ArrayList<>();
//        c.add("John");
//        c.add("johnnybravo@mail.com");
//        a.add(c);
//
//        List<String> d = new ArrayList<>();
//        d.add("John");
//        d.add("johnsmith@mail.com");
//        d.add("john_newyork@mail.com");
//        a.add(d);
//
//        List<String> e = new ArrayList<>();
//        e.add("Mary");
//        e.add("mary@mail.com");
//        a.add(e);
//
//        accountsMerge(a);

        /*
        [
        ["David","David0@m.co","David1@m.co"],
        ["David","David3@m.co","David4@m.co"],
        ["David","David4@m.co","David5@m.co"],
        ["David","David2@m.co","David3@m.co"],
        ["David","David1@m.co","David2@m.co"]]

        Expected:
        [["David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]
         */

        List<List<String>> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        b.add("David");
        b.add("David0@m.co");
        b.add("David1@m.co");
        a.add(b);

        List<String> c = new ArrayList<>();
        c.add("David");
        c.add("David3@m.co");
        c.add("David4@m.co");
        a.add(c);

        List<String> d = new ArrayList<>();
        d.add("David");
        d.add("David4@m.co");
        d.add("David5@m.co");
        a.add(d);

        List<String> e = new ArrayList<>();
        e.add("David");
        e.add("David2@m.co");
        e.add("David3@m.co");
        a.add(e);

        List<String> g = new ArrayList<>();
        g.add("David");
        g.add("David1@m.co");
        g.add("David2@m.co");
        a.add(g);

        accountsMerge.accountsMerge(a);

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailToInt = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        DSU dsu = new DSU();
        int counter = 0;
        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                if (!emailToInt.containsKey(email)) {
                    emailToInt.put(email, counter);
                }
                counter++;

                dsu.union(emailToInt.get(account.get(1)), emailToInt.get(email));
            }

        }

        Map<Integer, List<String>> rez = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = emailToInt.get(email);
            int root = dsu.root(index);
            rez.computeIfAbsent(root, x -> new ArrayList()).add(email);
        }

        for (List<String> component : rez.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(rez.values());
    }

    class DSU {

        int[] parent;

        public DSU() {
            parent = new int[10000];

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
