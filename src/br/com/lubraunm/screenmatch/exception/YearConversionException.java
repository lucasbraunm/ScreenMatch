package br.com.lubraunm.screenmatch.exception;

public class YearConversionException extends RuntimeException {
    private String message;

    public YearConversionException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
