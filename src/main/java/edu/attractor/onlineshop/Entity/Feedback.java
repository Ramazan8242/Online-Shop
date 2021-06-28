package edu.attractor.onlineshop.Entity;

import edu.attractor.onlineshop.Dto.ClientDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private String text;

    public Feedback(Order order, LocalDateTime date, Client client,Product product, String text) {
        this.order = order;
        this.date = date;
        this.client = client;
        this.product = product;
        this.text = text;
    }
}
