package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.form.SignupForm;

@Service
public interface AdminService {
	Admin save(SignupForm signupForm);
}
