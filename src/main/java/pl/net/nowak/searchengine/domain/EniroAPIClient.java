package pl.net.nowak.searchengine.domain;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.net.nowak.core.ApiException;

import javax.inject.Inject;
import java.util.concurrent.Callable;

/**
 * Created by mno on 2015-04-27.
 *
 * URL eniroApiUrl = new URL("http://api.eniro.com/cs/search/basic?profile=[profile]&key=[key]&country=se&version=1.1.3&search_word=pizza");
 */
public class EniroAPIClient implements Callable<ResponseEntity<String>> {

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());
    private final String url;

    public EniroAPIClient(String url) {
        this.url = url;
    }

    @Override
    public ResponseEntity<String> call() {
        log.info("Calling " + url );
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> rsp = restTemplate.getForEntity(url, String.class);
        log.info("Response : " + rsp.getStatusCode());
        return rsp;
    }
}
