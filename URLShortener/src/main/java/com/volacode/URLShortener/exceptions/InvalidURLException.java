package com.volacode.URLShortener.exceptions;

public class InvalidURLException extends RuntimeException {
    public  InvalidURLException(){
        super();
    }
    public InvalidURLException(String message) {
        super(message);
    }
}
