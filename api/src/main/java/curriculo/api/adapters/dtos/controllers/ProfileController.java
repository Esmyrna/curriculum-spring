package curriculo.api.adapters.dtos.controllers;

import curriculo.api.adapters.dtos.ProfileDTO;
import curriculo.api.application.services.ProfileServiceImpl;
import curriculo.api.domain.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileServiceImpl profileService;

    @Autowired
    public ProfileController(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return profiles;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileService.getByIdProfile(id);
        return profile.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDTO profileDTO) {
        Profile createdProfile = profileService.createProfile(profileDTO);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        Profile updatedProfile = profileService.updateProfile(id, profileDTO);
        if (updatedProfile != null) {
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
