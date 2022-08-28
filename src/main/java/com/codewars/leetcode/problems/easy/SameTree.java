package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 23.08.2022
 */
public class SameTree  {

    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if (p == null){
            return false;
        }
        if (q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);

        return isLeft && isRight;
    }
}
