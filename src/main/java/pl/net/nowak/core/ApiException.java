package pl.net.nowak.core;

import java.text.MessageFormat;

/**
 * Created by mno on 2015-04-28.
 */
public class ApiException extends Exception {

    public static final String API_CALL_EXCEPTION = "Wystąpił błąd podczas odpytywania api, kod : {0} , {1} ";
    public static final String API_RESPONSE_PARSE_EXCEPTION = "Wystąpił błąd podczas parsowania odpowiedzi api : {0} ";

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, String... parms) {
        super(MessageFormat.format(message,parms));
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
