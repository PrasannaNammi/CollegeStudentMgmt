package collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int  studentId;

    private String name;
    private LocalDate dob;

    private String contactInfo;
    private String isActive;
    private int departmentId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId",insertable = false, updatable = false)
    private Department department;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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

    public Student(int studentId, String name, LocalDate dob, String contactInfo, String isactive, int departmentId) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.contactInfo = contactInfo;
        this.isActive = isactive;
        this.departmentId = departmentId;
    }

    public Student() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
