package com.example.hhhack.service;

import com.example.hhhack.entity.User;
import com.example.hhhack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPassword(userDetails.getPassword());
            user.setNickName(userDetails.getNickName());
            user.setGender(userDetails.getGender());
            user.setEmail(userDetails.getEmail());
            user.setStatus(userDetails.getStatus());
            user.setPhone(userDetails.getPhone());
            user.setInactiveDate(userDetails.getInactiveDate());
            user.setUpdateAt(userDetails.getUpdateAt());

            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
        }
    }