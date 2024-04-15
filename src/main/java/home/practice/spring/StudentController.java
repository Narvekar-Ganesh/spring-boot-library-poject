package home.practice.spring;

import home.practice.spring.domain.Student;
import home.practice.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "api/v1/student" , method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id")Long id){
        System.out.println("StudentController.getStudentById -id :"  + id);
        Student reponse = studentService.getStudentById(id);
        return reponse;
    }

    @RequestMapping(value = "api/v1/student" , method = RequestMethod.PUT)
    public @ResponseBody Student saveStudent(@RequestBody Student student){
        System.out.println("StudentController.saveStudent - student :" + student);
        Student response = studentService.saveStudent(student);
        System.out.println("Student is save : " +response);
        return response;
    }

    @RequestMapping(value = "api/v1/student" , method = RequestMethod.DELETE)
    public String deleteStudentById(@RequestParam ("id")Long id){
        studentService.deleteStudent(id);
        return "Student has been deleted";
    }


    public static void main(String[] args) {
        SpringApplication.run(StudentController.class,args);
    }
}
