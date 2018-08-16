package com.bak.patryk.logic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class RankingBuilder
{
    private final Map<String, Set<String>> fileWordsSetByFilenameMap;

    public RankingBuilder(Map<String, Set<String>> fileWordsSetByFilenameMap)
    {
        this.fileWordsSetByFilenameMap = fileWordsSetByFilenameMap;
    }

    /**
     * @param wordsToSearch
     * @return map where : Key - filename, Value - calculated rank value for file
     */
    List<Entry<String, Integer>> build(final Set<String> wordsToSearch)
    {
        return fileWordsSetByFilenameMap.entrySet().stream()
                .collect(toMap(Entry::getKey, entry -> RankCalculator.calculate(wordsToSearch, entry.getValue())))
                .entrySet().stream()
                .sorted(Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(toList());

    }
}
