package com.codewars.level6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Sergey Golitsyn (deft) on 17.12.2018
 * <p>
 * Backwards Read Primes are primes that when read backwards in base 10 (from right to left) are a different prime.
 * (This rules out primes which are palindromes.)
 * <p>
 * Examples:
 * 13 17 31 37 71 73 are Backwards Read Primes
 * 13 is such because it's prime and read from right to left writes 31 which is prime too. Same for the others.
 * <p>
 * Task
 * Find all Backwards Read Primes between two positive given numbers (both inclusive),
 * the second one always being greater than or equal to the first one. The resulting array or the resulting string will be ordered following the natural order of the prime numbers.
 * <p>
 * Example
 * backwardsPrime(2, 100) => [13, 17, 31, 37, 71, 73, 79, 97]
 * backwardsPrime(9900, 10000) => [9923, 9931, 9941, 9967] backwardsPrime(501, 599) => []
 * <p>
 * backwardsPrime(2, 100) => "13 17 31 37 71 73 79 97"
 * backwardsPrime(9900, 10000) => "9923 9931 9941 9967"
 */
public class BackWardsPrime {

  public static String backwardsPrime(long start, long end) {
	ArrayList<Long> rez = new ArrayList<>();
	// your code
	for (long st = start; st <= end; st++) {
	  BigInteger bigInteger = new BigInteger(String.valueOf(st));
	  boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(st));
	  StringBuilder sb = new StringBuilder(String.valueOf(st));
	  sb = sb.reverse();
	  bigInteger = new BigInteger(sb.toString());
	  boolean probablePrimeReverse = bigInteger.isProbablePrime((int) Math.log(Double.valueOf(sb.toString())));
	  if (probablePrime && probablePrimeReverse && st != Long.valueOf(sb.toString())) {
		rez.add(st);
	  }
	}
	return rez.stream()
			.map(Object::toString)
			.collect(Collectors.joining(" "))
			.trim();
  }
}
