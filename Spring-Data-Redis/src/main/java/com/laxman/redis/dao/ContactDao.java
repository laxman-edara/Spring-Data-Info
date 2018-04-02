/**
 * 
 */
package com.laxman.redis.dao;

import java.util.Map;

import com.laxman.redis.model.Contact;

/**
 * @author ledara
 *
 */
public interface ContactDao {

	public void saveContact(Contact contact);

	public Map<Long, Contact> getAllContacts();

	public Contact getContactByEmail(String email);

	public Contact getContactById(Long id);

	public void deleteContactByEmail(String email);

	public void updateContact(Contact contact);

	public void deleteContactById(Long id);

}
