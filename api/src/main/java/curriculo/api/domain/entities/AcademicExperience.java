package curriculo.api.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "academic_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AcademicExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String highSchool;
    private int highSchoolCompletion;
    private String university;
    private int universityCompletion;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public int getHighSchoolCompletion() {
        return highSchoolCompletion;
    }

    public void setHighSchoolCompletion(int highSchoolCompletion) {
        this.highSchoolCompletion = highSchoolCompletion;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getUniversityCompletion() {
        return universityCompletion;
    }

    public void setUniversityCompletion(int universityCompletion) {
        this.universityCompletion = universityCompletion;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
