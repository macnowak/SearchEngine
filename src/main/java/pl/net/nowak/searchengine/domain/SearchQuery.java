package pl.net.nowak.searchengine.domain;

import lombok.Getter;
import lombok.Setter;
import pl.net.nowak.core.db.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mno on 2015-04-27.
 */
@Entity
@Getter
@Setter
public class SearchQuery extends BaseEntity {

    private String query;
    private String filter;


    public static SearchQuery valueOf(String query, String filter) {
        return new SearchQuery(query,filter);
    }

    public SearchQuery(){}

    private SearchQuery(String query, String filter) {
        this.query = query;
        this.filter = filter;
    }



}
