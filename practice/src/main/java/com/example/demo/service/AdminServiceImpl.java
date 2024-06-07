package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
    private AdminRepository adminRepository;

    public Admin save(SignupForm signupForm) {
    	Admin admin = new Admin();
    	
    	admin.setFirstName(signupForm.getFirstName());
    	admin.setLastName(signupForm.getLastName());
    	admin.setEmail(signupForm.getEmail());

    	// 暗号化処理は後で共通メソッドに移動
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    	admin.setPassword(passwordEncoder.encode(signupForm.getPassword()));
    	
    	return adminRepository.save(admin);
	}
    }
