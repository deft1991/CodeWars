package com.codewars.level6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BabyMagpiesTest {
//    private final String m1 = "BWBWBW";
//    private final String m2 = "BWBWBB";
//    private final String m3 = "WWWWBB";
    private final String m1 = "BBWWBBWBWB";
    private final String m3 = "WBBWBWBWWW";

//    @Test
//    public void child() {
//        assertEquals(true, BabyMagpies.child(m1, m2));
////        assertEquals(true, BabyMagpies.child(m2, m3));
//    }

    @Test
    public void grandchild() {
        assertEquals(false, BabyMagpies.grandchild(m1, m3));
    }

//    @Test
//    public void notChild() {
//        assertEquals(false, BabyMagpies.child(m1,m3));
//    }

}