package com.example.nazikayim.service;

import com.example.nazikayim.models.User;
import com.example.nazikayim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User editeuser(User user) {
        return userRepo.save(user);
    }

    public User findUser(Long id) {
        return userRepo.findById(id).get();
    }

    public User findUser(String userName) {
        return userRepo.findByName(userName);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


}
