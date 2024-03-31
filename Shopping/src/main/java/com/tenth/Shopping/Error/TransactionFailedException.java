package com.tenth.Shopping.Error;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionFailedException extends Exception{
    private String messsage;
    private int mockOrderId;
    private LocalDate date;
    private int amount;
    private String status;
    private int userId;
    private String coupon;
    private String transactionId;


    public TransactionFailedException(String s, int mockOrderId, LocalDate now, int amount, String failed, String coupon, String tran010100006, int userId) {
        this.amount=amount;
        this.date=now;
        this.userId=userId;
        this.messsage=s;
        this.transactionId=tran010100006;
        this.status=failed;
        this.coupon=coupon;
        this.mockOrderId=mockOrderId;
    }
    public TransactionFailedException() {
        super();
    }

    public TransactionFailedException(String message) {
        super(message);
    }

    public TransactionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionFailedException(Throwable cause) {
        super(cause);
    }

    protected TransactionFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }





}
