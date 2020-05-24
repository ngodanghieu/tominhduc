package com.payment.wallet.security;

import com.payment.wallet.entities.User;
import com.payment.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
       User user = userRepository.findByPhone(phone);
        if (user != null) {
            Set<GrantedAuthority> roles = new HashSet<>();
            roles.add(new SimpleGrantedAuthority(user.getPhone()));
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(roles);
            return new org.springframework.security.core.userdetails.User(phone, user.getPass(), authorities);
        } else {
            throw new UsernameNotFoundException("user get email " + phone + " does not exist.");
        }
    }
}
