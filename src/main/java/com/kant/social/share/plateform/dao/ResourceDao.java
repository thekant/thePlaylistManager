/**
 * 
 */
package com.kant.social.share.plateform.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kant.social.share.plateform.entity.PlaylistVideosModel;

/**
 * @author kantsh
 *
 */
@Repository
public class ResourceDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public PlaylistVideosModel get(long id) {
		PlaylistVideosModel result = entityManager.find(PlaylistVideosModel.class, id);
		return result;
	}

	/**
	 * @param uploadedResource
	 * @param id
	 */
	@Transactional
	public void update(PlaylistVideosModel uploadedResource, long id) {
		PlaylistVideosModel modelTosave = entityManager.find(PlaylistVideosModel.class, id);

		if (uploadedResource.getDescription() != null && !uploadedResource.getDescription().equals(""))
			modelTosave.setDescription(uploadedResource.getDescription());
		if (uploadedResource.getTitle() != null && !uploadedResource.getTitle().equals(""))
			modelTosave.setTitle(uploadedResource.getTitle());
		if (uploadedResource.getVlink() != null && !uploadedResource.getVlink().equals(""))
			modelTosave.setVlink(uploadedResource.getVlink());

		entityManager.persist(modelTosave);
		entityManager.flush();
	}


}
