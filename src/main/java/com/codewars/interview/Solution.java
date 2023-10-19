package com.codewars.interview;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 29.08.2023
 */

/*

We want to develop a simple task scheduler. It should take a mapping of task_name to task_dependencies:

dependencies = {
   "load_data_a": [],
   "load_data_b": [],
   "clean_data_a": ["load_data_a"],
   "clean_data_b": ["load_data_b"],
   "merge_data": ["clean_data_a", "clean_data_b"],
   "aggregate_data": ["merge_data"],
}
The key is the task name, and the values are the tasks that must be executed before the given task.
These are two solutions:

[
   "load_data_a",
   "load_data_b",
   "clean_data_a",
   "clean_data_b",
   "merge_data",
   "aggregate_data",
]
[
   "load_data_a",
   "clean_data_a"
   "load_data_b",,
   "clean_data_b",
   "merge_data",
   "aggregate_data",
]
Write a function that takes this mapping and returns
a list with the task names so that the dependencies
for a given task always come before the given task.

----
task_dependencies:
[a b] [b c] [c d] [c e]
before a execute b
before b execute c
before c execute d
before c execute e

d and e without dependencies

      a
     /
    b
   /
  c
/ \
d  e

root[b] --> a
    [c] --> b
    [d] --> c
    [e] --> c

     d e
     | /
     c
     |
     b
     |
     a

Time (O(N))
Space O((N))

 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> strings = s.taskScheduler(new String[][]{
                {"b", "c"},
                {"e", null},
                {"a", "b"},
                {"c", "e"},
                {"d", null},
                {"c", "d"},
        });
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public List<String> taskScheduler(String[][] inputData){
        Map<String, Integer> indegree = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        Map<String, List<String>> graph = buildGraph(inputData, indegree, queue);
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){

            String cur = queue.poll();
            result.add(cur);
            if (graph.containsKey(cur)){
                for(String s : graph.get(cur)){
                    indegree.put(s, indegree.get(s) - 1);
                    if(indegree.get(s) == 0){
                        queue.add(s);
                    }
                }
            }
        }
        return result;
    }

    /*
    [a b] [b c] [c d] [c e]

    b -> new List
    add a
    indegree.put(a, 1)
    indegree.put(b, 1)
    indegree.put(c, 1)
    indegree.put(c, 2)
    graph(b, (a))
    graph(c, (b))
    graph(d, (c))
    graph(c, (c))




     */
    private Map<String, List<String>> buildGraph(String[][] inputData, Map<String, Integer> indegree, Queue<String> queue) {
        Map<String, List<String>> graph = new HashMap<>();

        for(String[] data : inputData){
            if(data[1] == null){
                queue.add(data[0]);
            }
            List<String> orDefault = graph.getOrDefault(data[1], new ArrayList<>());
            orDefault.add(data[0]);
            indegree.put(data[0], indegree.getOrDefault(data[0], 0) + 1);
            graph.put(data[1], orDefault);
        }

        return graph;
    }
}
