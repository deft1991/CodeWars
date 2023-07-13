package com.codewars.neetcode.heapPriorityQueue;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 12.04.2023
 */
public class Twitter {

    public static void main(String[] args) {
        Twitter t = new Twitter();
//        t.postTweet(1,5);
//        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray())); // 5
//        t.follow(1,2);
//        t.follow(1,2);
//        t.postTweet(2,6);
//        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray())); // 6, 5
//        t.unfollow(1,2);
//        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray())); // 5
//
//        t.postTweet(1,10);
//        t.postTweet(1,1);
//        t.postTweet(1,7);
//        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray())); // 5 10 1 7

//,,,,,,,,,3,5
        t.postTweet(10,5);
        t.postTweet(10,3);
        t.postTweet(10,101);
        t.postTweet(10,13);
        t.postTweet(10,10);
        t.postTweet(10,2);
        t.postTweet(10,94);
        t.postTweet(10,505);
        t.postTweet(10,333);
        t.postTweet(10,22);
        t.postTweet(10,11);
        System.out.println(Arrays.toString(t.getNewsFeed(10).toArray())); // 11,22,333,505,94,2,10,13,101,3
    }

    private Map<Integer, Set<Integer>> followee;
    private Map<Integer, Set<Tweet>> tweets;

    private int order;

    public Twitter() {
        followee = new HashMap<>();
        tweets = new HashMap<>();
        order  = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, order);
        order++;
        if (tweets.containsKey(userId)){
            tweets.get(userId).add(tweet);
        } else {
            Set<Tweet> s = new HashSet<>();
            s.add(tweet);
            tweets.put(userId, s);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(10, (a, b) -> b.order - a.order);
        if (tweets.containsKey(userId)){
            pq.addAll(tweets.get(userId));
        }

        if (followee.containsKey(userId)){
            Set<Integer> users = followee.get(userId);
            for(int user : users){
                if (tweets.containsKey(user)){
                    pq.addAll(tweets.get(user));
                }

            }
        }
        List<Integer> rez = new ArrayList<>(10);
        int counter = 0;
        while (!pq.isEmpty() && counter < 10){
            rez.add(pq.poll().tweetId);
            counter++;
        }
        return rez;
    }

    public void follow(int followerId, int followeeId) {
        if (followee.containsKey(followerId)){
            followee.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followee.put(followerId, set);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followee.containsKey(followerId)){
            followee.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        private int tweetId;
        private int order;

        Tweet(int tweetId, int order){
            this.tweetId = tweetId;
            this.order = order;
        }
    }
}
