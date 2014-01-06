package com.sowapp.contacts.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sowapp.contacts.model.Contact;
import com.sowapp.contacts.services.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

	private static List<Contact> contactList = new ArrayList<Contact>();
	private static Long id = 0L;

	@Override
	public List<Contact> getAllContacts() {
		return contactList;
	}

	@Override
	public void addContact(Contact contact) {
		contact.setId(++id);
		contactList.add(contact);
	}

	@Override
	public void removeContact(Contact contact) {
		Contact foundContact = findContactById(contact.getId());
		if (foundContact != null) {
			contactList.remove(foundContact);
			id--;
		}
	}

	private Contact findContactById(Long id) {
		for (Contact contact : contactList) {
			if (contact.getId() == id) {
				return contact;
			}
		}

		return null;
	}

}
