package edu.attractor.onlineshop.Repository;

import edu.attractor.onlineshop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
