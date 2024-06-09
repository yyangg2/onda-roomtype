package onda.onda_yang.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class OndaException extends RuntimeException {
    public final Map<String, String> validation = new HashMap<>();

    public OndaException(String message) {
        super(message);
    }

    public OndaException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }
}

//
//// HOTEL
//INVALID_HOTEL_EXCEPTION(HttpStatus.BAD_REQUEST, "존재하지 않는 호텔입니다.,"),
//
//// ROOMTYPE
//INVALID_ROOMTYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "존재하지 않는 객실타입입니다.")