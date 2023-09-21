package collegemanagement.dto;


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



}
