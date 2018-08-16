package com.bak.patryk.logic;


import com.google.common.collect.ImmutableMap;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

// todo with spring beans and mockito we could separate testing of RankingBuilder and RankCalculator
public class RankingBuilderTest
{
    @Test
    public void test()
    {
        // given
        final Set<String> wordsToSearch = newHashSet("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
        final Map<String, Set<String>> wordsMap = ImmutableMap.<String, Set<String>>builder().
                put("file1", newHashSet("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K")).
                put("file2", newHashSet("A", "B", "C", "D", "E", "F", "G", "H", "I")).
                put("file3", newHashSet("A", "B", "C", "D", "E", "F")).
                put("file4", newHashSet("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")).
                put("file5", newHashSet("A", "B", "C", "D", "E", "F", "G")).
                put("file6", newHashSet("A", "B")).
                put("file7", newHashSet("A", "B", "C", "D", "E", "F", "G", "H")).
                put("file8", newHashSet("A", "B", "C", "D", "E")).
                put("file9", newHashSet("A", "B", "C")).
                put("file10", newHashSet("")).
                put("file11", newHashSet("A", "B", "C", "D")).
                put("file12", newHashSet("A")).
                build();

        // when
        List<Map.Entry<String, Integer>> result = new RankingBuilder(wordsMap).build(wordsToSearch);

        // then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.size()).isEqualTo(10);
        softly.assertThat(result.get(0).getKey()).isEqualTo("file1");
        softly.assertThat(result.get(0).getValue()).isEqualTo(100);
        softly.assertThat(result.get(1).getKey()).isEqualTo("file4");
        softly.assertThat(result.get(1).getValue()).isEqualTo(90);
        softly.assertThat(result.get(2).getKey()).isEqualTo("file2");
        softly.assertThat(result.get(2).getValue()).isEqualTo(81);
        softly.assertThat(result.get(3).getKey()).isEqualTo("file7");
        softly.assertThat(result.get(3).getValue()).isEqualTo(72);
        softly.assertThat(result.get(4).getKey()).isEqualTo("file5");
        softly.assertThat(result.get(4).getValue()).isEqualTo(63);
        softly.assertThat(result.get(5).getKey()).isEqualTo("file3");
        softly.assertThat(result.get(5).getValue()).isEqualTo(54);
        softly.assertThat(result.get(6).getKey()).isEqualTo("file8");
        softly.assertThat(result.get(6).getValue()).isEqualTo(45);
        softly.assertThat(result.get(7).getKey()).isEqualTo("file11");
        softly.assertThat(result.get(7).getValue()).isEqualTo(36);
        softly.assertThat(result.get(8).getKey()).isEqualTo("file9");
        softly.assertThat(result.get(8).getValue()).isEqualTo(27);
        softly.assertThat(result.get(9).getKey()).isEqualTo("file6");
        softly.assertThat(result.get(9).getValue()).isEqualTo(18);
        softly.assertAll();
    }
}