package com.codewars.level6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Sergey Golitsyn (deft) on 18.12.2018
 * <p>
 * The input is a string str of digits. Cut the string into chunks
 * (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).
 * <p>
 * If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk;
 * otherwise rotate it to the left by one position.
 * Put together these modified chunks and return the result as a string.
 * <p>
 * If
 * <p>
 * sz is <= 0 or if str is empty return ""
 * sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
 * Examples:
 * revrot("123456987654", 6) --> "234561876549"
 * revrot("123456987653", 6) --> "234561356789"
 * revrot("66443875", 4) --> "44668753"
 * revrot("66443875", 8) --> "64438756"
 * revrot("664438769", 8) --> "67834466"
 * revrot("123456779", 8) --> "23456771"
 * revrot("", 8) --> ""
 * revrot("123456779", 0) --> ""
 * revrot("563000655734469485", 4) --> "0365065073456944"
 */
class RevRot {

  static String revRot(String strng, int sz) {
	if (sz <= 0 || strng.isEmpty() || sz > strng.length()) {
	  return "";
	}
	List<String> rez = cutStr(strng, sz);
	final String[] finalString = {""};
	rez.forEach(str -> collectFinalString(finalString, str));
	return finalString[0];
  }

  private static void collectFinalString(String[] finalString, String str) {
	String[] split = str.split("");
	double rezult = Stream.of(split).mapToDouble(digit -> Math.pow(Double.valueOf(digit), 3)).sum();
	if (rezult % 2 == 0) {
	  finalString[0] += new StringBuilder(str).reverse();
	} else {
	  List<String> strings = new ArrayList<>(Arrays.asList(split));
	  String remove = strings.remove(0);
	  finalString[0] += String.join("", strings) + remove;
	}
  }

  private static List<String> cutStr(String strng, int sz) {
	int start = 0, end = sz;
	List<String> rez = new ArrayList<>();
	while (end < strng.length()) {
	  String substring = strng.substring(start, end);
	  if (sz == substring.length()) {
		rez.add(substring);
	  }
	  start += sz;
	  end += sz;
	}
	return rez;
  }
}
