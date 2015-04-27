package pl.net.nowak.searchengine.domain.filter;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.AssertionErrors;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.api.dto.QueryResultDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import static pl.net.nowak.searchengine.api.dto.QueryResultDTOAssembler.results;

/**
 * Author: Maciek
 */
public class RegexResultFilterTest {


    private RegexResultFilter regexResultFilter;

    @Before
    public void before() {
        regexResultFilter = new RegexResultFilter();
    }


    @Test
    public void shouldFilterCollectionAgainstRegex() {
        //given
        List<QueryResultDTO> given = results("Pizza Hut", "Dominium", "Pizzaportal");
        String regex = "^P.*$";
        //when
        List<QueryResultDTO> filter = regexResultFilter.filter(given, regex);
        //then
        Assertions.assertThat(filter).hasSize(2);

    }

    @Test
    public void shouldReturnEmptyCollectionOnEmptyCollection() {
        //given
        List<QueryResultDTO> given = results();
        String regex = "^P.*$";
        //when
        List<QueryResultDTO> filter = regexResultFilter.filter(given, regex);
        //then
        Assertions.assertThat(filter).hasSize(0);

    }

    @Test
    public void shouldReturnFullCollectionWhenNoFilter() {
        //given
        List<QueryResultDTO> given = results("Pizza Hut", "Dominium", "Pizzaportal");
        String regex = null;
        //when
        List<QueryResultDTO> filter = regexResultFilter.filter(given, regex);
        //then
        Assertions.assertThat(filter).hasSize(given.size()).isEqualTo(given);
    }

    @Test
    public void shouldReturnEmptyCollectionWhenNullCollection() {
        //given
        List<QueryResultDTO> given = null;
        String regex = "^P.*$";
        //when
        List<QueryResultDTO> filter = regexResultFilter.filter(given, regex);
        //then
        Assertions.assertThat(filter).isNotNull().isEmpty();
    }



}
