package pl.net.nowak.searchengine.api.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Maciek
 */
public class QueryResultDTOAssembler {

    public static List<QueryResultDTO> results(String... result) {
        ArrayList<QueryResultDTO> list = new ArrayList<>();
        for (String s : result) {
            list.add(new QueryResultDTO(s));
        }

        return list;
    }

}
