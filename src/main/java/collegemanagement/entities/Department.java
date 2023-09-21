package collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String name;

    private double fee;
    private int hod;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="hod", referencedColumnName = "facultyId",insertable = false, updatable = false)
    private Faculty faculty;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Department() {
    }

    public Department(int departmentId, String name, double fee, int hod) {
        this.departmentId = departmentId;
        this.name = name;
        this.fee = fee;
        this.hod = hod;
    }

    public int getHod() {
        return hod;
    }

    public void setHod(int hod) {
        this.hod = hod;
    }
}
