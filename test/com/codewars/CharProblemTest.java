package com.codewars;

import com.codewars.level8.CharProblem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharProblemTest {
    @Test
    public void test1() {
        assertEquals(5, CharProblem.howOld("5 years old"));
    }
    @Test
    public void test2() {
        assertEquals(9, CharProblem.howOld("9 years old"));
    }
    @Test
    public void test3() {
        assertEquals(1, CharProblem.howOld("1 year old"));
    }
}