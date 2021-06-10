package edu.attractor.onlineshop.Repository;

import edu.attractor.onlineshop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
