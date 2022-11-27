package anbulko.getservice.controller;

import anbulko.getservice.domain.User;
import anbulko.getservice.domain.Views;
import anbulko.getservice.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    @JsonView(Views.Normal.class)
    public List<User> list() {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public User get(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepo.save(user);
    }

    @PutMapping("{id}")
    public User update(
            @PathVariable("id") User userFromDB,
            @RequestBody User user) {
        BeanUtils.copyProperties(user,userFromDB,"id");
        return userRepo.save(userFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User user) {
        userRepo.delete(user);
    }
}
