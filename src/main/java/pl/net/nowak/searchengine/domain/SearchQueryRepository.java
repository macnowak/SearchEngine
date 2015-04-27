package pl.net.nowak.searchengine.domain;

import org.springframework.stereotype.Repository;
import pl.net.nowak.core.db.GenericDAOImpl;

/**
 * Author: Maciek
 */

public interface SearchQueryRepository {

    SearchQuery save(SearchQuery entity);

}
