package pl.net.nowak.searchengine.api;

import org.apache.log4j.Logger;
import pl.net.nowak.core.ApiException;
import pl.net.nowak.core.annotations.API;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.api.dto.SearchQueryDTO;
import pl.net.nowak.searchengine.domain.QueryService;
import pl.net.nowak.searchengine.domain.SearchQuery;
import pl.net.nowak.searchengine.domain.repository.SearchQueryRepository;
import pl.net.nowak.searchengine.domain.filter.ResultFilter;

import javax.inject.Inject;
import java.util.List;

/**
 * Author: Maciek
 * API do modułu wyszukiwania
 */
@API
public class SearchEngineAPI {

    @Inject QueryService queryService;
    @Inject SearchQueryRepository searchQueryRepository;
    @Inject ResultFilter resultFilter;
    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    public List<QueryResultDTO> performQuery(SearchQueryDTO dto) throws ApiException {
        try {
            //store query
            searchQueryRepository.save(SearchQuery.valueOf(dto.getParams(),dto.getFilter()));
            //query
            List<QueryResultDTO> results = queryService.search(dto.getSearchWords());
            //apply filter
            return resultFilter.filter(results,dto.getFilter());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new ApiException(e.getMessage(),e);
        }
    }

}
