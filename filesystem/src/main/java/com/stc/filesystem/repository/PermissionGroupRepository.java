package com.stc.filesystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stc.filesystem.entity.PermissionGroup;


@Repository
@Transactional
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Integer>{

	Optional<PermissionGroup>  findByUserEmail(String userEmail);
}
