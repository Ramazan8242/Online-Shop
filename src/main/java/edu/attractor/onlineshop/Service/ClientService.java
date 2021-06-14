package edu.attractor.onlineshop.Service;

import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Repository.ClientRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ClientService {
    private final ClientRepository clientRepository;

    public Client getNameClients(Integer id){
        return clientRepository.findById(id).orElseThrow();
    }
}
