package collegemanagement.repository;

import collegemanagement.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepo extends JpaRepository<Semester,Integer> {
}
