package com.stc.filesystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "item_name")
	private String itemName;

	// bi-directional many-to-one association to ItemPermissionGroup
	@ManyToOne
	@JoinColumn(name = "permission_group_id")
	private ItemPermissionGroup itemPermissionGroup;

	private Integer itemType_id;

	private Integer parent_id;

	public Item() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemPermissionGroup getItemPermissionGroup() {
		return this.itemPermissionGroup;
	}

	public void setItemPermissionGroup(ItemPermissionGroup itemPermissionGroup) {
		this.itemPermissionGroup = itemPermissionGroup;
	}

	public Integer getItemType_id() {
		return itemType_id;
	}

	public void setItemType_id(Integer itemType_id) {
		this.itemType_id = itemType_id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	
}