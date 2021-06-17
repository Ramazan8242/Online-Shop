package edu.attractor.onlineshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("title", "Главная страница");
        return "main";
    }
}
