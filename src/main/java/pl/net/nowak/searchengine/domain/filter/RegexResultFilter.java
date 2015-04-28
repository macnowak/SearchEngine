package pl.net.nowak.searchengine.domain.filter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.assertj.core.util.Strings;
import org.springframework.stereotype.Component;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Author: Maciek
 */
@Component
public class RegexResultFilter implements ResultFilter {

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    public List<QueryResultDTO> filter(List<QueryResultDTO> collection, final String regex) {

        if(Strings.isNullOrEmpty(regex)) return collection;
        if(collection == null ) return new ArrayList<>();

        Predicate<QueryResultDTO> matchesWithRegex = new Predicate<QueryResultDTO>() {
            @Override
            public boolean apply(QueryResultDTO str) {
                return str.getCompanyName().matches(regex);
            }
        };

        Iterable<QueryResultDTO> iterable = Iterables.filter(collection, matchesWithRegex);

        return Lists.newArrayList(iterable);

    }

}
