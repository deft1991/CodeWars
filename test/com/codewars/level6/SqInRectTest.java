package com.codewars.level6;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sergey Golitsyn (deft) on 17.12.2018
 */
class SqInRectTest {

  @Test
  public void test0() {
	List<Integer> res = new ArrayList<Integer>(Arrays.asList(14, 6, 6, 2, 2, 2));
	  assertEquals(res, SqInRect.sqInRect(20, 14));
  }

  @Test
  public void test1() {
	List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
	for (int r : res)
	  assertEquals(res, SqInRect.sqInRect(5, 3));
  }

  @Test
  public void test2() {
	List<Integer> res = new ArrayList<Integer>(Arrays.asList(4, 3, 1, 1, 1));
	  assertEquals(res, SqInRect.sqInRect(7, 4));
  }
  @Test
  public void test3() {
	assertEquals(null, SqInRect.sqInRect(5, 5));
  }

}