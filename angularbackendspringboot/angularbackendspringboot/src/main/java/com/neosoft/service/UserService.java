package com.neosoft.service;

import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        userRepository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findUser(String email) {

        return userRepository.findByEmail(email);
    }

    public List<User> cancelRegistration(int id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }


}
