package com.codewars.level7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class THBTest {
    @Test
    public void basicTest() {
        THB check = new THB();
        assertEquals("thhttttbbttt",
                new THB().testing("For those of you who would like to test your solution before submitting it."));
    }
}