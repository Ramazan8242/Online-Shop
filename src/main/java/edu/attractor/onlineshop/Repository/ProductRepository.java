package edu.attractor.onlineshop.Repository;

import edu.attractor.onlineshop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByNameIsContaining (String name);
}
