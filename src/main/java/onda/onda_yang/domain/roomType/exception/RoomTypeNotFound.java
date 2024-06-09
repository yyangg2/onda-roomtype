package onda.onda_yang.domain.roomType.exception;


import onda.onda_yang.global.exception.ApplicationException;
import onda.onda_yang.global.exception.ErrorCode;


/**
 * status -> 404
 */
public class RoomTypeNotFound extends ApplicationException {
    public RoomTypeNotFound(ErrorCode errorCode) {
        super(errorCode);
    }
}
