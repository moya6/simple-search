package com.bak.patryk.logic;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang3.StringUtils.SPACE;

public class InputProcessor
{
    private static final String LEGAL_SEARCH_QUERY_PATTERN = "[A-Za-z]+( [a-zA-Z]+)*$";
    private static final String QUIT_CMD = ":quit";

    private final RankingBuilder rankingBuilder;

    public InputProcessor(RankingBuilder rankingBuilder)
    {
        this.rankingBuilder = rankingBuilder;
    }

    public void processUserInput()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type " + QUIT_CMD + " to exit");
        String input;
        do
        {
            System.out.print(("search> "));
            input = keyboard.nextLine();
            if (input.matches(LEGAL_SEARCH_QUERY_PATTERN))
            {
                // 3. Create final ranking
                List<Map.Entry<String, Integer>> ranking = rankingBuilder.build(newHashSet(input.split(SPACE)));
                ranking.forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue() + " %"));
            } else if (!QUIT_CMD.equals(input))
            {
                System.out.println("Illegal query. Query must match pattern " + LEGAL_SEARCH_QUERY_PATTERN);
            }

        } while (!QUIT_CMD.equals(input));
    }
}
