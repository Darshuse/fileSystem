package com.stc.filesystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_permission_groups database table.
 * 
 */
@Entity
@Table(name="item_permission_groups")
@NamedQuery(name="ItemPermissionGroup.findAll", query="SELECT i FROM ItemPermissionGroup i")
public class ItemPermissionGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="group_name")
	private String groupName;

	public ItemPermissionGroup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}