package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.DoMain.ClientAlreadyRegisteredException;
import edu.attractor.onlineshop.DoMain.ClientRegistrationForm;
import edu.attractor.onlineshop.Dto.ClientDto;
import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.NotFound.ClientNotFoundException;
import edu.attractor.onlineshop.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    private final PasswordEncoder encoder;

    public ClientDto register(ClientRegistrationForm form) {
        if (clientRepository.existsByEmail(form.getEmail())) {
            throw new ClientAlreadyRegisteredException();
        }

        var user = Client.builder()
                .email(form.getEmail())
                .fullname(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        clientRepository.save(user);

        return ClientDto.from(user);
    }

    public Client getNameClients(Integer id){
        return clientRepository.findById(id).orElseThrow();
    }

    public ClientDto getByEmail(String email) {
        var user = clientRepository.findByEmail(email)
                .orElseThrow(ClientNotFoundException::new);

        return ClientDto.from(user);
    }
}
