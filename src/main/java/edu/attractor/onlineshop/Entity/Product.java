package edu.attractor.onlineshop.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 3,max = 90)
    @Column(name ="name",length = 128)
    private String name;

    @Column(name ="price")
    private Integer price;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}