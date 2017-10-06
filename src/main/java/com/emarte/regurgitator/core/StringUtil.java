/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.core;

public class StringUtil {
    static String[] getMandatoryParts(String string, char delimiter) {
        if(!string.contains(String.valueOf(delimiter))) {
            throw new IllegalArgumentException("string '" + string + "' does not contain character '" + delimiter + "'");
        }

        String[] parts = string.split("\\" + delimiter);

        if(parts.length == 0) {
            throw new IllegalArgumentException("string '" + string + "' cannot split on character '" + delimiter + "'");
        }

        return parts;
    }

    static String stripOptionalBeginning(String string, String beginning) {
        return string.startsWith(beginning) ? string.substring(beginning.length()) : string;
    }

    private static String capitaliseFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + (string.length() > 1 ? string.substring(1) : "");
    }

    static String reverseAndJoinWithDots(String[] parts) {
        StringBuilder builder = new StringBuilder(parts[parts.length - 1]);

        for (int i = 1; i < parts.length; i++) {
            builder.append(".").append(parts[parts.length - 1 - i]);
        }

        return builder.toString();
    }

    static String dashesToCamelCase(String string) {
        return camelCase(string.toLowerCase().split("-"));
    }

    private static String camelCase(String[] parts) {
        StringBuilder builder = new StringBuilder(capitaliseFirstLetter(parts[0]));

        for (int i = 1; i < parts.length; i++) {
            builder.append(capitaliseFirstLetter(parts[i]));
        }

        return builder.toString();
    }
}
