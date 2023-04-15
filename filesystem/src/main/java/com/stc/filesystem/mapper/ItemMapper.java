package com.stc.filesystem.mapper;

import com.stc.filesystem.dto.ItemInRsDTO;
import com.stc.filesystem.dto.ItemPermissionGroupRsDto;
import com.stc.filesystem.entity.Item;
import com.stc.filesystem.entity.ItemPermissionGroup;

public class ItemMapper {

	public static Item getItemDto(ItemInRsDTO inDto) {
		Item item = new Item();
		ItemPermissionGroup permissionGroup = getPermissionGroupDto(inDto.getPermissionGroup());
		item.setItemName(inDto.getItemName());
		item.setItemPermissionGroup(permissionGroup);
		item.setId(inDto.getId());
        item.setItemType_id(inDto.getItemType());
        item.setParent_id(inDto.getParent_id());
        return item;
	}

	public static ItemPermissionGroup getPermissionGroupDto(ItemPermissionGroupRsDto inDto) {
		ItemPermissionGroup permissionGroup = new ItemPermissionGroup();
		permissionGroup.setGroupName(inDto.getGroupName());
		permissionGroup.setId(inDto.getId());
		return permissionGroup;
	}
}
