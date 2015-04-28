package pl.net.nowak.searchengine.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import pl.net.nowak.core.ApiException;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.domain.eniro.EniroURLFactory;

import java.util.List;

public class QueryServiceTest {

    QueryService queryService;
    private final String apiCountry="se";
    private final String apiKey="6238017201957511800";
    private final String apiProfile="devmno";
    private final String apiURL="http://api.eniro.com/cs/search/basic";
    private final String apiVersion="1.1.3";

    @Before
    public void before() {
        queryService = new QueryService();
        queryService.resultFactory = new QueryResultFactory();
        queryService.taskExecutor = new SimpleAsyncTaskExecutor();
        queryService.urlFactory = new EniroURLFactory(apiURL,apiProfile,apiKey,apiCountry,apiVersion);
    }

    @Test
    public void shouldCreateMultipleRequests() throws ApiException {
        //given
        String[] searchWords = {"pizza","pasta","hotel","bank"};

        //when
        List<QueryResultDTO> results = queryService.search(searchWords);

        //then
        Assertions.assertThat(results).isNotNull();
    }


}