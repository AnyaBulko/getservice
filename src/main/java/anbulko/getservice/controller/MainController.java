package anbulko.getservice.controller;

import anbulko.getservice.repo.UserRepo;
import anbulko.getservice.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainController {

    private final UserRepo userRepo;
    private final UserDetailsServiceImpl userDetailsService;
@Autowired
    public MainController(UserRepo userRepo, UserDetailsServiceImpl userDetailsService) {
        this.userRepo = userRepo;
    this.userDetailsService = userDetailsService;
}

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {

//        Optional<anbulko.getservice.domain.User> test = userRepo.findByEmail(user.getUsername());
//        data.put("profile",test.get());
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("users",userRepo.findAll());
        model.addAttribute("frontendData", data);
        return "index";
    }
}
