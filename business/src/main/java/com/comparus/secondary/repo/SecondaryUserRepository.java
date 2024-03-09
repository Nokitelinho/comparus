package com.comparus.secondary.repo;

import com.comparus.secondary.models.SecondaryUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SecondaryUserRepository extends JpaRepository<SecondaryUserDetail, UUID>, JpaSpecificationExecutor<SecondaryUserDetail> {
}
