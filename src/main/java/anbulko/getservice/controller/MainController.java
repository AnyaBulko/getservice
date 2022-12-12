package anbulko.getservice.controller;

import anbulko.getservice.domain.Role;
import anbulko.getservice.repo.UserRepo;
import anbulko.getservice.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    private final UserRepo userRepo;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public MainController(UserRepo userRepo, UserDetailsServiceImpl userDetailsService) {
        this.userRepo = userRepo;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {

        HashMap<Object, Object> data = new HashMap<>();

        if (user != null) {
            anbulko.getservice.domain.User fullUser = userRepo.findByEmail(user.getUsername()).get();
            fullUser.setPassword(null);
            data.put("profile", fullUser);
            if(fullUser.getRole() == Role.ADMIN) {
                data.put("users", userRepo.findAll());
            }
        }

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }
}
