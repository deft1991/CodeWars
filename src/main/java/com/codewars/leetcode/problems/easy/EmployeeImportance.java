package com.codewars.leetcode.problems.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 07.04.2021
 *
 *
 *
 *     Map<Integer, Employee> emap;
 *     public int getImportance(List<Employee> employees, int queryid) {
 *         emap = new HashMap();
 *         for (Employee e: employees) emap.put(e.id, e);
 *         return dfs(queryid);
 *     }
 *     public int dfs(int eid) {
 *         Employee employee = emap.get(eid);
 *         int ans = employee.importance;
 *         for (Integer subid: employee.subordinates)
 *             ans += dfs(subid);
 *         return ans;
 *     }
 */
public class EmployeeImportance {

    public static void main(String[] args) {
        EmployeeImportance e = new EmployeeImportance();

        Employee a = new Employee();
        a.id = 1;
        a.importance = 5;
        a.subordinates = List.of(2, 3);

        Employee b = new Employee();
        b.id = 2;
        b.importance = 3;

        Employee c = new Employee();
        c.id = 3;
        c.importance = 3;

        int importance = e.getImportance(List.of(a, b, c), 1);
        System.out.println(importance);
    }

    Map<Integer, Integer> influenceMap = new HashMap<>();
    Map<Integer, Employee> mapEmployee = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
//        boolean[] visited = new boolean[employees.size()];

        for (Employee employee : employees) {
            mapEmployee.put(employee.id, employee);
        }

        return calculateInfluence(mapEmployee.get(id));
    }

    private int calculateInfluence(Employee employee) {

        int importance = 0;

        if (employee.subordinates == null || employee.subordinates.isEmpty()){
            return employee.importance;
        }

        for (int i = 0; i < employee.subordinates.size(); i++) {
            Integer integer = employee.subordinates.get(i);
            if (influenceMap.containsKey(integer)) {
                importance += influenceMap.get(integer);
            } else {
                importance += calculateInfluence(mapEmployee.get(integer));
            }
        }

        return employee.importance + importance;
    }


    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
