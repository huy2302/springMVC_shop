package com.huydevtr.demo.services.ServiceImpl;

import com.huydevtr.demo.models.entities.Discount;
import com.huydevtr.demo.repositories.DiscountRepository;
import com.huydevtr.demo.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    DiscountRepository discountRepository;
    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Discount getDiscountByDiscountId(int discountId) {
        return discountRepository.findDiscountByProductProductId(discountId);
    }
}
