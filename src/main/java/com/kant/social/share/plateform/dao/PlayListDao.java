/**
 * 
 */
package com.kant.social.share.plateform.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kant.social.share.plateform.entity.PlaylistModel;
import com.kant.social.share.plateform.entity.UserModel;

/**
 * @author kantsh
 *
 */
@Repository
public class PlayListDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public long save(PlaylistModel playlist, long userid) {
		UserModel user = entityManager.find(UserModel.class, userid);
		// cannot save if no userid
		if (user == null)
			return -1;
		user.getPlaylists().add(playlist);
		playlist.setUser(user);

		entityManager.persist(user);
		entityManager.flush();
		return playlist.getId();
	}

	@Transactional
	public PlaylistModel get(long id) {
		PlaylistModel result = entityManager.find(PlaylistModel.class, id);
		return result;
	}

	@Transactional
	public void update(PlaylistModel playlist) {
		if (playlist.getId() == null)
			return;
		PlaylistModel modelToSave = entityManager.find(PlaylistModel.class, playlist.getId());
		if (playlist.getTitle() != null)
			modelToSave.setTitle(playlist.getTitle());
		if (playlist.getDescription() != null)
			modelToSave.setDescription(playlist.getDescription());
		if (playlist.getVideos() != null && playlist.getVideos().size() > 0) {
			for (int i = 0; i < playlist.getVideos().size(); i++) {
				modelToSave.getVideos().add(playlist.getVideos().get(i));
				playlist.getVideos().get(i).setPlaylist(modelToSave);
			}
		}
		entityManager.persist(modelToSave);
	}

}
