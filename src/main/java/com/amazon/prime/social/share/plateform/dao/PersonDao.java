package com.amazon.prime.social.share.plateform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.prime.social.share.plateform.entity.PrimeUser;

@Repository
public class PersonDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public PrimeUser find(Long id) {
		return entityManager.find(PrimeUser.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PrimeUser> getPeople() {
		return entityManager.createQuery("select p from Person p").getResultList();
	}
	
	@Transactional
	public PrimeUser save(PrimeUser person) {
		if (person.getId() == null) {
			entityManager.persist(person);
			return person;
		} else {
			return entityManager.merge(person);
		}		
	}	
	
}
