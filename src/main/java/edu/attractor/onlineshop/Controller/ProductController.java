package edu.attractor.onlineshop.Controller;


import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("products")
    public String getProduct(Model model,@PageableDefault(value = 2) Pageable pageable){
        final Page<Product> placeDtos = this.productService.getProduct(pageable)
                .map(place -> mapper.map(place,Product.class));
        model.addAttribute("products",placeDtos.getContent());
        model.addAttribute("pages",placeDtos.getPageable());
        return "products";
    }

    @GetMapping("/filter")
    public String filter(Model model, @ModelAttribute(name = "filter") FilterDto filter,@PageableDefault(value = 2) Pageable pageable) {
        final Page<Product> products= this.productService.getWithFilter(filter,pageable);
        if(filter.getName()!=null||filter.getMaxPrice()!=null && filter.getMaxPrice()!=null) {
            model.addAttribute("products", products.stream().map(p -> mapper.map(p, Product.class)).distinct().collect(Collectors.toList()));
            model.addAttribute("pages",products.getPageable());
        }
        return "filter";
    }

}
