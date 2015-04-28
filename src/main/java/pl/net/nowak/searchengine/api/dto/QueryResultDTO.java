package pl.net.nowak.searchengine.api.dto;

import com.google.common.base.Strings;
import lombok.*;

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
        this.companyText = Strings.nullToEmpty(companyText);
        this.fullJsonInfo = fullJsonInfo;
    }

}
