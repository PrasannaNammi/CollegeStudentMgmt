package collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.mapping.DependantBasicValue;

import java.time.LocalDate;

@Entity
@Table(name="faculty")
public class Faculty
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int  facultyId;
    private String name;

    @Column
    private String contactInfo;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String isActive;
    private int departmentId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId",insertable = false, updatable = false)
    private Department department;


    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Faculty(int facultyId, String name, String contactInfo, LocalDate createdAt, LocalDate updatedAt, String isActive, int departmentId) {
        this.facultyId = facultyId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
        this.departmentId = departmentId;
    }

    public Faculty() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
