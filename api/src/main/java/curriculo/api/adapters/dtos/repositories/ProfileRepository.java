package curriculo.api.adapters.dtos.repositories;

import curriculo.api.domain.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    List<Profile> findAll();
    Profile save(Profile profile);
    Optional<Profile> findById(Long id);
    void delete(Profile profile);
}
