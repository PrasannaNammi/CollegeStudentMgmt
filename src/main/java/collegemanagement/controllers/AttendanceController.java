package collegemanagement.controllers;

import collegemanagement.requestDto.ApiResponse;
import collegemanagement.requestDto.AttendanceDto;
import collegemanagement.service.AttendanceService;
import collegemanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<AttendanceDto>>> getAttendance(){
         return new ResponseEntity<>(new ApiResponse<>(attendanceService.getAllAttendance()),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AttendanceDto>> createAttendance(@RequestBody AttendanceDto attendance){
        return new ResponseEntity<>(new ApiResponse<>(attendanceService.addAttendance(attendance)), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public  ResponseEntity<ApiResponse<String>> deleteAttendance(@RequestParam int id){
        if(attendanceService.delete(id))
            return  new ResponseEntity<>(new ApiResponse<>("Deleted successfully"),HttpStatus.OK);
        return new ResponseEntity<>(new ApiResponse<>("Could not find Attendance with the given ID"),HttpStatus.OK);
    }

    @GetMapping("/SubjectWise")
    public ResponseEntity<ApiResponse<Double>> getAllAtt(@RequestParam int studentId,@RequestParam int semesterId,@RequestParam int subjectId){
            return new ResponseEntity<>(new ApiResponse<>(attendanceService.attendancebyAll(studentId,semesterId,subjectId)), HttpStatus.OK);
    }

    @GetMapping("/SemesterWise")
    public ResponseEntity<ApiResponse<Double>> semAttendance(@RequestParam int studentId,@RequestParam int semesterId){
            return new ResponseEntity<>(new ApiResponse<>(attendanceService.semAttendance(studentId,semesterId)), HttpStatus.OK);

    }

    @PutMapping("update/attendedClasses")
    public ResponseEntity<ApiResponse<AttendanceDto>> update(@RequestParam int id, @RequestParam int attendedClasses){
        return new ResponseEntity<>(new ApiResponse<>(attendanceService.update(id,attendedClasses)),HttpStatus.NO_CONTENT);
    }


}
