package edu.attractor.onlineshop.Repository;

import edu.attractor.onlineshop.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameIsContaining(String name, Pageable pageable);
    Page<Product> findAllByPriceBetween(Pageable pageable,BigDecimal minPrice, BigDecimal maxPrice);
}
