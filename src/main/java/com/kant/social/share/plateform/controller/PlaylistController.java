package com.kant.social.share.plateform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kant.social.share.plateform.model.Playlist;
import com.kant.social.share.plateform.service.PlaylistService;

/**
 * Sample controller for going to the home page with a message
 */
@RestController
@RequestMapping("{userid}/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;

	/**
	 * playlist creation works.
	 * 
	 * @param playlist
	 * @param userid
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Playlist playlist, @PathVariable("userid") long userid) {
		long id = playlistService.save(playlist, userid);
		return new ResponseEntity<String>("New Playlist has been saved with ID:" + id, HttpStatus.OK);
	}

	/*---Get a playlist by id---*/
	@GetMapping(value= "{id}" , produces="application/json")
	public ResponseEntity<Playlist> get(@PathVariable("id") long id) {
		Playlist playlist = playlistService.get(id);
		return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
	}

	/*---Update a book by id---*/
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody Playlist playlist) {
		playlistService.update(playlist);
		return new ResponseEntity<String>("New Book has been successfully updated" + playlist.getId(), HttpStatus.OK);
	}

	/*---Delete a book by id---*/
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id,  @PathVariable("userid") long userid) {
		playlistService.delete(id,userid);
		return new ResponseEntity<String>("New Book has been successfully deleted" + id, HttpStatus.OK);
	}

}
