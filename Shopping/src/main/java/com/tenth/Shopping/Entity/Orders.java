package com.tenth.Shopping.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
    @Id
    private String transactionId;
    private int orderId;
    private int amount;
    private LocalDate date;
    private String coupon;
    private String status;
}
