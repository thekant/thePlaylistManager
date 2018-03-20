/**
 * 
 */
package com.kant.social.share.plateform.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kant.social.share.plateform.dao.PlayListDao;
import com.kant.social.share.plateform.dao.UserDao;
import com.kant.social.share.plateform.entity.PlaylistModel;
import com.kant.social.share.plateform.entity.PlaylistVideosModel;
import com.kant.social.share.plateform.model.Playlist;
import com.kant.social.share.plateform.model.Video;

/**
 * @author kantsh
 *
 */
@Service
public class PlaylistService {

	@Autowired
	private PlayListDao playListDao;
	@Autowired
	private UserDao userDao;

	public long save(Playlist playlist, long userid) {
		return playListDao.save(playlist.toDaoObject(), userid);
	}

	public Playlist get(long id) {
		PlaylistModel playlistModel = playListDao.get(id);
		return new Playlist(playlistModel);
	}

	/**
	 * Update should only add videos set title set description
	 * 
	 * @param playlist
	 */
	public void update(Playlist playlist, long id) {
		playListDao.update(playlist.toDaoObject(), id);
	}

	public void delete(long id, long userid) {
		userDao.deletePlaylist(id, userid);
	}

	public List<Video> listResources(long id) {
		PlaylistModel playlistModel = playListDao.get(id);
		List<Video> result = new ArrayList<>();
		if (playlistModel != null) {
			if (playlistModel.getVideos() != null) {
				Iterator<PlaylistVideosModel> iterator = playlistModel.getVideos().iterator();
				while (iterator.hasNext()) {
					result.add(new Video(iterator.next()));
				}
			}
		}
		return result;
	}

}
