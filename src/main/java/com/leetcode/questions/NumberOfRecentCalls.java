package com.leetcode.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NumberOfRecentCalls {
    static class RecentCounter {
        private List<BigInteger> pings = new ArrayList();

        public RecentCounter() {

        }

        public int ping(int t) {
            pings.add(BigInteger.valueOf(t));
            int nPings = pings.size();
            BigInteger lowerBound = BigInteger.valueOf(t - 3000);
            int count = 1;

            for (int i = nPings - 2; i >= 0; i--) {
                if (pings.get(i).compareTo(lowerBound) >= 0) count++;
                else break;
            }

            return count;
        }
    }

}
