package curriculo.api.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "professional_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessionalExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    @ElementCollection
    private List<String> skillsCompany;
    private int companyTime;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getSkillsCompany() {
        return skillsCompany;
    }

    public void setSkillsCompany(List<String> skillsCompany) {
        this.skillsCompany = skillsCompany;
    }

    public int getCompanyTime() {
        return companyTime;
    }

    public void setCompanyTime(int companyTime) {
        this.companyTime = companyTime;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
