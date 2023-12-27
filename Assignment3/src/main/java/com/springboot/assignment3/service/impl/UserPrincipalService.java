package com.springboot.assignment3.service.impl;

import com.springboot.assignment3.dao.UserRepository;
import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPrincipalService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    /* Lấy ra user đã đang nhập */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        UserPrincipal accountDTO = new UserPrincipal(user.getEmail(),user.getPassword(),true,
                true,true, true,authorities);
        accountDTO.setId(user.getId());
        accountDTO.setName(user.getName());
        accountDTO.setRoleId(user.getRole());
        accountDTO.setEmail(user.getEmail());
        accountDTO.setAddress(user.getAddress());
        accountDTO.setPhone(user.getPhone());
        accountDTO.setActive(user.isActive());
        accountDTO.setGender(user.getGender());
        accountDTO.setPassword(user.getPassword());
        if (user.getPatient() == null){
            return accountDTO;
        }
        if (user.getPatient().getExtrainfo() == null){
            return accountDTO;
        } else {
            accountDTO.setHistoryBreath(user.getPatient().getExtrainfo().getHistoryBreath());
        }
        return accountDTO;
    }
}
