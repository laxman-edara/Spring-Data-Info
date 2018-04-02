/**
 * 
 */
package com.laxman.redis.dao.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.laxman.redis.dao.ContactDao;
import com.laxman.redis.model.Contact;

/**
 * @author ledara
 *
 */
@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, Long, Contact> hashOperations;

	private static final String KEY = "CONTACTS";

	@PostConstruct
	public void init() {
		this.hashOperations = redisTemplate.opsForHash();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.laxman.redis.dao.ContactDao#saveContact(com.laxman.redis.model.Contact)
	 */
	@Override
	public void saveContact(Contact contact) {
		hashOperations.putIfAbsent(KEY, contact.getId(), contact);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.laxman.redis.dao.ContactDao#getAllContacts()
	 */
	@Override
	public Map<Long, Contact> getAllContacts() {
		return hashOperations.entries(KEY);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.laxman.redis.dao.ContactDao#getContactByEmail(java.lang.String)
	 */
	@Override
	public Contact getContactByEmail(String email) {
		return hashOperations.get(KEY, email);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.laxman.redis.dao.ContactDao#getContactById(java.lang.Long)
	 */
	@Override
	public Contact getContactById(Long id) {
		return hashOperations.get(KEY, Long.valueOf(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.laxman.redis.dao.ContactDao#updateContact(com.laxman.redis.model.Contact)
	 */
	@Override
	public void updateContact(Contact contact) {
		hashOperations.put(KEY, contact.getId(), contact);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.laxman.redis.dao.ContactDao#deleteContact(java.lang.String)
	 */
	@Override
	public void deleteContactById(Long id) {
		hashOperations.delete(KEY, id);
	}

	@Override
	public void deleteContactByEmail(String email) {
		hashOperations.delete(KEY, email);

	}

}
