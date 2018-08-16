package com.bak.patryk.logic;

import java.util.Set;

class RankCalculator
{
    static Integer calculate(Set<String> wordsToSearch, Set<String> wordsList)
    {
        return calculateRankValue(wordsToSearch.size(), countOccurrences(wordsToSearch, wordsList));
    }

    private static long countOccurrences(Set<String> wordsToSearch, Set<String> wordsList)
    {
        return wordsToSearch.stream()
                .filter(searched -> occurs(searched, wordsList))
                .count();
    }

    private static boolean occurs(String searched, Set<String> wordsList)
    {
        return wordsList.stream()
                .anyMatch(word -> word.equals(searched));
    }

    private static Integer calculateRankValue(long length, long found)
    {
        return (int) ((found * 100.0f) / length);
    }
}
