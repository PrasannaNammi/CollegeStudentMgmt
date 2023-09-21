package collegemanagement.repository;

import collegemanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<Student , Integer> {


}
