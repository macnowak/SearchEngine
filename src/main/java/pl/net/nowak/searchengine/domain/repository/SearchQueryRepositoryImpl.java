package pl.net.nowak.searchengine.domain.repository;

import org.springframework.stereotype.Repository;
import pl.net.nowak.core.db.GenericDAOImpl;
import pl.net.nowak.searchengine.domain.SearchQuery;

/**
 * Author: Maciek
 */
@Repository
public class SearchQueryRepositoryImpl extends GenericDAOImpl<SearchQuery,Long> implements SearchQueryRepository {

}
