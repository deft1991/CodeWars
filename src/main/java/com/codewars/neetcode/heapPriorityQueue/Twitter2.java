package com.codewars.neetcode.heapPriorityQueue;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 14.10.2023
 */
public class Twitter2 {

    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray()));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray()));
        t.unfollow(1, 2);
        System.out.println(Arrays.toString(t.getNewsFeed(1).toArray()));
    }

    static class Twitter {

        Map<Integer, Set<Tweet>> userTweets;
        Map<Integer, Set<Integer>> followee;

        int order;
        int maxFeedCount = 10;


        public Twitter() {
            userTweets = new HashMap<>();
            followee = new HashMap<>();
            order = 0;
        }

        public void postTweet(int userId, int tweetId) {
            Set<Tweet> set = userTweets.getOrDefault(userId, new HashSet<>());
            set.add(new Tweet(tweetId, order++));
            userTweets.put(userId, set);

        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.order - a.order);

            if (userTweets.get(userId) != null){
                pq.addAll(userTweets.get(userId));
            }

            if (followee.get(userId) != null) {
                for (int f : followee.get(userId)) {
                    pq.addAll(userTweets.get(f));
                }
            }
            List<Integer> rez = new ArrayList<>();
            for (int i = 0; i < maxFeedCount; i++) {
                if (pq.peek() == null) {
                    return rez;
                }
                rez.add(pq.poll().id);
            }
            return rez;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> set = followee.getOrDefault(followerId, new HashSet<>());
            set.add(followeeId);
            followee.put(followerId, set);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = followee.getOrDefault(followerId, new HashSet<>());
            set.remove(followeeId);
            followee.put(followerId, set);
        }
    }

    static class Tweet {
        int id, order;

        Tweet(int id, int order) {
            this.id = id;
            this.order = order;
        }
    }
}
