package home.practice.spring.service;

import home.practice.spring.domain.Student;
import home.practice.spring.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        Student student = null;
        try {
            student = studentRepository.getById(id);
        } catch (Exception entityNotFoundException) {
            student = null;
        }
        System.out.println("StudentService.getStudentById - student from database : " + student);
        LOGGER.info("Student form database:{}", student);
        return student;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findStudentByStudentName(String studentName) {
        return studentRepository.findByStudentName(studentName);
    }

    public List<Student> findStudentByStudentGender(String gender) {
        return studentRepository.findByGender(gender);
    }
}