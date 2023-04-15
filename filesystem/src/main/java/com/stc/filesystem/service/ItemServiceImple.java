package com.stc.filesystem.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.filesystem.constant.Constants;
import com.stc.filesystem.entity.FileItem;
import com.stc.filesystem.entity.Item;
import com.stc.filesystem.entity.PermissionGroup;
import com.stc.filesystem.repository.FileItemRepository;
import com.stc.filesystem.repository.ItemRepository;
import com.stc.filesystem.repository.PermissionGroupRepository;

@Service
public class ItemServiceImple implements ItemService {

	@Autowired
	ItemRepository repo;

	@Autowired
	PermissionGroupRepository permissionRepo;

	@Autowired
	FileItemRepository filerepo;

	@Override
	public Optional<Item> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Item save(Item item, String user_email) {

		boolean validationBoolean = validate(item, user_email);

		if (validationBoolean) {
			Item savedItem = repo.save(item);
			if (savedItem.getItemType_id() == Constants.ItemType.FILE.getValue()) {
				FileItem fileItem = new FileItem();
				byte[] binaryData = getFileArrayOfBytes(savedItem.getItemName());
				fileItem.setItem(savedItem);
				fileItem.setFileText(binaryData);
				fileItem.setId(10);
				filerepo.save(fileItem);
			}
			return savedItem;
			// check after save
		}
		return null;
	}

	// user_email here belong to parent to check user accessibility on parent
	public boolean validate(Item item, String email) {

		Item parent = findById(item.getParent_id()).orElse(null);
		PermissionGroup permissionGroup = permissionRepo.findByUserEmail(email).get();
		if (item.getParent_id() == null && item.getItemType_id() != Constants.ItemType.SPACE.getValue()) {
			// throw exception with retirn false
			return false;
		}

		if (item.getItemType_id() == Constants.ItemType.SPACE.getValue() && item.getParent_id() != null) {
			return false;
		}

		// case that file can not hold folder
		if (item.getItemType_id() == Constants.ItemType.FOLDER.getValue()
				&& parent.getItemType_id() == Constants.ItemType.FILE.getValue()) {
			return false;
		}
		if (item.getItemType_id() == Constants.ItemType.FOLDER.getValue()
				&& permissionGroup.getPermissionLevel().equals(Constants.PermissionLevel.VIEW.getValue())) {
			return false;
		}

		if (item.getItemType_id() == Constants.ItemType.FILE.getValue()
				&& permissionGroup.getPermissionLevel().equals(Constants.PermissionLevel.VIEW.getValue())) {
			return false;
		}

		return true;
	}

	public byte[] getFileArrayOfBytes(String fileName) {
		byte[] bytes = null;
		String dataForWriting = "Hi there we are testing create file ";
		File file = new File(fileName);
		try {
			boolean value = file.createNewFile();
			if (value) {
				Files.write(file.toPath(), dataForWriting.getBytes());
				bytes = Files.readAllBytes(file.toPath());
				return bytes;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	@Override
	public List<Item> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Item> update(Item item) {
		return Optional.empty();
	}

}
