package edu.attractor.onlineshop.Entity;

import lombok.*;

import javax.persistence.*;

@Data@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
