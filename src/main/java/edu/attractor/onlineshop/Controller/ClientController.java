package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Dto.KeyValueRequestDto;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @PostMapping("/logout")
    public String logoutPage(){
        return "redirect:/login";
    }

    @GetMapping("/cart")
    public String cart(Model model, @SessionAttribute(name = Constants.CART_ID, required = false) List<String> cart) {
        if (cart != null) {
            model.addAttribute("cartItems", cart);
        }
        return "cart";
    }

    @PostMapping("/cart")
    @ResponseBody
    public boolean addToListRest(@RequestParam String value, @SessionAttribute(name = Constants.CART_ID, required = false) List<String> cart) {
        if (cart != null) {
            cart.add(value);
        }
        return true;
    }

    @PostMapping("/cart/add")
    public String addToList(@RequestParam String value, HttpSession session) {
        if (session != null) {
            var attr = session.getAttribute(Constants.CART_ID);
            if (attr == null) {
                session.setAttribute(Constants.CART_ID, new ArrayList<String>());
            }
            try {
                var list = (List<String>) session.getAttribute(Constants.CART_ID);
                list.add(value);
            } catch (ClassCastException ignored) {
            }
        }
        return "redirect:/";
    }

    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.CART_ID);
        return "redirect:/cart";
    }
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        var map = new HashMap<String, Object>();
        map.put("Идентификатор сессии", session.getId());

        session.getAttributeNames()
                .asIterator()
                .forEachRemaining(key -> map.put(key, session.getAttribute(key).toString()));

        model.addAttribute("sessionAttributes", map);
        return "index";
    }

    @GetMapping("/invalidate")
    public String invalidate(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @PostMapping("/store")
    public String store(KeyValueRequestDto data, HttpSession session) {
        if (session != null) {
            var attr = session.getAttribute(data.getKey());
            if (attr == null) {
                session.setAttribute(data.getKey(), data.getValue());
            }
        }

        return "redirect:/";
    }
}
