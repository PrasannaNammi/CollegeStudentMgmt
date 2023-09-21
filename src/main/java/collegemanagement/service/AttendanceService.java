package collegemanagement.service;

import collegemanagement.customexceptions.IdNotFoundException;
import collegemanagement.customexceptions.NoSuchCombinationException;
import collegemanagement.dto.AttendanceDto;
import collegemanagement.entities.Attendance;
import collegemanagement.entities.Student;
import collegemanagement.repository.AttendanceRepo;
import collegemanagement.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private final ModelMapper modelMapper;


    // Entity to DTO converter
    public AttendanceDto convertEntityToDto(Attendance attendance){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(attendance, AttendanceDto.class);
    }

    // DTO to Entity Converter
    public Attendance convertDtoToEntity(AttendanceDto attendanceDto){
        return modelMapper.map(attendanceDto, Attendance.class);
    }

    //All Attendance by ID
    public AttendanceDto findAttendanceById(int id){
        Optional<Attendance> studentAttendance  = attendanceRepo.findById(id);
        if(studentAttendance.isPresent()){
            Attendance attendance = studentAttendance.get();
            return convertEntityToDto(attendance);
        }
        throw new IdNotFoundException("No Attendance with the given ID");
    }

    public List<AttendanceDto> getAllAttendance(){

        return attendanceRepo.findAll().stream()
                .map(this::convertEntityToDto)
                .toList();
    }
    // Adding a new Attendance
    public AttendanceDto addAttendance(AttendanceDto attendanceDto){

        Integer studentId = attendanceDto.getStudentId();
        Student student = studentRepo.findById(studentId)
                .orElseThrow(()-> new IdNotFoundException("No Student found with the given id!"));

        if(attendanceRepo.existsById(attendanceDto.getAttendanceId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Attendance already present!" );
        }
        Attendance attendance = convertDtoToEntity(attendanceDto);
        attendanceRepo.save(attendance);
        return attendanceDto;
    }


    //Updating Attended classes by id
    public AttendanceDto update(int id,int attended_classes){
        Optional<Attendance> updateAttendance = attendanceRepo.findById(id);
        if(updateAttendance.isPresent()){
            Attendance attendance = updateAttendance.get();
            attendance.setAttendedClasses(attended_classes);
            attendanceRepo.save(attendance);
            return convertEntityToDto(attendance);
        }
        throw new NoSuchElementException();
    }

    //Deleting an Attendance

    public boolean delete(int id){
        Optional<Attendance> deleteAttendance = attendanceRepo.findById(id);

        if(deleteAttendance.isEmpty())
        {
            return false;
        }
        Attendance attendance = deleteAttendance.get();
        attendanceRepo.delete(attendance);
        return true;
    }

    public Double attendancebyAll(int studentId, int semesterId, int subjectId){

        Optional<Double> value =  attendanceRepo.attBydetails( studentId, semesterId,  subjectId);
        if(value.isPresent()){
            return value.get();
        }
        throw new NoSuchCombinationException();

    }

    public Double semAttendance(int studentId, int semesterId){

        Optional<Double> value =  attendanceRepo.semAttendance(studentId,semesterId);
        if(value.isPresent()){
            return value.get();
        }
        throw new NoSuchCombinationException();
    }



}


