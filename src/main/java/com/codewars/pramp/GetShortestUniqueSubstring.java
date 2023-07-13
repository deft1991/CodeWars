package com.codewars.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 09.02.2023
 */
public class GetShortestUniqueSubstring {
    static String getShortestUniqueSubstring(char[] arr, String str) {
        // your code goes here

        Map<Character, Integer> dict = new HashMap<>();
        int count = 0;
        for(char c : arr){
            count++;
            if(dict.containsKey(c)){
                dict.put(c, dict.get(dict) + 1);
            } else {
                dict.put(c, 1);
            }
        }

        Map<Character, Integer> currentDict = new HashMap<>();
        int startPoint = 0;

        for(int endPoint = 0; endPoint < str.length(); endPoint++){
            if(dict.containsKey(str.charAt(endPoint))){
                count--; // 0

                if(currentDict.containsKey(str.charAt(endPoint))) {
                    currentDict.put(str.charAt(endPoint), currentDict.get(str.charAt(endPoint))+1);
                } else {
                    currentDict.put(str.charAt(endPoint), 1);
                }

                while(dict.get(str.charAt(endPoint)) != currentDict.get(str.charAt(endPoint))){
                    currentDict.put(str.charAt(startPoint), currentDict.get(str.charAt(startPoint))-1);
                    startPoint++;
                    count++;
                }
            } else {
                if(dict.containsKey(str.charAt(startPoint))){
                    count++;
                    startPoint++;
                }
                endPoint--;

            }
            if(count == 0){
                return str.substring(startPoint, endPoint+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[]{'x', 'y', 'z'}, "xyyzyzyx"));
    }

}
