/**
 * 
 */
package com.kant.social.share.plateform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kant.social.share.plateform.model.Video;
import com.kant.social.share.plateform.service.ResourceService;

/**
 * @author kantsh
 *
 */

@Controller
@RequestMapping("user/{userid}/playlist/{playlistid}/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	/*---Get a resource by id---*/
	@GetMapping(value = "{id}", produces = "application/json")
	public ResponseEntity<Video> get(@PathVariable("id") long id) {
		Video video = resourceService.get(id);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}

	/*---Update a video by id---*/
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody Video video, @PathVariable("id") long id) {
		resourceService.update(video, id);
		return new ResponseEntity<String>("New Video has been successfully updated: " +id, HttpStatus.OK);
	}

	/*---Remove Video from playlist---*/
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id, @PathVariable("playlistid") long playlistid) {
		resourceService.delete(id, playlistid);
		return new ResponseEntity<String>("New Video has been successfully deleted: " + id, HttpStatus.OK);
	}

}
