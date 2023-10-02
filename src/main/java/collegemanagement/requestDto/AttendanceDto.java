package collegemanagement.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttendanceDto {


    private int totalClasses;
    private int attendedClasses;
    private int studentId;
    private int subjectId;
    private int semesterId;


}
