package edu.attractor.onlineshop.Controller;

import edu.attractor.onlineshop.Dto.KeyValueRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class FrontendController {

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
