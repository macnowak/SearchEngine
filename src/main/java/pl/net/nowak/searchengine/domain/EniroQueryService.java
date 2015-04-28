package pl.net.nowak.searchengine.domain;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mno on 2015-04-27.
 *
 * URL eniroApiUrl = new URL("http://api.eniro.com/cs/search/basic?profile=[profile]&key=[key]&country=se" +
 "&version=1.1.3&search_word=pizza");
 */
@Component
public class EniroQueryService implements QueryService{

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    @Value("${api.url}")
    String apiURL;
    @Value("${api.profile}")
    String apiProfile;
    @Value("${api.key}")
    String apiKey;
    @Value("${api.country}")
    String apiCountry;
    @Value("${api.version}")
    String apiVersion;




    @Override
    public List<QueryResultDTO> search(String query) {
        String url = createApiURL(query);
        log.info("Sending query to : " + url);

        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getgetForObject(, String.class);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(""), String.class);

        log.info(result.getStatusCode());
        log.info(result.getBody());

        return new ArrayList<>();
    }


    private String createApiURL(String searchParam) {
        StringBuilder builder = new StringBuilder();
        builder.append(apiURL);
        builder.append("?profile="+apiProfile);
        builder.append("?key="+apiKey);
        builder.append("?country="+apiCountry);
        builder.append("?version="+apiVersion);
        builder.append("?search_word="+searchParam);

        //http://api.eniro.com/cs/search/basic?profile=devmno?key=6238017201957511800?country=se?version=1.1.3?search_word=pizza

        return builder.toString();
    }
}
