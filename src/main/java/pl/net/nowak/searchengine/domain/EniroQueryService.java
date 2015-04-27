package pl.net.nowak.searchengine.domain;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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
    private String apiURL;
    @Value("${api.profile}")
    private String apiProfile;
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.country}")
    private String apiCountry;
    @Value("${api.version}")
    private String apiVersion;

    @Override
    public List<QueryResultDTO> search(String query) {
        log.info("Sending query to : " + createApiURL("aaa"));

        ArrayList<QueryResultDTO> queryResultDTOs = new ArrayList<>();
        queryResultDTOs.add(new QueryResultDTO("a"));
        queryResultDTOs.add(new QueryResultDTO("b"));
        queryResultDTOs.add(new QueryResultDTO("c"));
        queryResultDTOs.add(new QueryResultDTO("d"));

        return queryResultDTOs;
    }


    private String createApiURL(String searchParam) {
        StringBuilder builder = new StringBuilder();
        builder.append(apiURL);
        builder.append("?profile="+apiProfile);
        builder.append("?key="+apiKey);
        builder.append("?country="+apiCountry);
        builder.append("?version="+apiVersion);
        builder.append("?search_word="+searchParam);

        return builder.toString();
    }
}
