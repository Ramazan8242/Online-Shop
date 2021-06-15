package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Service.ClientService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("{id}")
    public String getClientsName(@PathVariable Integer id, Model model){
        Client client = clientService.getNameClients(id);
        model.addAttribute("client" , client);
        return "user";
    }
}
