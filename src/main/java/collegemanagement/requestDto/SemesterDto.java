package collegemanagement.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterDto {

    private int  semesterId;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private double semFee;

}
