package pl.net.nowak.searchengine.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by mno on 2015-04-27.
 */
@NoArgsConstructor
@Getter
@Setter
public class SearchQueryDTO {

    private long id;
    private String query;
    private String filter;


}
