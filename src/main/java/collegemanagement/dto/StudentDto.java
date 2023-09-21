package collegemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDto {

    private int  studentId;

    private String name;
    private LocalDate dob;

    private String contactInfo;
    private String isActive;
    private int departmentId;
}
