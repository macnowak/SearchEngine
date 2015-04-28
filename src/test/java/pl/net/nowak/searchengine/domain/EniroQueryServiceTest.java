package pl.net.nowak.searchengine.domain;

import org.junit.Test;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.util.List;

/**
 * Author: Maciek
 */
public class EniroQueryServiceTest {


    @Test
    public void shouldCallRestApi() {

        EniroQueryService service = new EniroQueryService();

        service.apiCountry="se";
        service.apiKey="6238017201957511800";
        service.apiProfile="devmno";
        service.apiURL="http://api.eniro.com/cs/search/basic";
        service.apiVersion="1.1.3";

        List<QueryResultDTO> pizza = service.search("pizza");

        for (QueryResultDTO queryResultDTO : pizza) {
            System.out.println(queryResultDTO.toString());
        }

    }
}
