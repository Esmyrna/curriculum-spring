package curriculo.api.application.services;

import curriculo.api.adapters.dtos.ProfileDTO;
import curriculo.api.adapters.dtos.repositories.ProfileRepository;
import curriculo.api.domain.entities.AcademicExperience;
import curriculo.api.domain.entities.ProfessionalExperience;
import curriculo.api.domain.entities.Profile;
import curriculo.api.domain.entities.usecases.ProfileCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileCase {
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setName(profileDTO.name());
        profile.setAge(profileDTO.age());
        profile.setCity(profileDTO.city());
        profile.setEmail(profileDTO.email());
        List<AcademicExperience> academicExperiences = new ArrayList<>();

        profileDTO.academicExperience().forEach(academicExperienceDto -> {
            AcademicExperience academicExperience = new AcademicExperience();

            academicExperience.setHighSchool(academicExperienceDto.highSchool());
            academicExperience.setUniversity(academicExperienceDto.university());
            academicExperience.setUniversityCompletion(academicExperienceDto.universityCompletion());
            academicExperience.setHighSchoolCompletion(academicExperienceDto.highSchoolCompletion());

            academicExperiences.add(academicExperience);
        });
        profile.setAcademicExperience(academicExperiences);

        List<ProfessionalExperience> professionalExperiences = new ArrayList<>();

        profileDTO.professionalExperience().forEach(professionalExperienceDto -> {
            ProfessionalExperience professionalExperience = new ProfessionalExperience();

            professionalExperience.setCompany(professionalExperienceDto.company());
            professionalExperience.setCompanyTime(professionalExperienceDto.companyTime());
            professionalExperience.setSkillsCompany(professionalExperienceDto.skillsCompany());

            professionalExperiences.add(professionalExperience);
        });
        profile.setProfessionalExperience(professionalExperiences);

        return profileRepository.save(profile);
    }

    @Override
    public Optional<Profile> getByIdProfile(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public Profile updateProfile(Long id, ProfileDTO profileDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);

        if (optionalProfile.isPresent()) {
            Profile existingProfile = optionalProfile.get();
            existingProfile.setName(profileDTO.name());
            existingProfile.setAge(profileDTO.age());
            existingProfile.setCity(profileDTO.city());
            existingProfile.setEmail(profileDTO.email());

            List<AcademicExperience> academicExperiences = new ArrayList<>();
            profileDTO.academicExperience().forEach(academicExperienceDto -> {
                AcademicExperience academicExperience = new AcademicExperience();
                academicExperience.setHighSchool(academicExperienceDto.highSchool());
                academicExperience.setUniversity(academicExperienceDto.university());
                academicExperience.setUniversityCompletion(academicExperienceDto.universityCompletion());
                academicExperience.setHighSchoolCompletion(academicExperienceDto.highSchoolCompletion());
                academicExperience.setProfile(existingProfile); // Importante definir o perfil associado
                academicExperiences.add(academicExperience);
            });
            existingProfile.setAcademicExperience(academicExperiences);

            List<ProfessionalExperience> professionalExperiences = new ArrayList<>();
            profileDTO.professionalExperience().forEach(professionalExperienceDto -> {
                ProfessionalExperience professionalExperience = new ProfessionalExperience();
                professionalExperience.setCompany(professionalExperienceDto.company());
                professionalExperience.setCompanyTime(professionalExperienceDto.companyTime());
                professionalExperience.setSkillsCompany(professionalExperienceDto.skillsCompany());
                professionalExperience.setProfile(existingProfile); // Importante definir o perfil associado
                professionalExperiences.add(professionalExperience);
            });
            existingProfile.setProfessionalExperience(professionalExperiences);

            return profileRepository.save(existingProfile);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProfile(Long id) {
        Optional<Profile> existingProfile = profileRepository.findById(id);
        Profile existingTask = existingProfile.get();
        profileRepository.delete(existingTask);
    }
}
