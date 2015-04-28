package pl.net.nowak.searchengine.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Maciek
 */
@NoArgsConstructor
@Getter
@Setter
public class SearchQueryDTO {

    private long id;
    private String params;
    private String filter;



    public String[] getSearchWords() {
        if(this.params != null ) {
            return this.params.split(",");
        }else {
            return new String[]{};
        }
    }

}
