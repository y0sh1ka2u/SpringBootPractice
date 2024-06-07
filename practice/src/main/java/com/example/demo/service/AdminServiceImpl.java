package com.example.demo.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements UserDetailsService {
	private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin save(SignupForm signupForm) {
    	Admin admin = new Admin();
 
    	admin.setFirstName(signupForm.getFirstName());
    	admin.setLastName(signupForm.getLastName());
    	admin.setEmail(signupForm.getEmail());
    	admin.setPassword(passwordEncoder.encode(signupForm.getPassword()));
 
    	return adminRepository.save(admin);
	}
 
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found");
        }
        return new org.springframework.security.core.userdetails.User(
            admin.getEmail(), 
            admin.getPassword(), 
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
