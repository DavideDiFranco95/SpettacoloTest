package co.develhope.spettacolo.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class SeatBookedYetException extends Exception {
    @Override
    public String getMessage() {
        return "this seat is booked!";
    }
}
