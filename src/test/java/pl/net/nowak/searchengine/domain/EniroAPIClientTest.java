package pl.net.nowak.searchengine.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.net.nowak.searchengine.domain.eniro.EniroAPIClient;

/**
 * Author: Maciek
 */
public class EniroAPIClientTest {


    @Test
    public void shouldCallRestApi()  {
        //given

        String url = "http://api.eniro.com/cs/search/basic?profile=devmno&key=6238017201957511800&country=se&version=1.1.3&search_word=pizza";
        EniroAPIClient service = new EniroAPIClient(url);
        //when
        ResponseEntity<String> pizza = service.call();

        //then
        Assertions.assertThat(pizza).isNotNull();
        Assertions.assertThat(pizza.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
