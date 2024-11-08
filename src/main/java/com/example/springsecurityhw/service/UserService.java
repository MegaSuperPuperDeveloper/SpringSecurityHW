package com.example.springsecurityhw.service;

import com.example.springsecurityhw.model.User;
import com.example.springsecurityhw.model.enums.Role;
import com.example.springsecurityhw.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(String username, String password) {
        return userRepository.save(new User(username, password));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUsername(Long id, String username) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
        user.setUsername(username);
        user.setId(id);
        return userRepository.save(user);
    }

    public User updatePassword(Long id, String password) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
        user.setPassword(password);
        user.setId(id);
        return userRepository.save(user);
    }

    public User updateRole(Long id, Role role) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
        user.setRole(role);
        user.setId(id);
        return userRepository.save(user);
    }

}