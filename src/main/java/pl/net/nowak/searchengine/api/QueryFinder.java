package pl.net.nowak.searchengine.api;

import pl.net.nowak.core.annotations.Finder;
import pl.net.nowak.core.db.BaseFinder;
import pl.net.nowak.searchengine.api.dto.SearchQueryDTO;
import pl.net.nowak.searchengine.domain.SearchQuery;

import java.util.List;

/**
 * Created by mno on 2015-04-27.
 */
@Finder
public class QueryFinder extends BaseFinder {

    public List<SearchQueryDTO> getAllQueries() {
        return getBaseCriteria(SearchQuery.class).list();
    }

}
