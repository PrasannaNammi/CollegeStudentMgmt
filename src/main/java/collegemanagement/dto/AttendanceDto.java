package collegemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttendanceDto {


    private int attendanceId;

    private int totalClasses;
    private int attendedClasses;
    private int studentId;
    private int subjectId;
    private int semesterId;
}
