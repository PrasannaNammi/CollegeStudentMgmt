package collegemanagement.service;


import collegemanagement.entities.Marks;
import collegemanagement.entities.Semester;
import collegemanagement.entities.Subjects;
import collegemanagement.repository.SemesterRepo;
import collegemanagement.repository.SubjectRepo;
import collegemanagement.requestDto.MarksDto;
import collegemanagement.requestDto.SubjectDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private SemesterRepo semesterRepo;

    private final ModelMapper modelMapper;

    public SubjectDto convertEntityToDto(Subjects subjects){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(subjects, SubjectDto.class);
    }

    // DTO to Entity Converter
    public Subjects convertDtoToEntity(SubjectDto subjectDto){

        return modelMapper.map(subjectDto, Subjects.class);
    }

    //Subjects by Semester
    public List<SubjectDto> subsBySem(int semesterId){
        if(semesterRepo.existsById(semesterId)){
            return subjectRepo.getSubjectsById(semesterId).stream()
                    .map(this::convertEntityToDto)
                    .toList();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public SubjectDto update(int id, String name){
        Optional<Subjects> s = subjectRepo.findById(id);
        if(s.isPresent()){
            Subjects subjects = s.get();
            subjects.setName(name);
            subjectRepo.save(subjects);
            return convertEntityToDto(subjects);
        }
        throw new NoSuchElementException();
    }




}
