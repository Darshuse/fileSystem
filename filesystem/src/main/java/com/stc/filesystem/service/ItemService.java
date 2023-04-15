package com.stc.filesystem.service;

import java.util.List;
import java.util.Optional;

import com.stc.filesystem.entity.Item;

public interface ItemService {

	public List<Item> findAll();

	public Optional<Item> findById(int id);

	public Optional<Item> update(Item item);

	public Item save(Item item,String user_email);

}
