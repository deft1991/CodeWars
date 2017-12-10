package com.codewars.level8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Counting sheep...
*
* For example,

[true,  true,  true,  false,
  true,  true,  true,  true ,
  true,  false, true,  false,
  true,  false, false, true ,
  true,  true,  true,  true ,
  false, false, true,  true]
* */
public class CountingSheep {
    public static int countSheeps(Boolean[] arrayOfSheeps) {
        ArrayList<Boolean> list = new ArrayList();
        list.addAll(Arrays.asList(arrayOfSheeps));
        list.removeAll(Collections.singleton(false));
        list.removeAll(Collections.singleton(""));
//        for (Boolean arrayOfSheep : arrayOfSheeps) {
//            if (arrayOfSheep != null)
//                if (arrayOfSheep)
//                    list.add(arrayOfSheep);
//        }
        return list.size();
    }
}
