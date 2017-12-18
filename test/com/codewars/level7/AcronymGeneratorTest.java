package com.codewars.level7;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AcronymGeneratorTest {
    @Test
    public void testSimple0() throws Exception {
        assertEquals("MvLM", AcronymGenerator.createAcronym("von Lahnstein Meyer", "Martin"));
    }

    @Test
    public void testSimple() throws Exception {
        assertEquals("TM", AcronymGenerator.createAcronym("Meyer", "Thomas"));
    }

    @Test
    public void testMultipleLastNames() throws Exception {
        assertThat(AcronymGenerator.createAcronym("Meyer-Schmidt", "Paul"), is("PMS"));
    }

    @Test
    public void testMultipleFirstNamesWithBlank() throws Exception {
        assertThat(AcronymGenerator.createAcronym("Mueller", "Jan Erich"), is("JEM"));
    }

    @Test
    public void testMultipleFirstNamesWithDash() throws Exception {
        assertThat(AcronymGenerator.createAcronym("Schmidt", "Jan-Erich"), is("JES"));
    }

    @Test
    public void testVonName() throws Exception {
        assertThat(AcronymGenerator.createAcronym("von Lahnstein", "Peter"), is("PvL"));
    }
}