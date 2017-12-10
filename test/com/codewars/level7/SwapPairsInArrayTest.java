package com.codewars.level7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapPairsInArrayTest {
    @Test
    public void test1(){
        SwapPairsInArray testS = new SwapPairsInArray();
        Integer[][] test1={{0,0},{1,1}};
        Integer[][][] sol1={{{0,0},{1,1}},{{0,0},{1,1}}};
        assertEquals(sol1,testS.swapp(test1));



    }

    @Test
    public void test2(){
        SwapPairsInArray testS = new SwapPairsInArray();


        Integer[][] test2={{1,0},{0,1}};
        Integer[][][] sol2={{{1,0},{0,1}},{{0,1},{1,0}}};
        assertEquals(sol2,testS.swapp(test2));


    }

    @Test
    public void test3(){
        SwapPairsInArray testS = new SwapPairsInArray();


        String[][] test3={{"aa","bb"},{"abc","def"}};
        String[][][] sol3={{{"aa","bb"},{"abc","def"}},{{"bb","aa"},{"def","abc"}}};
        assertEquals(sol3,testS.swapp(test3));


    }
}