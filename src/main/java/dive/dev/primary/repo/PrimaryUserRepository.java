package dive.dev.primary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dive.dev.primary.models.PrimaryUserDetail;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PrimaryUserRepository extends JpaRepository<PrimaryUserDetail, UUID>, JpaSpecificationExecutor<PrimaryUserDetail> {
}
