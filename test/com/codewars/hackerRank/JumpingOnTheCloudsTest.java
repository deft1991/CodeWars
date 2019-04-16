package com.codewars.hackerRank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/16/2019
 */


class JumpingOnTheCloudsTest {

  int[] a = {0, 0, 1, 0, 0, 1, 0};
  int[] b = {0, 0, 0, 0, 1, 0};
  int[] c = {};

  @Test
  public void testJumpingOnTheClouds(){

  assertEquals(4, JumpingOnTheClouds.jumpingOnClouds(a));
  assertEquals(3, JumpingOnTheClouds.jumpingOnClouds(b));

  }

}