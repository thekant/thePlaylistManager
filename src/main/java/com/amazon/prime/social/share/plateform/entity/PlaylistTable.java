package com.amazon.prime.social.share.plateform.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Playlist")
public class PlaylistTable {
	
	public PlaylistTable() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private PrimeUser user;

	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlaylistVideosTable> videos = new ArrayList<PlaylistVideosTable>();

	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlaylistShareTable> shares = new ArrayList<PlaylistShareTable>();

	@Column
	private String title;

	@Column
	private String description;

	public void setUser(PrimeUser user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PlaylistVideosTable> getVideos() {
		return videos;
	}

	public void addVideos(List<PlaylistVideosTable> theVideos) {
		videos.addAll(theVideos);
		this.videos = theVideos;
	}

	public void addShares(List<PlaylistShareTable> theShares) {
		shares.addAll(theShares);
		this.shares = theShares;
	}

	public List<PlaylistShareTable> getShares() {
		return shares;
	}

	public void setShares(List<PlaylistShareTable> shares) {
		this.shares = shares;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVideos(List<PlaylistVideosTable> videos) {
		this.videos = videos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PrimeUser getUser() {
		return user;
	}

}
