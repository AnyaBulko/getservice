package anbulko.getservice.controller;

import anbulko.getservice.domain.User;
import anbulko.getservice.domain.Views;
import anbulko.getservice.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    @JsonView(Views.Normal.class)
    @PreAuthorize("hasAuthority('user:write')")
    public List<User> list() {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public User get(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public User create(@RequestBody User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepo.save(user);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public User update(
            @PathVariable("id") User userFromDB,
            @RequestBody User user) {
        BeanUtils.copyProperties(user,userFromDB,"id");
        return userRepo.save(userFromDB);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void delete(@PathVariable("id") User user) {
        userRepo.delete(user);
    }
}
