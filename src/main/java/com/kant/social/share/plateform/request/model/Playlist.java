/**
 * 
 */
package com.kant.social.share.plateform.request.model;

/**
 * @author kantsh
 *
 */
public class Playlist {

	private Long id;
	
	private PlaylistVideos videos;
	
	
	public Playlist(Long id, PlaylistVideos videos) {
		super();
		this.id = id;
		this.videos = videos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PlaylistVideos getVideos() {
		return videos;
	}
	public void setVideos(PlaylistVideos videos) {
		this.videos = videos;
	}
	
	
	
}
