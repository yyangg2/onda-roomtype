package onda.onda_yang.domain.hotel.exception;


import onda.onda_yang.global.exception.ApplicationException;
import onda.onda_yang.global.exception.ErrorCode;


/**
 * status -> 404
 */
public class HotelNotFound extends ApplicationException {

    public HotelNotFound(ErrorCode errorCode) { super(errorCode); }
}
