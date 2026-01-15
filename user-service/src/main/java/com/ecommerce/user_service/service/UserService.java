package com.ecommerce.user_service.service;

import com.ecommerce.user_service.model.User;
import com.ecommerce.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        public User register(User user) {
            return userRepository.save(user);
        }

        public User login(String email, String password) {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }

            return user;
        }
        
        public Optional<User> findById(Long id){
            return userRepository.findById(id);
        }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
