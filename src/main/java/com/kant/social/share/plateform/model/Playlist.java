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

	public Playlist(PlaylistModel model) {
		this(model.getId(), model.getTitle(), model.getDescription(),
				null);
		List<Video> vids= new ArrayList<>();
		if(model.getVideos()!=null) {
			Iterator<PlaylistVideosModel> iterator = model.getVideos().iterator();
			while(iterator.hasNext()) {
				PlaylistVideosModel next = iterator.next();
				vids.add(new Video (next.getId(),next.getTitle(),next.getDescription(),next.getVlink()));
			}
			setVideos(vids);
		}
		
		//stream()
		//.map(x -> new Video(x.getId(), x.getTitle(), x.getDescription(), x.getVlink()))
		//.collect(Collectors.toList());
		
	}

	public Playlist(Long id, String title, String description, List<Video> videos) {
		super();
		setId(id);
		setDescription(description);
		setTitle(title);
		setVideos(videos);
	}

	@XmlElement(name="playlist_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="videos")
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> lVideos) {
		this.videos = lVideos;
	}

	/**
	 * @return the title
	 */
	@XmlElement(name="title")
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
	@XmlElement(name="description")
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

		List<PlaylistVideosModel> items = new ArrayList<PlaylistVideosModel>();
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
