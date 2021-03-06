package com.sowapp.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sowapp.contacts.model.Contact;
import com.sowapp.contacts.services.ContactService;

@Controller
@RequestMapping("/service/contact")
public class ContactController {
	
	@Autowired
    private ContactService contactService;

	@Secured("ROLE_USER")
    @RequestMapping("/list")
    public @ResponseBody List<Contact> getContactList() {
        return contactService.getAllContacts();
    }

	@Secured("ROLE_ADMIN")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addContact(@RequestBody Contact contact) {
    	contactService.addContact(contact);
    }
	
	
	@Secured("ROLE_ADMIN")
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
	public @ResponseBody void removeContact(@RequestBody Contact contact) {
    	contactService.removeContact(contact);
    }
	
}
