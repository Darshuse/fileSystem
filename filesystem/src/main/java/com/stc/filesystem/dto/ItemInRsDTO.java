package com.stc.filesystem.dto;

import java.io.Serializable;

public class ItemInRsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String itemName;
	private ItemPermissionGroupRsDto permissionGroup;
	private Integer itemType;
	private String user_email;
	private Integer parent_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemPermissionGroupRsDto getPermissionGroup() {
		return permissionGroup;
	}

	public void setPermissionGroup(ItemPermissionGroupRsDto permissionGroup) {
		this.permissionGroup = permissionGroup;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

}
