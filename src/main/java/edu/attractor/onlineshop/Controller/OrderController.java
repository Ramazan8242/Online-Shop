package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
}
