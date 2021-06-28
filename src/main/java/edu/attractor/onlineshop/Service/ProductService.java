package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.Dto.FilterDto;
import edu.attractor.onlineshop.Entity.Product;
import edu.attractor.onlineshop.Repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Data
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getWithFilter(FilterDto filterDto , Pageable pageable){
        Page<Product> products = null;
        if (filterDto.getName()!=null){
            products= this.productRepository.findAllByNameIsContaining(filterDto.getName(),pageable);
        }

        BigDecimal minRange = BigDecimal.ZERO;
        BigDecimal maxRange = BigDecimal.valueOf(Long.MAX_VALUE);
        if (filterDto.getMinPrice()!=null){
            minRange = filterDto.getMinPrice();
            products=  this.productRepository.findAllByPriceBetween(pageable,minRange,maxRange);
        }

        if (filterDto.getMaxPrice()!=null){
            minRange = filterDto.getMinPrice();
            products= this.productRepository.findAllByPriceBetween(pageable,minRange,maxRange);
        }

        return  products;
    }

    public Page<Product> getProduct(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

}
