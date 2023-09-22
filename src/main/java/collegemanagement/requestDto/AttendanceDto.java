package collegemanagement.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttendanceDto {

    private int attendanceId;
    private int totalClasses;
    private int attendedClasses;
    private int studentId;
    private int subjectId;
    private int semesterId;

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
