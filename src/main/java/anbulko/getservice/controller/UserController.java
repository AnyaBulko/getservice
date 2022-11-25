package anbulko.getservice.controller;

import anbulko.getservice.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private int counter = 4;
    private List<Map<String, String>> users = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1");
            put("name", "Anya");
        }});add(new HashMap<String, String>() {{
            put("id", "3");
            put("name", "Yana");
        }});add(new HashMap<String, String>() {{
            put("id", "4");
            put("name", "Sanya");
        }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return users;
    }

    @GetMapping("{id}")
    public Map<String, String> getUser(@PathVariable String id) {
        return geUser(id);
    }

    private Map<String, String> geUser(String id) {
        return users.stream()
                .filter(user -> user.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> user) {
        user.put("id", String.valueOf(counter++));
        users.add(user);
        return user;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> user) {
        Map<String, String> userFromDB = getUser(id);
        userFromDB.putAll(user);
        userFromDB.put("id", id);
        return userFromDB;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> user = getUser(id);
        users.remove(user);
    }
}
