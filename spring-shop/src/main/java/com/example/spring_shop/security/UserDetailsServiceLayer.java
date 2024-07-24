package com.example.spring_shop.security;

import com.example.spring_shop.entities.impl.User;
import com.example.spring_shop.repos.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceLayer implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceLayer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomerDetails(user.get());
    }
}
