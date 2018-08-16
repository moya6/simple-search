package com.bak.patryk.logic;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class FileContentParserTest
{
    @Test
    public void test()
    {
        // given
        String data = "AAA$$BB CC. DD";

        // when
        List<String> result = new ArrayList<>(FileContentParser.extractWordsFromString(data));
        sort(result);

        // then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.size()).isEqualTo(4);
        softly.assertThat(result.get(0)).isEqualTo("AAA");
        softly.assertThat(result.get(1)).isEqualTo("BB");
        softly.assertThat(result.get(2)).isEqualTo("CC");
        softly.assertThat(result.get(3)).isEqualTo("DD");
        softly.assertAll();
    }
}