package com.kant.social.share.plateform.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kant.social.share.plateform.entity.PlaylistModel;
import com.kant.social.share.plateform.entity.UserModel;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public UserModel find(Long id) {
		UserModel userModel = entityManager.find(UserModel.class, id);
		return userModel;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserModel> getPeople() {
		return entityManager.createQuery("select u from UserModel u").getResultList();
	}

	@Transactional
	public UserModel save(UserModel user) {
		if (user.getId() == null) {
			entityManager.persist(user);
			return user;
		} else {
			return entityManager.merge(user);
		}
	}

	/**
	 * deletes a playlist.
	 * 
	 * @param playlistId
	 * @param userid
	 */
	@Transactional
	public void deletePlaylist(long playlistId, long userid) {
		UserModel user = entityManager.find(UserModel.class, userid);
		List<PlaylistModel> playlists = user.getPlaylists();
		if (playlists == null || playlists.size() == 0)
			return;
		Iterator<PlaylistModel> iterator = playlists.iterator();
		while(iterator.hasNext()) {
			PlaylistModel next = iterator.next();
			if(next.getId().equals(playlistId)) {
				iterator.remove();
				next.setUser(null);
				break;
			}
		}
		entityManager.persist(user);
	}

}
