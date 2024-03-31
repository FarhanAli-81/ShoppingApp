package com.tenth.Shopping.Error;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorTransactionMessage {
    private int userId;
    private int orderId;
    private String transactionId;
    private String status;
    private String description;
}
