package edu.attractor.onlineshop.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(length = 128)
    private String name;
    @Min(13)
    private Integer age;
    @Column(length = 224)
    private String address;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
}