package collegemanagement.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int  semesterId;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private double semFee;

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getSemFee() {
        return semFee;
    }

    public void setSemFee(double semFee) {
        this.semFee = semFee;
    }
}
