package com.sb.algorithms.algoexpert;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> sortedToSource = new HashMap<>();

        for (String word : words) {
            String sortedString = toSortedString(word);
            List<String> group = sortedToSource.getOrDefault(sortedString, new ArrayList<>());
            group.add(word);
            sortedToSource.put(sortedString, group);
        }

        return sortedToSource.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private static String toSortedString(final String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
