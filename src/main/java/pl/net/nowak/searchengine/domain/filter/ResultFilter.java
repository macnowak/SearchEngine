package pl.net.nowak.searchengine.domain.filter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.util.Collection;
import java.util.List;

/**
 * Author: Maciek
 */
public interface ResultFilter {

    List<QueryResultDTO> filter(List<QueryResultDTO> collection, final String regex);

}
