package com.sowapp.contacts.services;

import java.util.List;

import com.sowapp.contacts.model.Contact;

public interface ContactService {
	
	public List<Contact> getAllContacts();

	public void addContact(Contact contact);
	
	public void removeContact(Contact contact);
}
