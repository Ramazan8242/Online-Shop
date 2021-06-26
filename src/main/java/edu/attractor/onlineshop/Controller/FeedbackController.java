package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Service.FeedbackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class FeedbackController {
    @Autowired
    private final FeedbackService feedbackService;
}
