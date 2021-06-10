package edu.attractor.onlineshop.Repository;

import edu.attractor.onlineshop.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
