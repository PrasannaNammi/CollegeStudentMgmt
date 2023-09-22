package collegemanagement.controllers;

import collegemanagement.requestDto.SubjectDto;
import collegemanagement.responseDto.ApiResponse;
import collegemanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("BySemester")
    public ResponseEntity<ApiResponse<List<SubjectDto>>> subjects(@RequestParam() int semesterId){
        return new ResponseEntity<>(new ApiResponse<>(subjectService.subsBySem(semesterId)), HttpStatus.OK);
    }

    @PutMapping("updateSemfee")
    public ResponseEntity<ApiResponse<SubjectDto>> updateName(@RequestParam int id, @RequestParam String name){
        return new ResponseEntity<>(new ApiResponse<>(subjectService.update(id,name)),HttpStatus.OK);
    }

}
