package pl.net.nowak.searchengine.domain;

import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.util.List;

/**
 * Created by mno on 2015-04-27.
 */
public interface QueryService {

    List<QueryResultDTO> search(String query);

}
