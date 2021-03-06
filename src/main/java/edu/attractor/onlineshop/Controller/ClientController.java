package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Exeption.ClientRegistrationForm;
import edu.attractor.onlineshop.Entity.Client;
import edu.attractor.onlineshop.Service.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
@Data
@Controller
@RequestMapping(value = "/")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

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

    @PostMapping("/logout")
    public String logoutPage(){
        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String getNewPassword(){
        return "password";
    }

    @PostMapping("/resetPassword")
    public String getNewPassword(@ModelAttribute Client client, Model model){
        String password = clientService.getPassword(client.getEmail());
        model.addAttribute("password", password);
        return "success";
    }
}
