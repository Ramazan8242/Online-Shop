package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Entity.Feedback;
import edu.attractor.onlineshop.Entity.Order;
import edu.attractor.onlineshop.Repository.OrderRepository;
import edu.attractor.onlineshop.Service.ClientService;
import edu.attractor.onlineshop.Service.FeedbackService;
import edu.attractor.onlineshop.Service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@Data
public class FeedbackController {
    @Autowired
    private final FeedbackService feedbackService;
    private final ClientService clientService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @PostMapping("/addFeedback")
    public String addReview(@ModelAttribute(name = "feedback") Feedback feedback, Principal principal){
        Client client = clientService.getByEmail(principal.getName());
        Order order = orderService.getById(feedback.getId());
        Feedback feedback1 = new Feedback(order,feedback.getDate(),client,feedback.getProduct(),feedback.getText());
        order.getFeedback().add(feedback1);
        orderRepository.save(order);
        return "redirect:/feedback";
    }
}