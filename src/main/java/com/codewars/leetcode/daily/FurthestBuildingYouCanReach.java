package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 17.02.2024
 */
public class FurthestBuildingYouCanReach {

    public static void main(String[] args) {
        FurthestBuildingYouCanReach f = new FurthestBuildingYouCanReach();
        System.out.println(f.furthestBuilding(new int[]{1,5,1,2,3,4,10000}, 4, 1));
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        int rez = 0;
        for(int i = 1; i < heights.length; i++){
            if(heights[i-1] > heights[i]){
                rez = i;
            } else {
                if(heights[i] - heights[i-1] <= bricks){
                    bricks -= heights[i] - heights[i-1];
                    rez = i;
                } else if(ladders > 0) {
                    ladders--;
                    rez = i;
                } else {
                    return i-1;
                }
            }
        }
        return rez;

    }
}
