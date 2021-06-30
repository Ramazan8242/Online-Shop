package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Data
public class BasketController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/basket")
    public String basket(Model model, @SessionAttribute(name = Constants.BASKET_ID, required = false)List<Product> productList){
        if (productList != null){
            model.addAttribute("basketItems" , productList);
        }
        return "basket";
    }

    @PostMapping("/basket/add")
    public String addToList(@RequestParam Integer id, HttpSession session) {
        if (session != null) {
            var attr = session.getAttribute(Constants.BASKET_ID);
            if (attr == null) {
                session.setAttribute(Constants.BASKET_ID, new ArrayList<String>());
            }
            try {
                var list = (List<Product>) session.getAttribute(Constants.BASKET_ID);
                list.add(productRepository.findById(id).get());
            } catch (ClassCastException ignored) {

            }
        }

        return "redirect:/";
    }

    @PostMapping("/basket/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.BASKET_ID);
        return "redirect:/basket";
    }
}