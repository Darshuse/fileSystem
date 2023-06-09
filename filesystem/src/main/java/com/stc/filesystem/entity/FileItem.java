package com.stc.filesystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the file_item database table.
 * 
 */
@Entity
@Table(name="file_item")
@NamedQuery(name="FileItem.findAll", query="SELECT f FROM FileItem f")
public class FileItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="file_text")
	private byte[] fileText;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	public FileItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getFileText() {
		return this.fileText;
	}

	public void setFileText(byte[] fileText) {
		this.fileText = fileText;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}