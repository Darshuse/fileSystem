package com.stc.filesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.filesystem.entity.FileItem;
import com.stc.filesystem.repository.FileItemRepository;

@Service
public class FileItemServiceImple implements FileItemService {

	@Autowired
	FileItemRepository fileRepo;

	@Override
	public List<FileItem> findAll() {
		return fileRepo.findAll();
	}

	@Override
	public FileItem findById(int id) {
		// TODO Auto-generated method stub
		return fileRepo.findById(id).get();
	}


	@Override
	public FileItem save(FileItem file) {
		// TODO Auto-generated method stub
	    return  fileRepo.save(file);
	}

}
