package pl.net.nowak.searchengine.domain;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mno on 2015-04-28.
 */
@Component
public class QueryResultFactory {

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    public List<QueryResultDTO> parseJSON(String json) throws IOException {
        List<QueryResultDTO> results = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(mapper.getJsonFactory().createJsonParser(json));

        Iterator<JsonNode> adverts = jsonNode.path("adverts").getElements();

        while(adverts.hasNext()) {
            JsonNode advert = adverts.next();
            results.add(new QueryResultDTO(advert.get("companyInfo").get("companyName").asText(), advert.get("companyInfo").get("companyText").asText(), advert.toString()));
        }

        return results;
    }

}
