package pl.net.nowak.searchengine.domain.filter;

import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.util.List;

/**
 * Author: Maciek
 */
public interface ResultFilter {

    List<QueryResultDTO> filter(List<QueryResultDTO> collection, final String regex);

}
