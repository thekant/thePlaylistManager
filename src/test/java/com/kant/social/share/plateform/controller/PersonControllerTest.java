package com.kant.social.share.plateform.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonControllerTest {
	
	@Autowired
	private DataInitializer dataInitializer;
	
	@Autowired
	private UserController userController;
		
	@Before
	public void before() {
		dataInitializer.initData();
	}
	
	@Test
	public void shouldReturnPersonListView() {
		/*ModelAndView mav = userController.listPeople();
		assertEquals("list",mav.getViewName());
		
		@SuppressWarnings("unchecked")
		List<UserModel> people = (List<UserModel>) mav.getModelMap().get("people");
		assertNotNull(people);		
		assertEquals(DataInitializer.PERSON_COUNT,people.size());		*/
	}
	
	

	public void shouldReturnNewPersonWithEditMav() {
		/*ModelAndView mav = userController.editPerson(null);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(UserModel.class.isAssignableFrom(object.getClass()));
		UserModel person = (UserModel) object;
		assertNull(person.getId());
		assertNull(person.getFirstName());
		assertNull(person.getLastName());	*/	
	}
	
	@Test
	public void shouldReturnSecondPersonWithEditMav() {
		/*Long template = dataInitializer.people.get(1);
		ModelAndView mav = userController.editPerson(template);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(UserModel.class.isAssignableFrom(object.getClass()));
		UserModel person = (UserModel) object;
		assertEquals(template,person.getId());*/
	}
	
}
