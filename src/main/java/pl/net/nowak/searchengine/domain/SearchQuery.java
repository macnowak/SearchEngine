package pl.net.nowak.searchengine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mno on 2015-04-27.
 */
@Entity
public class SearchQuery {

    @Id
    @GeneratedValue
    private long id;
    private String query;
    private String filter;

}
