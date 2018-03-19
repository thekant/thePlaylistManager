package com.kant.social.share.plateform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kant.social.share.plateform.model.Playlist;
import com.kant.social.share.plateform.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	

	@Autowired
	private UserService userService;
	
	
	/*---Fetching playlists for user---*/
	@GetMapping("{id}/playlist")
	public ResponseEntity<List<Playlist>> list(@PathVariable("id") Long id) {
		List<Playlist> playlists = userService.list(id);
		return new ResponseEntity<List<Playlist>>(playlists, HttpStatus.OK);
	}
	
	/**@RequestMapping(method=RequestMethod.GET,value="edit")
	public ModelAndView editPerson(@RequestParam(value="id",required=false) Long id) {		
		logger.debug("Received request to edit person id : "+id);				
		ModelAndView mav = new ModelAndView();		
 		mav.setViewName("edit");
 		UserModel person = null;
 		if (id == null) {
 			person = new UserModel();
 		} else {
 			person = userDao.find(id);
 		}
 		mav.addObject("person", person);
		return mav;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="edit") 
	public String savePerson(@ModelAttribute UserModel person) {
		logger.debug("Received postback on person "+person);		
		userDao.save(person);
		return "redirect:list";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="list")
	public ModelAndView listPeople() {
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<UserModel> people = userDao.getPeople();
		logger.debug("Person Listing count = "+people.size());
		mav.addObject("people",people);
		mav.setViewName("list");
		return mav;
	}**/
	
}
