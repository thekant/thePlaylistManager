/**
 * 
 */
package com.kant.social.share.plateform.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kant.social.share.plateform.entity.PlaylistModel;
import com.kant.social.share.plateform.entity.PlaylistVideosModel;

/**
 * @author kantsh
 *
 */
@XmlRootElement
public class Playlist {

	private Long id;
	private String title;
	private String description;
	private List<Video> videos;

	public Playlist() {
	}

	/**
	 * 
	 * @param model
	 */
	public Playlist(PlaylistModel model) {
		if (model != null) {
			setId(model.getId());
			setTitle(model.getTitle());
			setDescription(model.getDescription());
			List<Video> vids = new ArrayList<>();
			if (model.getVideos() != null) {
				Iterator<PlaylistVideosModel> iterator = model.getVideos().iterator();
				while (iterator.hasNext()) {
					vids.add(new Video(iterator.next()));
				}
				setVideos(vids);
			}
		}
	}

	/**
	 * 
	 * @param id
	 * @param title
	 * @param description
	 * @param videos
	 */
	public Playlist(Long id, String title, String description, List<Video> videos) {
		super();
		setId(id);
		setDescription(description);
		setTitle(title);
		setVideos(videos);
	}

	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "videos")
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> lVideos) {
		this.videos = lVideos;
	}

	/**
	 * @return the title
	 */
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public PlaylistModel toDaoObject() {
		PlaylistModel dbobj = new PlaylistModel();
		dbobj.setId(getId());
		dbobj.setDescription(getDescription());
		dbobj.setTitle(getTitle());

		List<PlaylistVideosModel> items = new ArrayList<>();
		if (videos != null) {
			Iterator<Video> iterator = getVideos().iterator();
			while (iterator.hasNext()) {
				Video vid = iterator.next();
				items.add(vid.toDaoObject());
			}
		}
		dbobj.setVideos(items);
		return dbobj;
	}

}
