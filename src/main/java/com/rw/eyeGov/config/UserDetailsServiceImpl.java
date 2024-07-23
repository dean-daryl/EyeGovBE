package com.rw.eyeGov;

import com.rw.eyeGov.config.CustomUserDetails;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.repository.IUserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(username).orElseThrow();
        if(user == null){
            throw new UsernameNotFoundException("could not found user..!!");
        }
        return new CustomUserDetails(user);
    }
}
