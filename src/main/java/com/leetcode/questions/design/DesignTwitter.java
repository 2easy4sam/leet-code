package com.leetcode.questions.design;

import java.util.*;
import java.util.stream.Collectors;

public class DesignTwitter {
    // timestamp
    private int ts;

    // userId <-> followees
    private Map<Integer, Set<Integer>> followeeMap;
    // userId <-> tweet ids [time, tweetId]
    private Map<Integer, List<int[]>> tweetMap;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        ts = 0;
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{ts++, tweetId});
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> tweets = new ArrayList<>();
        Set<Integer> followeeIds = followeeMap.getOrDefault(userId, new HashSet<>());
        followeeIds.add(userId);

        for (int followeeId : followeeIds) {
            tweets.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }

        tweets.sort((a, b) -> b[0] - a[0]);

        return tweets.subList(0, tweets.size() >= 10 ? 10 : tweets.size()).stream().map(i -> i[1]).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followeeMap.putIfAbsent(followerId, new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeIds = followeeMap.getOrDefault(followerId, new HashSet<>());

        if (followeeIds.contains(followeeId)) followeeIds.remove(followeeId);
    }
}
