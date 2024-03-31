package com.tenth.Shopping.Error;

public class OrderIdNotFoundException extends Exception{

    public OrderIdNotFoundException() {
        super();
    }

    public OrderIdNotFoundException(String message) {
        super(message);
    }

    public OrderIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderIdNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OrderIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
