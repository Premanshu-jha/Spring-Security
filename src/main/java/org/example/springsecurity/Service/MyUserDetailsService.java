package org.example.springsecurity.Service;

import org.example.springsecurity.Model.UserPrincipal;
import org.example.springsecurity.Model.Users;
import org.example.springsecurity.Model.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users =  usersRepository.findByUserName(username);
        if(users.isPresent()){
           return new UserPrincipal(users.get());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
