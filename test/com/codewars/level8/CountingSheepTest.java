package com.codewars.level8;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CountingSheepTest {
    Boolean[] array1 = {true,  true,  true,  false,
            true,  true,  true,  true ,
            true,  false, true,  false,
            true,  false, false, true ,
            true,  true,  true,  true ,
            false, false, true,  true };

    @Test
    public void test() {
        assertEquals(17, CountingSheep.countSheeps(array1));
    }
}