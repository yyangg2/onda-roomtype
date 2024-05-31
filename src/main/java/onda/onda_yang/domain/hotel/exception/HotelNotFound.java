package onda.onda_yang.domain.hotel.exception;


import onda.onda_yang.global.exception.OndaException;

/**
 * status -> 404
 */
public class HotelNotFound extends OndaException {

    private static final String MESSAGE = "존재하지 않는 호텔입니다.";

    public HotelNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
