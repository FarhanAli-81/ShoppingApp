package com.tenth.Shopping.Service;

import com.tenth.Shopping.Entity.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {
    public List<Coupon> fetchCoupons();

    void save(Coupon c1);
}
