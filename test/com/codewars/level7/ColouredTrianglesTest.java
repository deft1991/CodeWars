package com.codewars.level7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColouredTrianglesTest {
    @Test
    public void examples() {
        // assertEquals("expected", "actual");
        assertEquals('B', ColouredTriangles.triangle("B"));
        assertEquals('R', ColouredTriangles.triangle("GB"));
        assertEquals('R', ColouredTriangles.triangle("RRR"));
        assertEquals('B', ColouredTriangles.triangle("RGBG"));
        assertEquals('G', ColouredTriangles.triangle("RBRGBRB"));
        assertEquals('G', ColouredTriangles.triangle("RBRGBRBGGRRRBGBBBGG"));
    }
}