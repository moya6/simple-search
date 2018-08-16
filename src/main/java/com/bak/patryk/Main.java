package com.bak.patryk;

import com.bak.patryk.logic.FileLoader;
import com.bak.patryk.logic.InputProcessor;
import com.bak.patryk.logic.RankingBuilder;
import com.bak.patryk.logic.FileContentParser;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

import static com.google.common.collect.Sets.newHashSet;
import static com.bak.patryk.logic.ArgumentValidator.validate;
import static java.util.stream.Collectors.toMap;

public class Main
{
    public static void main(String[] args)
    {
        validate(args);

        // 1. Load files
        final Map<String, String> fileContentsByFilenameMap = FileLoader.loadTextFilesFromDirectory(new File(args[0]));
        fileContentsByFilenameMap.keySet().forEach(key -> System.out.println("Loaded: " + key));

        // 2. Create files contents representation
        Map<String, Set<String>> fileWordsSetByFilenameMap = fileContentsByFilenameMap.entrySet().stream()
                .collect(toMap(
                        Entry::getKey,
                        entry -> FileContentParser.extractWordsFromString(entry.getValue())));

        // 3. Go into main program loop
        new InputProcessor(new RankingBuilder(fileWordsSetByFilenameMap)).processUserInput();
    }

}
