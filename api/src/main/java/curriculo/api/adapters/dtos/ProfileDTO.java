package curriculo.api.adapters.dtos;

import curriculo.api.domain.entities.AcademicExperience;
import curriculo.api.domain.entities.ProfessionalExperience;

import java.util.List;

public record ProfileDTO(String name, int age, String email, String city, List<AcademicExperienceDTO> academicExperience,
                         List<ProfessionalExperienceDTO> professionalExperience) {
}
