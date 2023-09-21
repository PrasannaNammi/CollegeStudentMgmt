package collegemanagement.repository;

import collegemanagement.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AttendanceRepo  extends JpaRepository<Attendance, Integer> {

    // Attendance per Subject
    @Query("select attendedClasses*100/Cast(totalClasses as Float) from Attendance where studentId=:studentId and semesterId=:semesterId and subjectId=:subjectId")
    public Optional<Double> attBydetails(@Param("studentId") int studentId, @Param("semesterId") int semesterId, @Param("subjectId") int subjectId);

    //Attendance per Semester
    @Query("select Sum(attendedClasses)*100/Cast(Sum(totalClasses) as Float) from Attendance where studentId=:studentId and semesterId=:semesterId " +
            "group by studentId, semesterId")
    public Optional<Double> semAttendance(@Param("studentId") int studentId,@Param("semesterId") int semesterId);


}
