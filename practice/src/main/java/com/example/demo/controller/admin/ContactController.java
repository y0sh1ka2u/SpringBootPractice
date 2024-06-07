package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("Admin")
@RequestMapping("/admin")
public class ContactController {
	@GetMapping("/contacts")
    public String index() {
        return "/admin/contacts";
    }
}
