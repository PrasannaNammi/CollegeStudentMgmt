package collegemanagement.service;

import collegemanagement.requestDto.MarksDto;
import collegemanagement.entities.Marks;
import collegemanagement.entities.Student;
import collegemanagement.repository.MarksRepo;
import collegemanagement.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarksService {

    @Autowired
    private MarksRepo marksRepo;
    @Autowired
    private StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    // Entity to DTO converter
    public MarksDto convertEntityToDto(Marks marks){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(marks, MarksDto.class);
    }

    // DTO to Entity Converter
    public Marks convertDtoToEntity(MarksDto marksDto){

        return modelMapper.map(marksDto, Marks.class);
    }




    public List<MarksDto> getMarksByStudent(int id){
        if(studentRepo.existsById(id)){
            return marksRepo.getMarksByStudent(id).stream()
                    .map(this ::convertEntityToDto)
                    .toList();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    // Marklist of Student
    public List<MarksDto> marksheet(int studentId, int semesterId){
        if(studentRepo.existsById(studentId)){
            return marksRepo.marksheet(studentId,semesterId).stream()
                    .map(this ::convertEntityToDto)
                    .toList();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    //Finding the Grade of student
    public String grade(int studentId, int semesterId){
        if(studentRepo.existsById(studentId)){
            double perc = marksRepo.findGrade(studentId,semesterId);
            if(perc>=90)
                return "A grade";
            else if(perc>=80)
                return "B grade";
            else if(perc>=70)
                return "C grade";
            else if (perc>=60)
                return "D grade";
            else if(perc>=50)
                return "E grade";
            else if (perc>40)
                return "F grade";
            else
                return "Failed !!!";
        }
        else{
            throw new NoSuchElementException();
        }
    }

    //Creating marks list
    public MarksDto addMarks(MarksDto marks){
        Integer studentId = marks.getStudentId();
        Student student = studentRepo.findById(studentId)
                .orElseThrow(NoSuchElementException::new);

        if(marksRepo.existsById(marks.getMarksId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Marks already present!" );
        }
        marksRepo.save(convertDtoToEntity(marks));
        return marks;
    }

    //Updating Marks


    //Deleting
    public boolean delete(int id){
        Optional<Marks> deleteMarks = marksRepo.findById(id);
        if(deleteMarks.isEmpty())
        {
            return false;
        }
        Marks marks = deleteMarks.get();
        marksRepo.delete(marks);
        return true;
    }




}
