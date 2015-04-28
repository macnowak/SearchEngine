package pl.net.nowak.searchengine.domain.eniro;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.net.nowak.core.ApiException;

import javax.inject.Inject;
import java.util.concurrent.Callable;

/**
 * Author: Maciek
 * Klient serwisu Eniro
 *
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
        log.debug("Response : " + rsp.getStatusCode());
        return rsp;
    }
}
