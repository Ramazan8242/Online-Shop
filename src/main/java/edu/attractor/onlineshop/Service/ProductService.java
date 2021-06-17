package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class ProductService {
    private ProductRepository productRepository;

    public Collection<Product> getWithFilter(FilterDto filterDto){
        Set<Product> products = new HashSet();
        if (filterDto.getName()!=null){
            products.addAll(this.productRepository.findAllByNameIsContaining(filterDto.getName()));
        }

        if (filterDto.getPrice()!=null){
            products.addAll(this.productRepository.findAllByNameIsContaining(filterDto.getName()));
        }
        return products;
    }
}
