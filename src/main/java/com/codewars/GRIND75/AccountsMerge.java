package com.codewars.GRIND75;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 26.09.2023
 */
public class AccountsMerge {

    public static void main(String[] args) {
        AccountsMerge a = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(List.of("David","David0@m.co","David1@m.co"));
        accounts.add(List.of("David","David3@m.co","David4@m.co"));
        accounts.add(List.of("David","David4@m.co","David5@m.co"));
        accounts.add(List.of("David","David2@m.co","David3@m.co"));
        accounts.add(List.of("David","David1@m.co","David2@m.co"));
        List<List<String>> lists = a.accountsMerge(accounts);
        System.out.println();
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //  Collections.disjoint(A, B)

        Map<String, List<SortedSet<String>>> map = new HashMap<>();

        for(List<String> account : accounts){
            String name = account.get(0);
            List<String> emails = account.subList(1, account.size());
            boolean added = false;
            if(map.containsKey(name)){
                List<SortedSet<String>> list = map.get(name);
                for(SortedSet<String> set : list){
                    if(!Collections.disjoint(set, emails) && !added){
                        set.addAll(emails);
                        added = true;
                    }
                }
                if(!added){
                    SortedSet<String> set = new TreeSet<>(emails);
                    list.add(set);
                }
            } else {
                List<SortedSet<String>> list = new ArrayList<>();
                SortedSet<String> set = new TreeSet<>(emails);
                list.add(set);
                map.put(name, list);
            }
        }
        // prepare result
        List<List<String>> rez = new ArrayList<>();

        for(Map.Entry<String, List<SortedSet<String>>> entry : map.entrySet()){
            for(SortedSet<String> set : entry.getValue()){
                List<String> tmp = new ArrayList<>();
                tmp.add(entry.getKey());
                tmp.addAll(set);
                rez.add(tmp);
            }
        }
        return rez;
    }
}
