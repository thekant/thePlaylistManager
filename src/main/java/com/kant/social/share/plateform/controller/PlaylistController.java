package com.kant.social.share.plateform.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kant.social.share.plateform.request.model.Playlist;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping("/playlist")
public class PlaylistController {

	private static final Logger logger = LoggerFactory
			.getLogger(PlaylistController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping( method = RequestMethod.GET)
	@ResponseBody
	public List<Playlist> home(String userId ) {
		logger.info("Welcome home!");
		
		//step 1 : fetch user's playlist from userId
		
		//model.addAttribute("controllerMessage",
		//		"This is the message from the controller!");
		
		return null;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPlaylist(@ModelAttribute("playlist")Playlist playlist, String userId) {
		logger.info("creating playlist!");
		return "";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public String updatePlaylist(@ModelAttribute("playlist")Playlist playlist, String userId) {
		logger.info("updating playlist!");
		return "updating";
	}
	
	@RequestMapping(value = "/publish", method = RequestMethod.PUT)
	public String publishPlaylist(String playlistId, String userId) {
		logger.info("publishing playlist!");
		return "";
	}
	

}
