package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.SigninForm;
import com.example.demo.form.SignupForm;
import com.example.demo.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AuthController {
	@Autowired
    private AdminServiceImpl adminServiceImpl;

	@GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "/admin/signup";
    }

	@PostMapping("/signup")
    public String signupSubmit(@ModelAttribute SignupForm signupForm) {
		adminServiceImpl.save(signupForm);

		return "redirect:/admin/signin";
    }

    @GetMapping("/signin")
    public String signinForm(Model model) {
    	model.addAttribute("signinForm", new SigninForm());

    	return "/admin/signin";
    }
}
