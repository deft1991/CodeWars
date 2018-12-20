package com.codewars.level6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sergey Golitsyn (deft) on 20.12.2018
 */
class MultiplesOfThreeOrFiveTest {

  @Test
  public void test() {
	assertEquals(23, new MultiplesOfThreeOrFive().solution(10));
  }
}