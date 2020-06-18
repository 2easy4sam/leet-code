package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class Logger {

    private final Map<String, Integer> messageTimestampMap;
    private static final Integer TIME_LIMIT = 10;

    public Logger() {
        messageTimestampMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        boolean shouldPrint = true;

        if (messageTimestampMap.containsKey(message)) {
            shouldPrint = timestamp - messageTimestampMap.get(message) >= TIME_LIMIT;

            if (shouldPrint) messageTimestampMap.put(message, timestamp);
        } else {
            messageTimestampMap.put(message, timestamp);
        }

        return shouldPrint;
    }
}
