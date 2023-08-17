package com.codewars.tiktok;
import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 16.08.2023
 */
public class PointsOnLine {

    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point (2,2);
        Point c = new Point(3,3);
        Point d = new Point(1,1);
        int sum = maxPointsOnLine(new Point[]{a, b, c, d});
        System.out.println(sum);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        // todo getters
    }

    static int maxPointsOnLine(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}
