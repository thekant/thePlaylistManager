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
public class PlaylistShareTable {
	
	public PlaylistShareTable() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private PlaylistTable playlist;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private PrimeUser user;
	
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

	public PlaylistTable getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlaylistTable playlist) {
		this.playlist = playlist;
	}

	public PrimeUser getUser() {
		return user;
	}

	public void setUser(PrimeUser user) {
		this.user = user;
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
