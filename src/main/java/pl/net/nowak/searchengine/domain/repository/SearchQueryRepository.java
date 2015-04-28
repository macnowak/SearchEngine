package pl.net.nowak.searchengine.domain.repository;

import pl.net.nowak.searchengine.domain.SearchQuery;

/**
 * Author: Maciek
 *
 */
public interface SearchQueryRepository {

    SearchQuery save(SearchQuery entity);

}
