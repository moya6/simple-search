package com.bak.patryk.logic;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.newHashSet;

public class FileContentParser
{
    private static final Pattern WORD_PATTERN = Pattern.compile("([A-Za-z]+)");

    /**
     *
     * @param data
     * @return distinct set of words extracted from string
     */
    public static Set<String> extractWordsFromString(String data)
    {
        Matcher matcher = WORD_PATTERN.matcher(data);

        final Set<String> matches = new HashSet<>();
        while (matcher.find())
        {
            matches.add(matcher.group(0));
        }
        return matches;
    }
}
