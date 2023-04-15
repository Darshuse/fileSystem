package com.stc.filesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stc.filesystem.entity.FileItem;

@Repository
@Transactional
public interface FileItemRepository extends JpaRepository<FileItem, Integer> {

}
