package com.codewars.level6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sergey Golitsyn (deft) on 18.12.2018
 */
class RevRotTest {

  private static void testing(String actual, String expected) {
	assertEquals(expected, actual);
  }
  @Test
  void test1() {
	System.out.println("Fixed Tests: revRot");
	testing(RevRot.revRot("1234", 0), "");
	testing(RevRot.revRot("", 0), "");
	testing(RevRot.revRot("1234", 5), "");
	String s = "733049910872815764";
	testing(RevRot.revRot(s, 5), "330479108928157");
  }
}