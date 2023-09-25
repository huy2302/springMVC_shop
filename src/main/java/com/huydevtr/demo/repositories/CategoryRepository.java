package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
