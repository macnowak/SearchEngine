package pl.net.nowak.searchengine.domain;

import org.springframework.stereotype.Repository;
import pl.net.nowak.core.db.GenericDAOImpl;

/**
 * Author: Maciek
 */
@Repository
public class SearchQueryRepositoryImpl extends GenericDAOImpl<SearchQuery,Long> implements SearchQueryRepository {

}
