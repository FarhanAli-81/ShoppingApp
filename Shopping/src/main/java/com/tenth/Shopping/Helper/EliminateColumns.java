package com.tenth.Shopping.Helper;

import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EliminateColumns {
    private int orderId;
    private int amount;
    private LocalDate date;
    private String coupon;
}
