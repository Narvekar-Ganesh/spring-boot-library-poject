package home.practice.spring;

import home.practice.spring.domain.Student;
import home.practice.spring.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "api/v1/student", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id") Long id) {
        LOGGER.info("id :{}", id);
        Student reponse = studentService.getStudentById(id);
        return reponse;
    }

    @RequestMapping(value = "api/v1/student/student-name", method = RequestMethod.GET)
    public Student findByStudentName(@RequestParam("student-name") String studentName) {
        LOGGER.info("student-name :{}", studentName);
        Student result = studentService.findStudentByStudentName(studentName);
        return result;
    }

    @RequestMapping(value = "api/v1/student/student-gender", method = RequestMethod.GET)
    public List<Student> findByStudentGender(@RequestParam("gender") String gender) {
        LOGGER.info("Gender :{}", gender);
        List<Student> result = studentService.findStudentByStudentGender(gender);
        return result;
    }

    @RequestMapping(value = "api/v1/student", method = RequestMethod.PUT)
    public @ResponseBody Student saveStudent(@RequestBody Student student) {
        LOGGER.info("Student:{}", student);
        Student response = studentService.saveStudent(student);
        LOGGER.info("Student is save :{}", response);
        return response;
    }

    @RequestMapping(value = "api/v1/student", method = RequestMethod.DELETE)
    public String deleteStudentById(@RequestParam("id") Long id) {
        studentService.deleteStudent(id);
        return "Student has been deleted";
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentController.class, args);
    }
}