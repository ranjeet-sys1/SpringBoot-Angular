package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        String encode = bCryptPasswordEncoder.encode(password);
        user.setPassword(encode);
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {
        Optional<User> byEmail = userRepo.findByEmail(email);
        if(!byEmail.isPresent())
            throw new UsernameNotFoundException("user not found");
        User user = byEmail.get();
        return new org.springframework.security.core.userdetails.User(email,
                user.getPassword(),
                user.getRoles().stream()
                        .map(roles->new SimpleGrantedAuthority(roles))
                        .collect(Collectors.toSet()));
    }
}
