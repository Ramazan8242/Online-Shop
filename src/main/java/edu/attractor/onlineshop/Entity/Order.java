package edu.attractor.onlineshop.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@Entity
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Client client;

    @OneToMany
    private List<Product> products;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    private List<Feedback> feedback;
}
