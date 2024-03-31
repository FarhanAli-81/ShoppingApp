package com.tenth.Shopping.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Coupon {
    @Id
    private int percentage;
    private String discount;
}
