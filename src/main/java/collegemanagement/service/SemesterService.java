package collegemanagement.service;

import collegemanagement.entities.Marks;
import collegemanagement.entities.Semester;
import collegemanagement.repository.SemesterRepo;
import collegemanagement.repository.StudentRepo;
import collegemanagement.requestDto.MarksDto;
import collegemanagement.requestDto.SemesterDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SemesterService {

    @Autowired
    private SemesterRepo semesterRepo;

    private final ModelMapper modelMapper;

    // Entity to DTO converter
    public SemesterDto convertEntityToDto(Semester semester){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(semester, SemesterDto.class);
    }

    // DTO to Entity Converter
    public Semester convertDtoToEntity(SemesterDto semesterDto){
        return modelMapper.map(semesterDto, Semester.class);
    }



}
