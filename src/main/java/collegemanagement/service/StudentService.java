package collegemanagement.service;

import collegemanagement.requestDto.StudentDto;
import collegemanagement.entities.Student;
import collegemanagement.repository.DepartmentRepo;
import collegemanagement.repository.SemesterRepo;
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
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private SemesterRepo semesterRepo;
    @Autowired
    private AttendanceService attendanceService;
    private final ModelMapper modelMapper;

    // Entity to DTO
    public StudentDto convertEntityToDto(Student student){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(student,StudentDto.class);
    }
    public Student convertDtoToEntity(StudentDto studentDto){

        return modelMapper.map(studentDto, Student.class);
    }

    //Student by ID
    public StudentDto findStudentbyId(int id){
        Optional<Student> studentDetails = studentRepo.findById(id);
        if(studentDetails.isPresent()){
            Student student = studentDetails.get();
            return convertEntityToDto(student);
        }
        throw new NoSuchElementException();

    }
//condonation fee

    public double fee(int studentId, int semesterId){
        Optional<Student> s = studentRepo.findById(studentId);
        if(s.isPresent()){
            Student student = s.get();
            int dept = student.getDepartmentId();

           double total = departmentRepo.findById(dept).get().getFee();
           total+= semesterRepo.findById(semesterId).get().getSemFee();
           double percentage = attendanceService.calculateSemesterAttendancePercentage(studentId,semesterId);
           if(percentage>=80)
               return total;
           else if(percentage>=75)
               return total+ 1000;
           else
           return total + 5000;
        }
        throw new NoSuchElementException();
    }

    public boolean isPresent(int id){
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent())
            return true;
        return false;
    }

    public List<StudentDto> getAllStudents(){

        return studentRepo.findAll().stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    public StudentDto addStudent(StudentDto studentDto){

        Integer studentId = studentDto.getStudentId();
        if(studentRepo.existsById(studentId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student is already present!");
        Student student = convertDtoToEntity(studentDto);
        studentRepo.save(student);
        return studentDto;

    }

    public boolean delete(int id){
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.delete(student.get());
            return true;
        }
        return false;
    }



}
