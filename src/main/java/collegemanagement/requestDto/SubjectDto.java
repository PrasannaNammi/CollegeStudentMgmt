package collegemanagement.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class SubjectDto {


    private int subjectId;
    private String name;
    private int facultyId;
    private int semesterId;

}
