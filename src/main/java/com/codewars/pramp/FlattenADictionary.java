package com.codewars.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 14.02.2023
 */
public class FlattenADictionary {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("Key1", "Value1");

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("Key22", "Value22");


        map.put("Key2", map1);

        System.out.println(flattenDictionary(map));

    }

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> resultMap = new HashMap<>();

        flatten(dict, "", resultMap);

        return resultMap;
    }

    static void flatten(HashMap<String, Object> dict, String prevKey, HashMap<String, String> rezMap) {


        for (Map.Entry<String, Object> entry : dict.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();


            if (value instanceof String) {
                if (prevKey.isEmpty()) {
                    rezMap.put(key, (String) value);
                } else {
                    if (key.isEmpty()) {
                        rezMap.put(prevKey, (String) value);
                    } else {
                        rezMap.put(prevKey + "." + key, (String) value);
                    }
                }
            } else {
                if (prevKey.isEmpty() || prevKey == null) {
                    flatten((HashMap<String, Object>) value, key, rezMap);

                } else {

                    flatten((HashMap<String, Object>) value, prevKey + "." + key, rezMap);
                }

            }
        }
    }

}
