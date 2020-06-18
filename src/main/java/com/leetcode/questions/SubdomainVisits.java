package com.leetcode.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> subdomainVisits = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            Integer count = Integer.parseInt(parts[0]);
            String[] subdomains = parts[1].split("\\.");

            int lastIdx = subdomains.length - 1;

            for (int i = lastIdx; i > -1; i--) {

                int j = i;

                StringBuilder subdomainBuilder = new StringBuilder();
                String separator = "";

                do {
                    subdomainBuilder.append(separator).append(subdomains[j]);
                    separator = ".";
                    j++;
                } while (j < subdomains.length);

                String subdomain = subdomainBuilder.toString();

                if (!subdomainVisits.containsKey(subdomain)) {
                    subdomainVisits.put(subdomain, count);
                } else {
                    subdomainVisits.put(subdomain, subdomainVisits.get(subdomain) + count);
                }
            }
        }

        return subdomainVisits.entrySet().stream().map(entrySet -> entrySet.getValue() + " " + entrySet.getKey()).collect(Collectors.toList());
    }
}
