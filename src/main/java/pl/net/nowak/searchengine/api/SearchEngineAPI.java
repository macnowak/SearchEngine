package pl.net.nowak.searchengine.api;

import pl.net.nowak.core.ApiException;
import pl.net.nowak.core.annotations.API;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.api.dto.SearchQueryDTO;
import pl.net.nowak.searchengine.domain.QueryService;
import pl.net.nowak.searchengine.domain.SearchQuery;
import pl.net.nowak.searchengine.domain.SearchQueryRepository;
import pl.net.nowak.searchengine.domain.filter.ResultFilter;

import javax.inject.Inject;
import java.util.List;

/**
 * Author: Maciek
 */
@API
public class SearchEngineAPI {

    @Inject QueryService queryService;
    @Inject SearchQueryRepository searchQueryRepository;
    @Inject ResultFilter resultFilter;

    public List<QueryResultDTO> performQuery(SearchQueryDTO dto) throws ApiException {
        try {
            //store query
            searchQueryRepository.save(SearchQuery.valueOf(dto.getParams(),dto.getFilter()));
            //query
            return resultFilter.filter(queryService.search(dto.getSearchWords()),dto.getFilter());
        } catch (InterruptedException e) {
            throw new ApiException(ApiException.API_CALL_EXCEPTION,e.getMessage());
        }
    }

}
