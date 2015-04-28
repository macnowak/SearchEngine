package pl.net.nowak.core;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 * Author: Maciek
 */
public class RestApi {

    public ResponseEntity success(Object data) {
        return new ResponseEntity<>(ResponseDTO.ok(data), OK);
    }

    public ResponseEntity error(String msg) {
        return new ResponseEntity<>(ResponseDTO.error(msg), INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity error(Throwable e) {
        return new ResponseEntity<>(ResponseDTO.error(e.getMessage()), INTERNAL_SERVER_ERROR);
    }

}
