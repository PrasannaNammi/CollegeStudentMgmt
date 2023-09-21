package collegemanagement.repository;

import collegemanagement.entities.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarksRepo extends JpaRepository<Marks,Integer> {


    @Query("from Marks where studentId=:id")
    public List<Marks> getMarksByStudent(@Param("id") int id);

    @Query("from Marks where studentId=:studentId and semesterId =:semesterId ")
    public List<Marks> marksheet(@Param("studentId") int studentId, @Param("semesterId") int semesterId);

    @Query("select Sum(marksObtained)*100/Cast(600 as Float) from Marks where studentId=:studentId and semesterId=:semesterId")
    public double findGrade(@Param("studentId") int studentId, @Param("semesterId") int semesterId);


}
