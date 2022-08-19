package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 18.08.2022
 */
public class AverageLevelsBinaryTreeDFS {

    public static void main(String[] args) {

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> rez = new ArrayList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        dfs(root, levelMap, 0);

        for(Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()){
            List<Integer> level =   entry.getValue();
            int size = level.size();
            double count = 0;
            for(int i : level){
                count+= i;
            }
            rez.add(count / size);
        }
        return rez;

    }

    private static void dfs(TreeNode root, Map<Integer, List<Integer>> map, int level){
        if(root != null){
            if(map.containsKey(level)){
                map.get(level).add(root.val);
            } else {
                List<Integer> levelList = new ArrayList<>();
                levelList.add(root.val);
                map.put(level, levelList);
            }

            dfs(root.left, map, level + 1);
            dfs(root.right, map, level + 1);
        }
    }
}
