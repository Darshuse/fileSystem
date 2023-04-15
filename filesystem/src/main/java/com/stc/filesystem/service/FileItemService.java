package com.stc.filesystem.service;

import java.util.List;

import com.stc.filesystem.entity.FileItem;

public interface FileItemService {

	public List<FileItem> findAll();

	public FileItem findById(int id);

	public FileItem save(FileItem file);

}
