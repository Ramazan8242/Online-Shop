package edu.attractor.onlineshop.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    @OrderBy("name ASC")
    private List<Product> products;
}
