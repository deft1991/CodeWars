package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 18.08.2022
 */
public class AverageLevelsBinaryTreeDFS2 {

    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> rez = new ArrayList<>();
        List<Integer> levelCount = new ArrayList<>();
        dfs(root, rez, levelCount, 0);

        for(int i = 0; i < rez.size(); i++){
            rez.set(i, rez.get(i) / levelCount.get(i));
        }
        return rez;

    }

    private void dfs(TreeNode root, List<Double> rez, List<Integer> levelCount, int level){
        if(root != null){
            if(level < levelCount.size()){
                rez.set(level, rez.get(level) + root.val);
                levelCount.set(level, levelCount.get(level) + 1);
            } else {
                rez.add(1.0 * root.val);
                levelCount.add(1);
            }

            dfs(root.left, rez, levelCount, level + 1);
            dfs(root.right, rez, levelCount, level + 1);
        }
    }
}
