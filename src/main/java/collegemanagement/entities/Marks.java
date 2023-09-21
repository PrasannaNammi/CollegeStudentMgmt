package collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int  marksId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "studentId", referencedColumnName = "studentId",insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="semesterId", referencedColumnName = "semesterId",insertable = false, updatable = false)
    private  Semester semester;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="subjectId", referencedColumnName = "subjectId",insertable = false, updatable = false)
    private  Subjects subject;

    private String examType;

    private int studentId;
    private int semesterId;
    private int subjectId;
    private  double marksObtained;

    public int getMarksId() {
        return marksId;
    }

    public void setMarksId(int marksId) {
        this.marksId = marksId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Marks(int marksId, String examType, int studentId, int semesterId, int subjectId, double marksObtained) {
        this.marksId = marksId;
        this.examType = examType;
        this.studentId = studentId;
        this.semesterId = semesterId;
        this.subjectId = subjectId;
        this.marksObtained = marksObtained;
    }

    public Marks() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
