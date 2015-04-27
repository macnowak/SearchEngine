package pl.net.nowak.searchengine.api;

import pl.net.nowak.core.annotations.API;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.api.dto.SearchQueryDTO;
import pl.net.nowak.searchengine.domain.QueryService;
import pl.net.nowak.searchengine.domain.SearchQuery;
import pl.net.nowak.searchengine.domain.SearchQueryRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by mno on 2015-04-27.
 */
@API
public class SearchEngineAPI {

    @Inject
    QueryService queryService;

    @Inject
    SearchQueryRepository searchQueryRepository;

    public List<QueryResultDTO> performQuery(SearchQueryDTO dto) {
        //store query
        searchQueryRepository.save(SearchQuery.valueOf(dto.getParams(),dto.getFilter()));

        //query
        return queryService.search(dto.getParams());
    }

}
