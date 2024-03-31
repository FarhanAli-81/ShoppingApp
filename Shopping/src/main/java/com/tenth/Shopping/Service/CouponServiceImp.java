package com.tenth.Shopping.Service;

import com.tenth.Shopping.Entity.Coupon;
import com.tenth.Shopping.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImp implements CouponService{

    @Autowired
    private CouponRepository couponRepository;


    @Override
    public List<Coupon> fetchCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public void save(Coupon c1) {
        couponRepository.save(c1);
    }

}
