package com.tenth.Shopping.Error;

public class InvalidCoupon extends  Exception{

    public InvalidCoupon() {
        super();
    }

    public InvalidCoupon(String message) {
        super(message);
    }

    public InvalidCoupon(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCoupon(Throwable cause) {
        super(cause);
    }

    protected InvalidCoupon(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
