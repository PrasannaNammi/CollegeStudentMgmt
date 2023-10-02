package collegemanagement.controllers;

import collegemanagement.requestDto.StudentDto;
import collegemanagement.responseDto.ApiResponse;
import collegemanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/fee")
    public ResponseEntity<ApiResponse<Double>> total_fee(@RequestParam int studentId, @RequestParam int semesterId){
        return new ResponseEntity<>(new ApiResponse<>(studentService.fee(studentId,semesterId)),HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse<StudentDto>> getStudentById(@RequestParam int studentId){
        return new ResponseEntity<>(new ApiResponse<>(studentService.findStudentbyId(studentId)), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<StudentDto>>> getStudents(){
        return new ResponseEntity<>(new ApiResponse<>(studentService.getAllStudents()),HttpStatus.OK);
    }

    @PostMapping("/newStudent")
    public ResponseEntity<ApiResponse<StudentDto>> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(new ApiResponse<>(studentService.addStudent(studentDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@RequestParam int id){
        if(studentService.delete(id))
            return  new ResponseEntity<>(new ApiResponse<>("Deleted successfully"),HttpStatus.OK);
        throw new NoSuchElementException();
    }

}
