package edu.attractor.onlineshop.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="name",length = 128)
    private String name;

    @Column(name ="price")
    private int price;
}