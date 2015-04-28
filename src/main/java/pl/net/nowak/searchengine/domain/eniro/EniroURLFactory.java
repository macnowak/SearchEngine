package pl.net.nowak.searchengine.domain.eniro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * Author: Maciek
 * Fabryka wytwarzająca url do serwisu eniro na podstawie properiesow
 */
@Component
public class EniroURLFactory {

    @Value("${api.url}") private String apiURL;
    @Value("${api.profile}") private String apiProfile;
    @Value("${api.key}") private String apiKey;
    @Value("${api.country}") private String apiCountry;
    @Value("${api.version}") private String apiVersion;


    public EniroURLFactory(String apiURL, String apiProfile, String apiKey, String apiCountry, String apiVersion) {
        this.apiURL = apiURL;
        this.apiProfile = apiProfile;
        this.apiKey = apiKey;
        this.apiCountry = apiCountry;
        this.apiVersion = apiVersion;
    }

    public EniroURLFactory() {
    }

    public String getURL(String searchWord) {
        StringBuilder builder = new StringBuilder();
        builder.append(apiURL);
        builder.append("?profile="+apiProfile);
        builder.append("&key="+apiKey);
        builder.append("&country="+apiCountry);
        builder.append("&version="+apiVersion);
        builder.append("&search_word="+searchWord);

        return builder.toString();
    }

}
