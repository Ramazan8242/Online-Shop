package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.Exeption.ClientAlreadyRegisteredException;
import edu.attractor.onlineshop.Exeption.ClientRegistrationForm;
import edu.attractor.onlineshop.Dto.ClientDto;
import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Exeption.ClientNotFoundException;
import edu.attractor.onlineshop.Exeption.NotFoundException;
import edu.attractor.onlineshop.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

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

    public Client getByEmail(String email) {

        return clientRepository.findByEmail(email)
                .orElseThrow(ClientNotFoundException::new);
    }
    private String randomStringGenerator(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public String getPassword(String email) {
        final Client client=this.clientRepository.findByEmail(email).orElseThrow(NotFoundException::new);
        return updatePassword(client);
    }

    private String updatePassword(Client client){
        String newPassword = randomStringGenerator();
        client.setPassword(encoder.encode(newPassword));
        this.clientRepository.save(client);
        return newPassword;
    }
}
