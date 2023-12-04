package curriculo.api.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    private String city;
    @JsonManagedReference
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AcademicExperience> academicExperience;
    @JsonManagedReference
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProfessionalExperience> professionalExperience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<AcademicExperience> getAcademicExperience() {
        return academicExperience;
    }

    public void setAcademicExperience(List<AcademicExperience> academicExperience) {
        academicExperience.forEach(experience -> experience.setProfile(this));
        this.academicExperience = academicExperience;
    }

    public List<ProfessionalExperience> getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(List<ProfessionalExperience> professionalExperience) {
        professionalExperience.forEach(experience -> experience.setProfile(this));
        this.professionalExperience = professionalExperience;
    }
}
