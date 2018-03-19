/**
 * 
 */
package com.kant.social.share.plateform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kant.social.share.plateform.dao.PlayListDao;
import com.kant.social.share.plateform.dao.UserDao;
import com.kant.social.share.plateform.entity.PlaylistModel;
import com.kant.social.share.plateform.model.Playlist;

/**
 * @author kantsh
 *
 */
@Service
public class PlaylistService {
	
	@Autowired
	private PlayListDao playListDao;
	private UserDao userDao;

	public long save(Playlist playlist, long userid) {
		return  playListDao.save(playlist.toDaoObject(), userid);
	}

	public Playlist get(long id) {
		PlaylistModel playlistModel = playListDao.get(id);
		return new Playlist(playlistModel);
	}

	public void update(Playlist playlist) {
		playListDao.update(playlist.toDaoObject());
	}

	public void delete(long id , long userid) {
		userDao.deletePlaylist(id, userid);
	}

	
}
