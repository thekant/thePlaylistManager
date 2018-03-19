/**
 * 
 */
package com.kant.social.share.plateform.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kant.social.share.plateform.dao.UserDao;
import com.kant.social.share.plateform.entity.PlaylistModel;
import com.kant.social.share.plateform.model.Playlist;

/**
 * @author kantsh
 *
 */

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public List<Playlist> list(Long id) {
		List<PlaylistModel> playlists = dao.find(id).getPlaylists();
		List<Playlist> result = new ArrayList<>();
		if (playlists != null) {
			Iterator<PlaylistModel> iterator = playlists.iterator();
			while (iterator.hasNext()) {
				result.add(new Playlist(iterator.next()));
			}
		}
		return result;
	}

}
