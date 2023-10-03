package collegemanagement.controllers;

import collegemanagement.requestDto.MarksDto;
import collegemanagement.responseDto.ApiResponse;
import collegemanagement.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping("/ByStudent")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<ApiResponse<List<MarksDto>>> getByStudent(@RequestParam() int id) {
        return new ResponseEntity<>(new ApiResponse<>(marksService.getMarksByStudent(id)), HttpStatus.OK);
    }

    @GetMapping("/BySemester")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<ApiResponse<List<MarksDto>>> marksheet(@RequestParam() int studentId, @RequestParam() int semesterId) {
        return new ResponseEntity<>(new ApiResponse<>(marksService.marksheet(studentId, semesterId)), HttpStatus.OK);
    }

    @GetMapping("/GPA/grade")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<ApiResponse<String>> grade(@RequestParam() int studentId, @RequestParam() int semesterId) {
        return new ResponseEntity<>(new ApiResponse<>(marksService.grade(studentId, semesterId)), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_FACULTY')")
    public ResponseEntity<ApiResponse<MarksDto>> addMarks(@RequestBody MarksDto marksDto) {
        return new ResponseEntity<>(new ApiResponse<>(marksService.addMarks(marksDto)), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_FACULTY')")
    public ResponseEntity<ApiResponse<String>> deleteMarks(@RequestParam int id) {
        if (marksService.delete(id))
            return new ResponseEntity<>(new ApiResponse<>("Deleted successfully"), HttpStatus.OK);
        throw new NoSuchElementException();
    }


}
