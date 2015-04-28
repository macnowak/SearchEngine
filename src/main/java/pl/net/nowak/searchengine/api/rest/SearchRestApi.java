package pl.net.nowak.searchengine.api.rest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.net.nowak.core.ApiException;
import pl.net.nowak.core.ResponseDTO;
import pl.net.nowak.core.RestApi;
import pl.net.nowak.core.annotations.RestAPI;
import pl.net.nowak.searchengine.api.QueryFinder;
import pl.net.nowak.searchengine.api.SearchEngineAPI;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.api.dto.SearchQueryDTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Author: Maciek
 */
@RestAPI
@RequestMapping("/search")
public class SearchRestApi extends RestApi {

    @Inject QueryFinder queryFinder;
    @Inject SearchEngineAPI api;

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    /**
     * Pobiera historyczne zapytania
     * @return
     */
    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ResponseDTO> getAllQueries() {
        try {
            return success(queryFinder.getAllQueries());
        }catch (Exception e) {
            log.error(e.getMessage(),e);
            return error(e);
        }
    }

    /**
     * Wykonuje nowe zapytanie
     * @param queryDTO dto z parametrami zapytania oraz filtrem
     * @return kolekcja przefiltrowanych danych, jeżeli wystąpi błąd zwraca http 500
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ResponseDTO> search(@RequestBody SearchQueryDTO queryDTO) {
        try {
            return success(api.performQuery(queryDTO));
        } catch (ApiException e) {
            log.error(e.getMessage(),e);
            return error(e);
        }
    }




}
