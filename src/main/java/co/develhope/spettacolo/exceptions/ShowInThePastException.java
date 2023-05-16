package co.develhope.spettacolo.exceptions;

public class ShowInThePastException extends Exception{
    @Override
    public String getMessage() {
        return "Show doesn't exist";
    }
}
