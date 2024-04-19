package home.practice.spring;

import home.practice.spring.domain.LibraryCard;
import home.practice.spring.service.LibraryCardservices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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

    @RequestMapping(value = "/api/v1/libraryCard", method = RequestMethod.GET)
    public LibraryCard getLibraryCardById(@RequestParam("id") Long id) {
        LOGGER.info("Id:{}", id);
        LibraryCard response = libraryCardservices.getLibraryCardById(id);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard/card-name", method = RequestMethod.GET)
    public LibraryCard findByCardName(@RequestParam("card-name") String cardName) {
        LOGGER.info("card name :{}", cardName);
        LibraryCard response = libraryCardservices.findLibraryCardByCardname(cardName);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard", method = RequestMethod.PUT)
    public @ResponseBody LibraryCard saveLibraryCard(@RequestBody LibraryCard libraryCard) {
        LOGGER.info("Library card:{}", libraryCard);
        LibraryCard response = libraryCardservices.saveLibraryCard(libraryCard);
        return response;
    }

    @RequestMapping(value = "/api/v1/libraryCard", method = RequestMethod.DELETE)
    public String deleteLibraryCard(@RequestParam("id") Long id) {
        LOGGER.info("ID : {}",id);
        libraryCardservices.deleteLibraryCard(id);
        return "LibraryCard deleted successfully ";
    }

    @RequestMapping(value = "/api/v1/libraryCard/card-number", method = RequestMethod.DELETE)
    public String deleteByCardNumber(@RequestParam("card-number") int cardNumber) {
        LOGGER.info("card-number : {}",cardNumber);
        libraryCardservices.deleteByCardNumber(cardNumber);
        return "Card number" + cardNumber + "has been deleted succssefully";
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryCardController.class,args);
    }

    public void makeChangeToVariable(int aVariable) {
        aVariable += 100;
        LOGGER.info("avariable:{}", aVariable);
    }

    public void makeChangeToVariable(LibraryCard libraryCard) {
        libraryCard.setCardName("makeChangeToVariable-cardName");
        libraryCard.setCardNumber(999);
        LOGGER.info(" libraryCard :{}", libraryCard);
        LOGGER.info("Library hashCode:{}", libraryCard);
    }
    public void testPassByValue() {
        int aVariable = 2;
        makeChangeToVariable(aVariable);
        LOGGER.info("Value of aVariable is :{}", aVariable);
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardName("testPassByValue-cardName");
        libraryCard.setCardNumber(111);
        makeChangeToVariable(libraryCard);
        LOGGER.info("Library Card:{}", libraryCard);
        LOGGER.info("Library Hash code:{}",libraryCard.hashCode());
    }
}
