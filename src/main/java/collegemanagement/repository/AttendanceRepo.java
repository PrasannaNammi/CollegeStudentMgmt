package collegemanagement.repository;

import collegemanagement.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepo  extends JpaRepository<Attendance, Integer> {

     //Attendance per Subject
     @Query("from Attendance where studentId=:studentId and semesterId=:semesterId and subjectId=:subjectId")
    Optional<Attendance> subjectwise(int studentId, int semesterId, int subjectId);
    @Query("from Attendance where studentId=:studentId and semesterId=:semesterId ")
    List<Attendance> semesterwise(int studentId, int semesterId);
}
