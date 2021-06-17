package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/filter")
    public String getFilter(ModelMap model, @ModelAttribute("filter") FilterDto filterDto){
        final Collection<Product> products = this.productService.getWithFilter(filterDto);
        model.addAttribute("products", (products).stream().map(p->mapper.map(p, Product.class)).collect(Collectors.toList()));
        return "filter";
    }
}
