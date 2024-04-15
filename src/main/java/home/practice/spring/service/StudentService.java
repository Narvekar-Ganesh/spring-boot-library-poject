package home.practice.spring.service;

import home.practice.spring.domain.Student;
import home.practice.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id){
        Student student = null;
        try{
            student = studentRepository.getById(id);
        }catch(Exception entityNotFoundException){
            student = null;
        }
        System.out.println("StudentService.getStudentById - student from database : " + student);

        return student;
    }

    public  Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
