package pl.net.nowak.searchengine.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class QueryResultFactoryTest {

    private String json;
    private QueryResultFactory queryResultFactory;

    @Before
   public void before() throws URISyntaxException, IOException {
       URL url = this.getClass().getResource("/sample_response.json");
       byte[] encoded = Files.readAllBytes(Paths.get(url.toURI()));
       json = new String(encoded,Charset.defaultCharset());

        this.queryResultFactory = new QueryResultFactory();
   }

    @Test
    public void shouldParsJson() throws IOException {
        //given

        //when
        List<QueryResultDTO> list = queryResultFactory.parseJSON(json);

        //then
        Assertions.assertThat(list).isNotNull().isNotEmpty().hasSize(25);


    }


}