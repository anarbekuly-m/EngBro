package kz.engbro.controller;

import kz.engbro.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final AuthService authService;

    @Autowired
    public ProfileController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping()
    public String profile(Model model) {
        System.out.println("==================================");
        System.out.println(loggedUser());
        System.out.println("==================================");
        model.addAttribute("user", authService.findById(loggedUser().getUsername()));
        model.addAttribute("password", authService.findById(loggedUser().getUsername()).getPassword());
        return "profile";
    }

    private UserDetails loggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return user;
    }
}
