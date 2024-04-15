package home.practice.spring;

import home.practice.spring.domain.LibraryCard;
import home.practice.spring.service.LibraryCardservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class LibraryCardController {
    @Autowired
    private LibraryCardservices libraryCardservices;


    @RequestMapping(value = "/api/v1/libraryCard" , method = RequestMethod.GET)
    public LibraryCard getLibraryCardById(@RequestParam("id") Long id ){
        System.out.println("LibaryCardController  getLibraryCardById - id" +id);
        LibraryCard response = libraryCardservices.getLibraryCardById(id);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard" , method = RequestMethod.PUT)
    public @ResponseBody LibraryCard saveLibraryCard(@RequestBody LibraryCard libraryCard){
        System.out.println("LibaryCardController.savelibraryCard - libraryCard : " + libraryCard);
        LibraryCard response = libraryCardservices.saveLibraryCard(libraryCard);
        System.out.println("LibaryCard is saved : " + response);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard" , method = RequestMethod.DELETE)
    public String deleteLibraryCard(@RequestParam("id")Long id){
        libraryCardservices.deleteLibraryCard(id);
        return "LibraryCard deleted successfully ";
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryCardController.class,args);
    }

}
