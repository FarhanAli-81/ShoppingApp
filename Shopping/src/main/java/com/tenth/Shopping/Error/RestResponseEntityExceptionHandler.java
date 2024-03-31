package com.tenth.Shopping.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    // order id not found exception
    @ExceptionHandler(OrderIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleOrderIdNotFoundException(OrderIdNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage("orderId", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    // invalid quantity exception handling
    @ExceptionHandler(InvalidQuantity.class)
    public ResponseEntity<ErrorMessageQuantity> invalidQuantityException(InvalidQuantity ex, WebRequest request) {
        ErrorMessageQuantity message = new ErrorMessageQuantity(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }


    // invalid coupon exception handling
    @ExceptionHandler(InvalidCoupon.class)
    public ResponseEntity<ErrorMessageQuantity>invalidCouponException(InvalidCoupon ex, WebRequest request){
        ErrorMessageQuantity message=new ErrorMessageQuantity(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }


    // transaction failed exception
    @ExceptionHandler(TransactionFailedException.class)
    public ResponseEntity<ErrorTransactionMessage> transactionMessageResponseEntity(TransactionFailedException exception, WebRequest request){

        ErrorTransactionMessage etm=ErrorTransactionMessage.builder().transactionId(exception.getTransactionId()).status(exception.getStatus())
                .orderId(exception.getMockOrderId())
                .description(exception.getMesssage())
                .userId(exception.getUserId()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(etm);

    }

}
