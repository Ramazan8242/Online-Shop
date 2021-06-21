package edu.attractor.onlineshop.Dto;

import edu.attractor.onlineshop.Entity.Client;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class ClientDto {
    private int id;
    private String fullname;
    private String email;

    public static ClientDto from(Client user) {
        return builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .build();
    }
}
