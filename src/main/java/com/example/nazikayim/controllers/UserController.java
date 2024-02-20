package com.example.nazikayim.controllers;

import com.example.nazikayim.models.User;
import com.example.nazikayim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User foundUser = userService.saveUser(user);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @PutMapping
    public ResponseEntity<User> editeUser(@RequestBody User user) {
        User foundUser = userService.editeuser(user);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ResponseEntity<User> findUser(@RequestParam(required = false) Long id,
                                         @RequestParam(required = false) String nikName) {
        User user;
        if (id > 0) {
            user = userService.findUser(id);
        } else if (nikName != null) {
            user = userService.findUser(nikName);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }
}
