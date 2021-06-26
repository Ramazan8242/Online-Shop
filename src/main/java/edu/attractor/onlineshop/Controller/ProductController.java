package edu.attractor.onlineshop.Controller;


import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    private final ModelMapper mapper = new ModelMapper();

//    @GetMapping("/indexP")
//    public String getProduct(Model model,@PageableDefault(value = 2) Pageable pageable){
//        final Page<Product> placeDtos = this.productService.getProduct(pageable)
//                .map(place -> mapper.map(place,Product.class));
//        model.addAttribute("place",placeDtos.getContent());
//        model.addAttribute("pages",placeDtos.getPageable());
//        return "indexP";
//    }

    @GetMapping("/filter")
    public String filter(Model model, @ModelAttribute(name = "filter") FilterDto filter, Pageable pageable) {
        final Page<Product> products= this.productService.getWithFilter(filter,pageable);
        if(filter.getName()!=null||filter.getMaxPrice()!=null && filter.getMaxPrice()!=null) {
            model.addAttribute("products", products.stream()
                    .map(p -> mapper.map(p, Product.class))
                    .distinct()
                    .collect(Collectors.toList()));
            model.addAttribute("pages",products.getPageable());
        }
        return "filter";
    }

    @GetMapping("/cart")
    public String cart(Model model, @SessionAttribute(name = Constants.CART_ID, required = false) List<String> cart) {
        if (cart != null) {
            model.addAttribute("cartItems", cart);
        }
        return "cart";
    }

    // это метод для асинхронных запросов
    // демонстрация добавления в "корзину" через параметр @SessionAttribute cart_model
    @PostMapping("/cart")
    @ResponseBody
    public boolean addToListRest(@RequestParam String value, @SessionAttribute(name = Constants.CART_ID, required = false) List<String> cart) {
        if (cart != null) {
            cart.add(value);
        }

        return true;
    }

    // метод для добавления в "корзину" через форму
    // демонстрация добавления через объект HttpSession session
    @PostMapping("/cart/add")
    public String addToList(@RequestParam String value, HttpSession session) {
        if (session != null) {
            var attr = session.getAttribute(Constants.CART_ID);
            if (attr == null) {
                session.setAttribute(Constants.CART_ID, new ArrayList<String>());
            }
            try {
                var list = (List<String>) session.getAttribute(Constants.CART_ID);
                list.add(value);
            } catch (ClassCastException ignored) {

            }
        }

        return "redirect:/";
    }

    // в идеале это должно быть @DeleteMapping, но web-формы не поддерживают
    // запросы с методами отличными от get и post
    // по этому у нас адрес метода немного "странный" :)
    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.CART_ID);

        return "redirect:/cart";
    }
}
