package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 23.12.2023
 */
public class PathCrossing {

    public static void main(String[] args) {
        PathCrossing p = new PathCrossing();
        System.out.println(p.isPathCrossing("NES"));
        System.out.println(p.isPathCrossing("NNSWWEWSSESSWENNW")); // true

    }

    public boolean isPathCrossing(String path) {
        int n = 0;
        int e = 0;

        for(char c : path.toCharArray()){
            switch(c){
                case 'N':
                    n++;
                    break;
                case 'S':
                    n--;
                    break;
                case 'E':
                    e++;
                    break;
                case 'W':
                    e--;
                    break;
            }
            if(n == 0 && e == 0){
                return true;
            }
        }
        return false;
    }

}
