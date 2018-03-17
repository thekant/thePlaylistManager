package com.kant.social.share.plateform.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.kant.social.share.plateform.controller.PersonController;
import com.kant.social.share.plateform.entity.PrimeUser;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonControllerTest {
	
	@Autowired
	private DataInitializer dataInitializer;
	
	@Autowired
	private PersonController personController;
		
	@Before
	public void before() {
		dataInitializer.initData();
	}
	
	@Test
	public void shouldReturnPersonListView() {
		ModelAndView mav = personController.listPeople();
		assertEquals("list",mav.getViewName());
		
		@SuppressWarnings("unchecked")
		List<PrimeUser> people = (List<PrimeUser>) mav.getModelMap().get("people");
		assertNotNull(people);		
		assertEquals(DataInitializer.PERSON_COUNT,people.size());		
	}
	
	

	public void shouldReturnNewPersonWithEditMav() {
		ModelAndView mav = personController.editPerson(null);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(PrimeUser.class.isAssignableFrom(object.getClass()));
		PrimeUser person = (PrimeUser) object;
		assertNull(person.getId());
		assertNull(person.getFirstName());
		assertNull(person.getLastName());		
	}
	
	@Test
	public void shouldReturnSecondPersonWithEditMav() {
		Long template = dataInitializer.people.get(1);
		ModelAndView mav = personController.editPerson(template);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(PrimeUser.class.isAssignableFrom(object.getClass()));
		PrimeUser person = (PrimeUser) object;
		assertEquals(template,person.getId());
	}
	
}
