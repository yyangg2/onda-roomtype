package onda.onda_yang.domain.roomType.exception;


import onda.onda_yang.global.exception.OndaException;

/**
 * status -> 404
 */
public class RoomTypeNotFound extends OndaException {
    private static final String MESSAGE = "존재하지 않는 객실타입입니다.";

    public RoomTypeNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
