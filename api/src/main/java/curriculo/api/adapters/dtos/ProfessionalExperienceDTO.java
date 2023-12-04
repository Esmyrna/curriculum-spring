package curriculo.api.adapters.dtos;

import java.util.List;

public record ProfessionalExperienceDTO(String company, List<String> skillsCompany, int companyTime) {
}
