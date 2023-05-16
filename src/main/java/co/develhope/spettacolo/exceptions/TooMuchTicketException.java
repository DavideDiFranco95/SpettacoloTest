package co.develhope.spettacolo.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class TooMuchTicketException extends Exception {
    @Override
    public String getMessage() {
        return "you bought too many Tickets!";
    }
}
