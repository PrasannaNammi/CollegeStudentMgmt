package collegemanagement.requestDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {

    private int  facultyId;
    private String name;

    @Column
    private String contactInfo;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String isActive;
    private int departmentId;




    }

