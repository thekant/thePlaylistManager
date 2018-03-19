/**
 * 
 */
package com.kant.social.share.plateform.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlists_videos")
public class PlaylistVideosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private PlaylistModel playlist;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private String vlink;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlaylistModel getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlaylistModel playlist) {
		this.playlist = playlist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVlink() {
		return vlink;
	}

	public void setVlink(String vlink) {
		this.vlink = vlink;
	}

}
