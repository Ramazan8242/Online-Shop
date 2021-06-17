package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Data
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Set<Product> getWithFilter(FilterDto filterDto){
        Set<Product> products = new HashSet<>();
        if (filterDto.getName()!=null){
            products.addAll(this.productRepository.findAllByNameIsContaining(filterDto.getName()));
        }

        BigDecimal minRange = BigDecimal.ZERO;
        if (filterDto.getMinPrice()!=null){
            minRange = filterDto.getMinPrice();
            products.addAll(this.productRepository.findAllByPriceBetween(minRange,filterDto.getMinPrice()));
        }

        BigDecimal maxRange = BigDecimal.valueOf(Long.MAX_VALUE);
        if (filterDto.getMaxPrice()!=null){
            minRange = filterDto.getMinPrice();
            products.addAll(this.productRepository.findAllByPriceBetween(minRange,filterDto.getMaxPrice()));
        }

        return products;
    }
}
