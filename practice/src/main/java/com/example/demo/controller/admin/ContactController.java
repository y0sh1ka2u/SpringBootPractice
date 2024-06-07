package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@Controller("Admin")
@RequestMapping("/admin")
public class ContactController {
	@Autowired
	ContactService contactService;

	@GetMapping("/contacts")
    public String index(Model model) {
		List<Contact> contacts = contactService.fetchContactList();
		model.addAttribute("contacts", contacts);

        return "/admin/contacts";
    }
}
