package home.practice.spring.repository;

import home.practice.spring.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
        Student findByStudentName(String studentName);

        List<Student> findByGender(String gender);

}
