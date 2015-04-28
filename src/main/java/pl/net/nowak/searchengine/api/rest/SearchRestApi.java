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
import pl.net.nowak.core.annotations.RestAPI;
import pl.net.nowak.searchengine.api.QueryFinder;
import pl.net.nowak.searchengine.api.SearchEngineAPI;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.api.dto.SearchQueryDTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by mno on 2015-04-27.
 */
@RestAPI
@RequestMapping("/search")
public class SearchRestApi {

    @Inject
    QueryFinder queryFinder;

    @Inject
    SearchEngineAPI api;

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public @ResponseBody ResponseDTO getAllQueries() {
        return ResponseDTO.ok(queryFinder.getAllQueries());
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ResponseDTO> search(@RequestBody SearchQueryDTO queryDTO) {
        try {
            return new ResponseEntity<>(ResponseDTO.ok(api.performQuery(queryDTO)), HttpStatus.OK);
        } catch (ApiException e) {
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(ResponseDTO.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
