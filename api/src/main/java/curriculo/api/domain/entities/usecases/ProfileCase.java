package curriculo.api.domain.entities.usecases;

import curriculo.api.adapters.dtos.ProfileDTO;
import curriculo.api.domain.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileCase {
    List<Profile> getAllProfiles();
    Profile createProfile(ProfileDTO profileDTO);
    Optional<Profile> getByIdProfile(Long id);
    Profile updateProfile(Long id, ProfileDTO profileDTO);
    void deleteProfile(Long id);
}
