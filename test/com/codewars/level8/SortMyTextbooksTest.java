package com.codewars.level8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortMyTextbooksTest {

    @Test
    void basicTest() {
        ArrayList<String> sorted = new ArrayList<>();
        ArrayList<String> strs = new ArrayList<>();
        for (String s : new String[]{"Algebra", "History", "Geometry", "English"})
            strs.add(s);
        for (String s : new String[]{"Algebra", "English", "Geometry", "History"})
            sorted.add(s);
        assertEquals(sorted, SortMyTextbooks.sort(strs));
    }

    @Test
    void capitalizationTest() {
        ArrayList<String> sorted = new ArrayList<>();
        ArrayList<String> strs = new ArrayList<>();
        for (String s : new String[]{"Algebra", "history", "Geometry", "english"})
            strs.add(s);
        for (String s : new String[]{"Algebra", "english", "Geometry", "history"})
            sorted.add(s);
        assertEquals(sorted, SortMyTextbooks.sort(strs));
    }

    @Test
    void symbolsTest() {
        ArrayList<String> sorted = new ArrayList<>();
        ArrayList<String> strs = new ArrayList<>();
        for (String s : new String[]{"Alg#bra", "$istory", "Geom^try", "**English"})
            strs.add(s);
        for (String s : new String[]{"$istory", "**English", "Alg#bra", "Geom^try"})
            sorted.add(s);
        assertEquals(sorted, SortMyTextbooks.sort(strs));
    }
}