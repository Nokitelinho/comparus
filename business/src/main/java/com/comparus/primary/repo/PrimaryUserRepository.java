package com.comparus.primary.repo;

import com.comparus.primary.models.PrimaryUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PrimaryUserRepository extends JpaRepository<PrimaryUserDetail, UUID>, JpaSpecificationExecutor<PrimaryUserDetail> {
}
