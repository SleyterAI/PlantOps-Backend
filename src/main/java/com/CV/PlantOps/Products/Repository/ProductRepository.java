package com.CV.PlantOps.Products.Repository;

import com.CV.PlantOps.Products.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
