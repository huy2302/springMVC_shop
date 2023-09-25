package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.Discount;

import java.util.List;

public interface DiscountService {
    Discount getDiscountByDiscountId(int discountId);
}
