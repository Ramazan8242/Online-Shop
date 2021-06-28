package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.Entity.Order;
import edu.attractor.onlineshop.Exeption.NotFoundException;
import edu.attractor.onlineshop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    public Order getById(int orderFor) {
        return orderRepository.findById(orderFor).orElseThrow(NotFoundException::new);
    }
}
