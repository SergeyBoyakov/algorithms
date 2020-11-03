package com.sb.algorithms.codewars;

public class AlternateCapitalization {
    public String[] capitalize(final String s) {
        String[] result = new String[2];
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                first.append(s.substring(i, i + 1).toUpperCase());
            } else {
                first.append(s.substring(i, i + 1));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                second.append(s.substring(i, i + 1).toUpperCase());
            } else {
                second.append(s.substring(i, i + 1));
            }
        }
        result[0] = first.toString();
        result[1] = second.toString();

        return result;
    }
}
