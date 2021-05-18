/*
https://leetcode.com/problems/reorder-data-in-log-files/
 */
package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] logSplit = log.split(" ");
            if (isNumeric(logSplit[1])) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] log1Split = splitId(log1);
                String[] log2Split = splitId(log2);
                int compare = log1Split[1].compareTo(log2Split[1]);
                if (compare == 0) {
                    return log1Split[0].compareTo(log2Split[0]);
                } else {
                    return compare;
                }
            }
        });

        letterLogs.addAll(digitLogs);
        String[] letterLogsArr = new String[letterLogs.size()];
        letterLogsArr = letterLogs.toArray(letterLogsArr);
        return letterLogsArr;

    }

    private String[] splitId(String log) {
        int spaceIndex = log.indexOf(" ");
        String id = log.substring(0,spaceIndex);
        String rest = log.substring(spaceIndex + 1, log.length());
        return new String[]{id, rest};
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            System.out.println(str + false);
            return false;
        }
        System.out.println(str + true);
        return true;
    }
}