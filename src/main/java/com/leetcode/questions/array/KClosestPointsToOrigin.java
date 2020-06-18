package com.leetcode.questions.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * We have a list of points on the plane.  Find the K closest points
 * to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean
 * distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed
 * to be unique (except for the order that it is in.)
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(point -> point[0] * point[0] + point[1] * point[1]));

        return Arrays.copyOfRange(points, 0, K);
    }
}
