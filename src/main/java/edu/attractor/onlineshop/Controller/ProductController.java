package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/indexP")
    public String getProduct(Model model,@PageableDefault(value = 2) Pageable pageable){
        final Page<Product> placeDtos = this.productService.getProduct(pageable)
                .map(place -> mapper.map(place,Product.class));
        model.addAttribute("place",placeDtos.getContent());
        model.addAttribute("pages",placeDtos.getPageable());
        return "indexP";
    }

    @GetMapping("/filter")
    public String getFilter(Model model, @ModelAttribute("filter") FilterDto filterDto,@PageableDefault(value = 100) Pageable pageable){
        final Page<Product> productPage = this.productService.getProduct(pageable).map(place -> mapper.map(place,Product.class));
            final Set<Product> products = this.productService.getWithFilter(filterDto);
        model.addAttribute("products",productPage.getContent());
        model.addAttribute("products",productPage.getPageable());
            model.addAttribute("products", products.stream().map(p -> mapper.map(p, Product.class)).collect(Collectors.toList()));
        return "filter";
    }
}
