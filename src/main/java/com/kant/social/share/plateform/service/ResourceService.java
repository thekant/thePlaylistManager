/**
 * 
 */
package com.kant.social.share.plateform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kant.social.share.plateform.dao.PlayListDao;
import com.kant.social.share.plateform.dao.ResourceDao;
import com.kant.social.share.plateform.entity.PlaylistVideosModel;
import com.kant.social.share.plateform.model.Video;

/**
 * @author kantsh
 *
 */
@Service
public class ResourceService {

	@Autowired
	ResourceDao resourceDao;
	@Autowired
	PlayListDao playlistDao;

	public Video get(long id) {
		PlaylistVideosModel videoModel = resourceDao.get(id);
		return new Video(videoModel);
	}

	public void update(Video video,long id) {
		resourceDao.update(video.toDaoObject(),id);
	}

	public void delete(long id, long playlistid) {
		playlistDao.deleteVideoFromPlaylist(id, playlistid);
	}

}
