package home.practice.spring;

import home.practice.spring.domain.LibraryCard;
import home.practice.spring.service.LibraryCardservices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class LibraryCardController {
     private static final Logger LOGGER = LoggerFactory.getLogger(LibraryCardController.class);
    @Autowired
    private LibraryCardservices libraryCardservices;


    @RequestMapping(value = "/api/v1/libraryCard" , method = RequestMethod.GET)
    public LibraryCard getLibraryCardById(@RequestParam("id") Long id ){
        LOGGER.info("Id:{}",id);
        LibraryCard response = libraryCardservices.getLibraryCardById(id);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard/card-name" , method = RequestMethod.GET)
        public LibraryCard findByCardName(@RequestParam("card-name") String cardName){
        System.out.println("LibaryCardController  getLibraryCardById - cardName" +cardName);
        LOGGER.info("card name :{}",cardName);
        LibraryCard response = libraryCardservices.findLibraryCardByCardname(cardName);
        return response;
    }


    @RequestMapping(value = "/api/v1/libraryCard" , method = RequestMethod.PUT)
    public @ResponseBody LibraryCard saveLibraryCard(@RequestBody LibraryCard libraryCard){
        LOGGER.info("Library card:{}",libraryCard);
        LibraryCard response = libraryCardservices.saveLibraryCard(libraryCard);
        System.out.println("LibaryCard is saved : " + response);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard" , method = RequestMethod.DELETE)
    public String deleteLibraryCard(@RequestParam("id")Long id){
        libraryCardservices.deleteLibraryCard(id);
        return "LibraryCard deleted successfully ";
    }

    @RequestMapping(value = "/api/v1/libraryCard/card-number" , method=RequestMethod.DELETE )
    public String deleteByCardNumber(@RequestParam("card-number") int cardNumber){
        libraryCardservices.deleteByCardNumber(cardNumber);
        return "Card number" +cardNumber+ "has been deleted succssefully";
    }

    public static void main(String[] args) {

//        SpringApplication.run(LibraryCardController.class,args);

        LibraryCardController libraryCardController = new LibraryCardController();
        libraryCardController.testPassByValue();
    }

    public void makeChangeToVariable(int aVariable){
        aVariable += 100;
        System.out.println("makeChangeToVariable() - aVariable : " + aVariable);
        LOGGER.info("avariable:{}",aVariable);
    }

    public void makeChangeToVariable(LibraryCard libraryCard){
        libraryCard.setCardName("makeChangeToVariable-cardName");
        libraryCard.setCardNumber(999);
        System.out.println("makeChangeToVariable() - libraryCard : " + libraryCard);
        LOGGER.info(" libraryCard :{}",libraryCard);
        System.out.println("makeChangeToVariable() - libraryCard.hashCode() : " + libraryCard.hashCode());
        LOGGER.info("Library hashCode:{}",libraryCard);
    }

    public void testPassByValue(){
        int aVariable = 2;
        makeChangeToVariable(aVariable);
        System.out.println("Value of aVariable is : " + aVariable);
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardName("testPassByValue-cardName");
        libraryCard.setCardNumber(111);
        makeChangeToVariable(libraryCard);
        System.out.println("testPassByValue() - libraryCard : " + libraryCard);
        LOGGER.info("Library Card:{}",libraryCard);
        System.out.println("testPassByValue() - libraryCard.hashCode() : " + libraryCard.hashCode());
//        logger.info("Library Hash code:{}",libraryCard.hashCode());
    }


}
