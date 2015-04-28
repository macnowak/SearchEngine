package pl.net.nowak.searchengine.api.dto;

import com.google.common.base.Strings;
import lombok.*;

import static com.google.common.base.Strings.nullToEmpty;

/**
 * Author: Maciek
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QueryResultDTO {
    private String companyName;
    private String companyText;
    private String fullJsonInfo;


    public QueryResultDTO(String companyName, String companyText, String fullJsonInfo) {
        this.companyName = companyName;
        this.companyText = escapeNulls(companyText);
        this.fullJsonInfo = fullJsonInfo;
    }

    private String escapeNulls(String value) {
        String val = nullToEmpty(value);
        if("null".equals(val)) return "";
        else return val;
    }

}
