package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Dto.FeedbackDto;
import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Entity.Feedback;
import edu.attractor.onlineshop.Entity.Order;
import edu.attractor.onlineshop.Repository.OrderRepository;
import edu.attractor.onlineshop.Service.ClientService;
import edu.attractor.onlineshop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private final ClientService clientService;
    private final OrderRepository orderRepository;

    public OrderController(ClientService clientService, OrderRepository orderRepository) {
        this.clientService = clientService;
        this.orderRepository = orderRepository;
    }


    @PostMapping("/addFeedback")
    public String addReview(@ModelAttribute(name = "feedback") FeedbackDto feedbackDto, Principal principal){
        Client client = clientService.getByEmail(principal.getName());
        Order order = orderService.getById(feedbackDto.getOrderFor());
        Feedback feedback1 = new Feedback(feedbackDto.getOrderFor(), client, order, feedbackDto.getLocalDateTime(), feedbackDto.getReviewContent());
        order.getFeedback().add(feedback1);
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping
    public String getAllOrders(@PageableDefault(value = 2) Pageable pageable, Model model){
        Page<Order> allOrders= orderService.getAllOrders(pageable);
        model.addAttribute("orders",allOrders.getContent());
        model.addAttribute("pages",allOrders.getPageable());
        return "orders";
    }
}
