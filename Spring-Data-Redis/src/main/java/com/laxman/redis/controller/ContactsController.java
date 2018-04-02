/**
 * 
 */
package com.laxman.redis.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laxman.redis.dao.ContactDao;
import com.laxman.redis.model.Contact;

/**
 * @author ledara
 *
 */
@RestController
@RequestMapping(value = "/contacts")
public class ContactsController {

	@Autowired
	private ContactDao contactDao;

	@RequestMapping(value = "/add/{id}/{firstname}/{lastname}")
	public Contact addContact(@PathVariable("id") String id, @PathVariable("firstname") String firstName,
			@PathVariable("lastname") String lastName) {
		Contact contact = new Contact();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			contact.setCreatedDt(sdf.parse(sdf.format(new Date())));
			contact.setModifiedDt(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contact.setId(Long.valueOf(id));
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		String str = firstName.substring(0, 1);
		contact.setEmail(str + lastName + "@gmail.com");
		contactDao.saveContact(contact);
		return contact;
	}

	@RequestMapping(value = "/update/{id}/{firstname}/{lastname}", method = RequestMethod.PUT)
	public Contact updateContact(@PathVariable("id") String id, @PathVariable("id") String firstName,
			@PathVariable("id") String lastName) {
		Contact contact = new Contact();
		contact.setId(Long.valueOf(id));
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		String str = firstName.substring(0, 1);
		contact.setEmail(str + lastName + "@gmail.com");
		contactDao.saveContact(contact);
		return contact;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Map<Long, Contact> getAllContacts() {
		return contactDao.getAllContacts();

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletContact(@PathVariable("id") String id) {
		Contact contact = contactDao.getContactById(Long.valueOf(id));
		if (contact == null) {
			return "Contact not existed....";
		}
		contactDao.deleteContactById(Long.valueOf(id));
		return "Contact deleted....";
	}

	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public Object getContactByEmail(@PathVariable("email") String email) {
		Contact contact = contactDao.getContactByEmail(email);
		if (contact != null) {
			return contact;
		} else {
			return new String("Contact not found");
		}

	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Object getContactById(@PathVariable("id") String id) {
		Contact contact = contactDao.getContactById(Long.valueOf(id));
		if (contact != null) {
			return contact;
		} else {
			return new String("Contact not found");
		}

	}

}
