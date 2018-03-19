/**
 * 
 */
package com.kant.social.share.plateform.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.kant.social.share.plateform.entity.PlaylistVideosModel;

/**
 * @author kantsh
 *
 */
@XmlRootElement
public class Video {
	private Long id;
	private String title;
	private String description;
	private String link;

	public Video() {
	}

	public Video(Long id, String title, String description, String link) {
		super();
		this.setId(id);
		this.title = title;
		this.description = description;
		this.link = link;
	}

	/**
	 * @return the title
	 */
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

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	public PlaylistVideosModel toDaoObject() {
		PlaylistVideosModel dbObject = new PlaylistVideosModel();
		dbObject.setDescription(getDescription());
		dbObject.setTitle(getTitle());
		dbObject.setVlink(getLink());
		dbObject.setId(getId());
		return dbObject;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
