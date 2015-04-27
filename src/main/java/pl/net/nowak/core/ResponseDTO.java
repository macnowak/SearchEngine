package pl.net.nowak.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author: Maciek
 */
@Getter
@AllArgsConstructor
public class ResponseDTO {

    private Object data;
    private boolean error;
    private String errorMsg;

    public static ResponseDTO ok(Object data) {
        return new ResponseDTO(data,false,"");
    }

    public static ResponseDTO error(String errorMsg) {
        return new ResponseDTO("",true,errorMsg);
    }

}
