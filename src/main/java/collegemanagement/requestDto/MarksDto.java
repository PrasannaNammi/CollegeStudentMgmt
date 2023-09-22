package collegemanagement.requestDto;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MarksDto {

    private int marksId;
    private int studentId;
    private int semesterId;
    private int subjectId;
    private String examType;
    private  double marksObtained;

    public void setMarksId(int marksId) {
        this.marksId = marksId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }
}
