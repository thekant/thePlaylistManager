/**
 * 
 */
package com.kant.social.share.plateform.entity;

/**
 * @author kantsh
 *
 */
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist_share")
public class PlaylistShareModel {
	
	public PlaylistShareModel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private PlaylistModel playlist;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserModel user;
	
	@Column
	private Long registerationCount;

	@Column
	private Long clicksCount;

	@Column
	private Long vlink;
	
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

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel userModel) {
		this.user = userModel;
	}

	public Long getRegisterationCount() {
		return registerationCount;
	}

	public void setRegisterationCount(Long registerationCount) {
		this.registerationCount = registerationCount;
	}

	public Long getClicksCount() {
		return clicksCount;
	}

	public void setClicksCount(Long clicksCount) {
		this.clicksCount = clicksCount;
	}

	public Long getVlink() {
		return vlink;
	}

	public void setVlink(Long vlink) {
		this.vlink = vlink;
	}

}
