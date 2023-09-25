package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    public Discount findDiscountByProductProductId(int discountId);

}
