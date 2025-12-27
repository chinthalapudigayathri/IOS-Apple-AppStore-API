package com.gayathri.projects.repository;

import com.gayathri.projects.model.IOSAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOSAppRepository extends JpaRepository<IOSAppEntity,Long>
{
    Optional<IOSAppEntity> findByAppStoreId(Long appStoreId);
}