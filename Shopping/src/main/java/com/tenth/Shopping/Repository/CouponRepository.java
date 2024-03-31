package com.tenth.Shopping.Repository;

import com.tenth.Shopping.Entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
