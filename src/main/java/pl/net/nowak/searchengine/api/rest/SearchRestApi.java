package pl.net.nowak.searchengine.api.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.net.nowak.core.annotations.RestAPI;
import pl.net.nowak.searchengine.api.QueryFinder;
import pl.net.nowak.searchengine.api.SearchEngineAPI;

import javax.inject.Inject;

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

    @RequestMapping("/queries")
    public void getAllQueries() {
        queryFinder.getAllQueries();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void search() {
        api.performQuery("","");
    }




}
