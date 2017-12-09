package com.codewars.level8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReturnNegativeTest {
    @Test
    public void test1() {
        assertEquals(-42, ReturnNegative.makeNegative(42));
    }

    @Test
    public void test2() {
        assertEquals(-9, ReturnNegative.makeNegative(-9));
    }

    @Test
    public void test3() {
        assertEquals(0, ReturnNegative.makeNegative(0));
    }
}