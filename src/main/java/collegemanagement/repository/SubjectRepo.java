package collegemanagement.repository;

import collegemanagement.entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subjects,Integer> {
}
