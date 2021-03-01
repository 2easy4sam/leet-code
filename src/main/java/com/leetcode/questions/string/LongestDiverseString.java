package com.leetcode.questions.string;

import java.util.PriorityQueue;

public class LongestDiverseString {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
        pq.offer(new int[]{0, a});
        pq.offer(new int[]{1, b});
        pq.offer(new int[]{2, c});

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            char c1 = (char) (first[0] + 'a');

            if (sb.length() > 0) {
                if (sb.charAt(sb.length() - 1) == c1) {
                    if (!pq.isEmpty()) {
                        int[] second = pq.poll();
                        char c2 = (char) (second[0] + 'a');
                        int n = 2;

                        while (n > 0 && second[1] > 0) {
                            sb.append(c2);
                            second[1]--;
                            n--;
                        }

                        if (second[1] > 0) pq.offer(second);
                    } else {
                        break;
                    }
                } else {
                    int n = 2;

                    while (n > 0 && first[1] > 0) {
                        sb.append(c1);
                        first[1]--;
                        n--;
                    }

                    if (first[1] > 0) pq.offer(first);
                }
            } else {
                /*
                empty string
                */
                int n = 2;

                while (n > 0 && first[1] > 0) {
                    sb.append(c1);
                    first[1]--;
                    n--;
                }

                if (first[1] > 0) pq.offer(first);
            }
        }

        return sb.toString();
    }
}
