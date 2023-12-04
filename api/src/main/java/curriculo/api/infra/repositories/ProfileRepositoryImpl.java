package curriculo.api.infra.repositories;

import curriculo.api.adapters.dtos.repositories.ProfileRepository;
import curriculo.api.domain.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepositoryImpl extends JpaRepository<Profile, Long>, ProfileRepository {
}
