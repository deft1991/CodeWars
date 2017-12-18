package com.codewars.level7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MovesInSquaredStringsTest {
//    private static void testing(String actual, String expected) {
//        assertEquals(expected, actual);
//    }
    @Test
    public void test() {
        System.out.println("Fixed Tests vertMirror");
        String s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
        String r = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw";
        assertEquals(r,MovesInSquaredStrings.vertMirror(s));
        s = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx";
        r = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP";
        assertEquals(r,(MovesInSquaredStrings.vertMirror(s)));
        System.out.println("Fixed Tests horMirror");
        s = "lVHt\nJVhv\nCSbg\nyeCt";
        r = "yeCt\nCSbg\nJVhv\nlVHt";
        assertEquals(r,(MovesInSquaredStrings.horMirror(s)));
        s = "njMK\ndbrZ\nLPKo\ncEYz";
        r = "cEYz\nLPKo\ndbrZ\nnjMK";
        assertEquals(r,(MovesInSquaredStrings.horMirror(s)));
    }
}