package collegemanagement.repository;

import collegemanagement.entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subjects,Integer> {

    @Query("from Subjects where semesterId=:semesterId")
    public List<Subjects> getSubjectsById(@Param("semesterId") int semesterId);
}
