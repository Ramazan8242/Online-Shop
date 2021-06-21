package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.DoMain.ClientRegistrationForm;
import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Service.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Data
@Controller
public class ClientController {
    @Autowired
    private final ClientService clientService;
    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal) {
        var user = clientService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }

    @GetMapping("/registration")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new ClientRegistrationForm());
        }
        return "registration";
    }

    @PostMapping("/registration")
    public String registerPage(@Valid ClientRegistrationForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/registration";
        }

        clientService.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/{id}")
    public String getClientsName(@PathVariable Integer id, Model model){
        Client client = clientService.getNameClients(id);
        model.addAttribute("client" , client);
        return "user";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}
