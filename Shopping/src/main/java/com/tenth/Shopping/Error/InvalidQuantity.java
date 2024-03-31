package com.tenth.Shopping.Error;

public class InvalidQuantity extends Exception{

    public InvalidQuantity() {
        super();

    }

    public InvalidQuantity(String message) {
        super(message);
    }

    public InvalidQuantity(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidQuantity(Throwable cause) {
        super(cause);
    }

    protected InvalidQuantity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
