package collegemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int  attendanceId;

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

    private int totalClasses;
    private int attendedClasses;
    private int studentId;
    private int semesterId;
    private int subjectId;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
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

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
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

    public Attendance(int totalClasses, int attendedClasses, int studentId, int semesterId, int subjectId) {

        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
        this.studentId = studentId;
        this.semesterId = semesterId;
        this.subjectId = subjectId;
    }

    public Attendance() {
    }
}
