package collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int subjectId;
    private String name;
    private int facultyId;
    private int semesterId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "facultyId", referencedColumnName = "facultyId",insertable = false, updatable = false)
    private Faculty faculty;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="semesterId", referencedColumnName = "semesterId",insertable = false, updatable = false)
    private  Semester semester;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Subjects(int subjectId, String name, int facultyId, int semesterId) {
        this.subjectId = subjectId;
        this.name = name;
        this.facultyId = facultyId;
        this.semesterId = semesterId;
    }

    public Subjects() {
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
