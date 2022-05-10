package fr.eni.demospringbootwebmvc.mmi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
@SessionAttributes({"SpringSession"})
public class SessionController {

    @GetMapping
    public String setSessionAttribute(Model model, HttpSession http) {
        model.addAttribute("SpringSession", "Anne-Lise");
        http.setAttribute("HttpSession", "Stéphane");
        http.setAttribute("SpringSession", "Julien");
        return "view-session";
    }
    @GetMapping("/invalidate")
    public String invalidateSession(Model model, HttpSession http, SessionStatus status) {
        //HttpSession invalidée
        http.invalidate();
        //Suppression des attributs de @SessionAttributs
        status.setComplete();
        //Redirection pour produire le refresh
        return "redirect:/session/refresh";
        //return "view-session";
    }
    @GetMapping("/refresh")
    public String refresh(){
        return "view-session";
    }

}
