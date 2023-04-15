package com.stc.filesystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permission_groups database table.
 * 
 */
@Entity
@Table(name="permission_groups")
@NamedQuery(name="PermissionGroup.findAll", query="SELECT p FROM PermissionGroup p")
public class PermissionGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="permission_level")
	private String permissionLevel;

	@Column(name="user_email")
	private String userEmail;

	//bi-directional many-to-one association to ItemPermissionGroup
	@ManyToOne
	@JoinColumn(name="item_group_id")
	private ItemPermissionGroup itemPermissionGroup;

	public PermissionGroup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionLevel() {
		return this.permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ItemPermissionGroup getItemPermissionGroup() {
		return this.itemPermissionGroup;
	}

	public void setItemPermissionGroup(ItemPermissionGroup itemPermissionGroup) {
		this.itemPermissionGroup = itemPermissionGroup;
	}

}