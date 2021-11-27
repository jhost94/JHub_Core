package com.jhost.core.Core.service;

import com.jhost.core.Core.bean.CoreUserDetails;
import com.jhost.core.Core.entity.User;
import com.jhost.core.Core.exception.UsernameNotFoundException;
import com.jhost.core.Core.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoreUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CoreUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        return new CoreUserDetails(user.get());
    }


}
