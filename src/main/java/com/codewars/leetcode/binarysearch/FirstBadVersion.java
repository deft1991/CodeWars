package com.codewars.leetcode.binarysearch;

/*
 * Created by sgolitsyn on 2/11/20
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                if(!isBadVersion(mid - 1)){
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                if(isBadVersion(mid + 1)){
                    return mid + 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    //todo
    private boolean isBadVersion(int mid) {
        return false;
    }
}
