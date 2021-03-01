package com.leetcode.questions;

import java.util.*;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        /*
        - test cases:
            -   [1,2,3,6,2,3,4,7,8]
            map             combo
            {               [1]
                1: 0,
                2: 2,
                3: 2,
                4: 1,
                6: 1,
                7: 1,
                8: 1
            }

            {               [1,2]
                2: 1,
                3: 2,
                4: 1,
                6: 1,
                7: 1,
                8: 1
            }

            {               [1,2,3]
                2: 1,
                3: 1,
                4: 1,
                6: 1,
                7: 1,
                8: 1
            }
        */

        if (hand.length % W != 0) return false;

        Map<Integer, Integer> map = new TreeMap<>();

        /*
        O(n)
        */
        for (int num : hand)
            map.put(num, map.getOrDefault(num, 0) + 1);

        while (!map.isEmpty()) {
            Stack<Integer> group = new Stack<>();
            Set<Integer> nums = new HashSet<>(map.keySet());

            for (int num : nums) {
                if (!group.isEmpty() && num - 1 != group.peek())
                    return false;
                group.push(num);
                int cnt = map.get(num) - 1;
                if (cnt == 0) map.remove(num);
                else map.put(num, cnt);

                if (group.size() == W) break;
            }
        }

        return true;
    }
}
