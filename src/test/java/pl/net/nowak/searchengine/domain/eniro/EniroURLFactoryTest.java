package pl.net.nowak.searchengine.domain.eniro;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: Maciek
 */
public class EniroURLFactoryTest {

    private EniroURLFactory eniroURLFactory;
    private final String apiCountry="se";
    private final String apiKey="6238017201957511800";
    private final String apiProfile="devmno";
    private final String apiURL="http://api.eniro.com/cs/search/basic";
    private final String apiVersion="1.1.3";

    @Before
    public void setUp() throws Exception {
        eniroURLFactory = new EniroURLFactory(apiURL,apiProfile,apiKey,apiCountry,apiVersion);

    }

    @Test
    public void shouldCreateCorrectURL() {
        //given
        String searchWord = "pizza";
        String expectedURL = "http://api.eniro.com/cs/search/basic?profile="+apiProfile+"&key="+apiKey+"&country="+apiCountry+"&version="+apiVersion+"&search_word="+searchWord;

        //when
        String url = eniroURLFactory.getURL(searchWord);

        //then
        Assertions.assertThat(url).isNotNull().isEqualTo(expectedURL);


    }
}
