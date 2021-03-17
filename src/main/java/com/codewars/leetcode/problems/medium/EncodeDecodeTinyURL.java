package com.codewars.leetcode.problems.medium;

import java.util.HashMap;

/**
 * @author Sergey Golitsyn
 * created on 16.03.2021
 */
public class EncodeDecodeTinyURL {

    public static void main(String[] args) {
        EncodeDecodeTinyURL e = new EncodeDecodeTinyURL();
        System.out.println(e.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(e.decode("https://leetcode.com/-883463397"));
    }

    public static HashMap<String, String> longUrlToShort = new HashMap<>();
    public static HashMap<String, String> shortUrlToLong = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int index = longUrl.indexOf("/", 8);
        String sub = longUrl.substring(index + 1);
        String shortUrl = longUrl.substring(0, index + 1) + sub.hashCode();
        longUrlToShort.put(longUrl, shortUrl);
        shortUrlToLong.put(shortUrl, longUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrlToLong.get(shortUrl);
    }
}
