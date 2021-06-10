package edu.attractor.onlineshop.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 128)
    private String name;
    @Column(length = 128)
    private int price;
}
